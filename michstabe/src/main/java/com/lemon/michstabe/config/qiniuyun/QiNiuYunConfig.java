package com.lemon.michstabe.config.qiniuyun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:qiniuyun.properties")
public class QiNiuYunConfig {

    @Value("${qiniuyun.accessKey}")
    private String accessKey;

    @Value("${qiniuyun.secretKey}")
    private String secretKey;

    @Value("${qiniuyun.bucket}")
    private String bucket;

    @Value("${qiniuyun.domain.link}")
    private String cdnLink;


    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getCdnLink() {
        return cdnLink;
    }

    public void setCdnLink(String cdnLink) {
        this.cdnLink = cdnLink;
    }
}
