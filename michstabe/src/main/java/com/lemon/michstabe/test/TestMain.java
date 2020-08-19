package com.lemon.michstabe.test;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class TestMain {

    public static void main(String[] args) {
        String record = "最近很火的SpringCloud到底是什么呢？Spring Cloud是一系列框架的有序集合。它利用Spring Boot的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控";
        System.out.println(record.length());
        String substring = record.substring(0, 50);
        System.out.println(substring);


//        //构造一个带指定 Region 对象的配置类
//        Configuration cfg = new Configuration(Region.region2());
//        //...其他参数参考类注释
//        UploadManager uploadManager = new UploadManager(cfg);
//        //...生成上传凭证，然后准备上传
//        String ak = "f84KxnqzC4gnDMyTNURL0T7QsV1NDBa1nDXmAC1Z";
//        String sk = "nc3yABFhposIEQTMPz_sc3gd8ZYg4Kg7Oo5HwLwE";
//        String bn = "lemon-001";
//        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
//        String localFilePath = "E:\\个人娱乐\\love.jpg";
//        //默认不指定key的情况下，以文件内容的hash值作为文件名
//        String key = null;
//
//        Auth auth = Auth.create(ak, sk);
//        String upToken = auth.uploadToken(bn);
//
//        try {
//            Response response = uploadManager.put(localFilePath, key, upToken);
//            //解析上传成功的结果
//            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
//        } catch (QiniuException ex) {
//            Response r = ex.response;
//            System.err.println(r.toString());
//            try {
//                System.err.println(r.bodyString());
//            } catch (QiniuException ex2) {
//                //ignore
//            }
//        }

//        for (String key : keySet) {
//            MultipartFile multipartFile = multipartFileHashMap.get(key);
//            String contentType = multipartFile.getContentType();
//            //效验为图片
//            if (!contentType.contains("image")) {
//                return Result.error("不是图片类型的文件，上传失败！");
//            }
//
//            //文件大小验证
//            if (multipartFile.getSize() > 1024 * 1024 * 1024 * 5) {
//                return Result.error("文件太大，上传失败！");
//            }
//
//            //路径
////            String savePath = req.getServletContext().getRealPath("");
//            String savePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\";
//            savePath = savePath + "image\\article\\";
//            File file = new File(savePath);
//            if (!file.exists()) {
//                file.mkdirs();
//            }
//
//            //图片名：upload_原名字_日期.后缀名
//            String fileName = multipartFile.getOriginalFilename();
//            String lastName = fileName.substring(fileName.lastIndexOf("."), fileName.length());
//            String newFileName = String.valueOf(UUID.randomUUID());
//            String path = savePath + newFileName + lastName;
//            String src = "/image/article/" + newFileName + lastName;
//
//            try {
//                multipartFile.transferTo(new File(path));
//            } catch (IOException e) {
//                e.printStackTrace();
//                return Result.error(e.getMessage());
//            }

//            result.put("", "src");
//        }




    }

}
