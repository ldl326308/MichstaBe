package com.lemon.michstabe.controller;

import com.google.gson.Gson;
import com.lemon.michstabe.config.qiniuyun.QiNiuYunConfig;
import com.lemon.michstabe.dto.Result;
import com.qiniu.cdn.CdnManager;
import com.qiniu.cdn.CdnResult;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping(path = "/upload", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
public class UploadImage {

    // 七牛云 配置类注入
    private final QiNiuYunConfig qiNiuYunConfig;

    public UploadImage(QiNiuYunConfig qiNiuYunConfig) {
        this.qiNiuYunConfig = qiNiuYunConfig;
    }

    /**
     * 上传单个图片到七牛云，可自定义上传后的文件名称
     *
     * @param file
     * @param fileName
     * @return
     */
    @PostMapping(path = "/custom")
    public String uploadImageToNameIsCustom(MultipartFile file, String fileName) {
        if (file == null) {
            return Result.error("传输错误！");
        }
        try {
            // 文件转换成字节流
            InputStream inputStream = file.getInputStream();
            // 上传到七牛云存储
            String name = uploadImageToQiniuyun(qiNiuYunConfig.getAccessKey(), qiNiuYunConfig.getSecretKey(), qiNiuYunConfig.getBucket(), fileName, inputStream);
            // 判断是否上传成功
            if (name.equals("")) {
                return Result.error("上传存在失败记录！");
            }
            // 拼接外链链接
            String src = String.format("%s%s", qiNiuYunConfig.getCdnLink(), fileName);
            // 刷新单个文件
            boolean bool = refreshFile(qiNiuYunConfig.getAccessKey(), qiNiuYunConfig.getSecretKey(), src);
            if (!bool) {
                return Result.error("刷新文件失败！");
            }
            // 上传成功，返回 路径
            return Result.success("上传成功！", src);
        } catch (IOException e) {
            return Result.error("上传发生错误！");
        }
    }

    /**
     * 上传到 七牛云 文件哈希值作为文件的名称
     *
     * @param multipartFileHashMap
     * @return
     */
    @PostMapping
    public String uploadImageToNameIsHash(@RequestParam HashMap<String, MultipartFile> multipartFileHashMap) {
        // 用于保存图片信息
        List<HashMap> data = new ArrayList<>();
        // 获取所有的key
        Set<String> keySet = multipartFileHashMap.keySet();
        for (String key : keySet) {
            // 保存单条记录
            HashMap<String, Object> result = new HashMap<>();
            MultipartFile multipartFile = (MultipartFile) multipartFileHashMap.get(key);
            try {
                InputStream inputStream = multipartFile.getInputStream();
                String fileName = uploadImageToQiniuyun(qiNiuYunConfig.getAccessKey(), qiNiuYunConfig.getSecretKey(), qiNiuYunConfig.getBucket(), null, inputStream);
                if (fileName.equals("")) {
                    return Result.error("上传存在失败记录！");
                }
                // 拼接外链链接
                String src = String.format("%s%s", qiNiuYunConfig.getCdnLink(), fileName);
                // 上传成功，存放到Map集合，后统一返回
                result.put("key", key);
                result.put("url", src);
                data.add(result);
            } catch (IOException e) {
                return Result.error("上传发生错误！");
            }
        }

        // 统一返回
        return Result.success("上传成功！", data);
    }

//    @PostMapping
//    public String uploadImageToNameIsHash(@RequestParam("file") List<MultipartFile> list) {
//
//        if (list != null) {
//            for (MultipartFile multipartFile : list) {
//                System.out.println(multipartFile.getOriginalFilename());
//
//            }
//        }
//
//        // 统一返回
//        return Result.success("上传成功！");
//    }

    /**
     * 上传到 七牛云 存储
     * 默认不指定key的情况下，以文件内容的hash值作为文件名
     * 注：用文件内容的hash值作为文件名
     *
     * @param inputStream IO流（要上传的文件转成IO流）
     * @return
     */
    private static String uploadImageToQiniuyun(String accessKey, String secretKey, String bucket, String key, InputStream inputStream) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(inputStream, key, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
            return putRet.key; // 返回 文件hash值
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
                return "";
            } catch (QiniuException ex2) {
                return "";
            }
        }
    }


    /**
     * 批量刷新七牛云文件
     *
     * @param accessKey String类型 key
     * @param secretKey String类型 password
     * @param urls      String类型的一维数组 需要刷新的文件地址
     * @return
     */
    public static boolean refreshFiles(String accessKey, String secretKey, String[] urls) {
        Auth auth = Auth.create(accessKey, secretKey);
        CdnManager c = new CdnManager(auth);
        try {
            //单次方法调用刷新的链接不可以超过100个
            CdnResult.RefreshResult result = c.refreshUrls(urls);
            System.out.println(result.code);
            //获取其他的回复内容
            return true;
        } catch (QiniuException e) {
            System.err.println(e.response.toString());
            return false;
        }
    }


    /**
     * 单个刷新七牛云文件
     *
     * @param accessKey String类型 key
     * @param secretKey String类型 password
     * @param url       String类型 需要刷新的文件地址
     * @return
     */
    public static boolean refreshFile(String accessKey, String secretKey, String url) {
        Auth auth = Auth.create(accessKey, secretKey);
        CdnManager c = new CdnManager(auth);
        try {
            CdnResult.RefreshResult result = c.refreshUrls(new String[]{url});
            System.out.println(result.code);
            return true;
        } catch (QiniuException e) {
            System.err.println(e.response.toString());
            return false;
        }
    }

}
