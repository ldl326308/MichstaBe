package com.lemon.michstabe.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class User implements Serializable {
    private Long userId;

    private String userNickname;

    private String userAccount;

    private String userPassword;

    private String userEmail;

    private String userPortrait;

    private String userSignature;

    private String userCreateDate;

    private String userBirthday;

    private String userGender;

    private String userAddress;

    private String userPosition;

    private String userPhone;

    private String userQq;

    private String userMarkdownIntroduce;

    private String userHtmlIntroduce;

    private Integer userWhetherEmail;

    private Integer userWhetherGender;

    private Integer userWhetherBirthday;

    private Integer userWhetherAddress;

    private Integer userWhetherPosition;

    private Integer userWhetherPhone;

    private Integer userWhetherQq;

    private Integer userState;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait == null ? null : userPortrait.trim();
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature == null ? null : userSignature.trim();
    }

    public String getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(String userCreateDate) {
        this.userCreateDate = userCreateDate == null ? null : userCreateDate.trim();
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday == null ? null : userBirthday.trim();
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender == null ? null : userGender.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition == null ? null : userPosition.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq == null ? null : userQq.trim();
    }

    public Integer getUserWhetherEmail() {
        return userWhetherEmail;
    }

    public void setUserWhetherEmail(Integer userWhetherEmail) {
        this.userWhetherEmail = userWhetherEmail;
    }

    public Integer getUserWhetherGender() {
        return userWhetherGender;
    }

    public void setUserWhetherGender(Integer userWhetherGender) {
        this.userWhetherGender = userWhetherGender;
    }

    public Integer getUserWhetherBirthday() {
        return userWhetherBirthday;
    }

    public void setUserWhetherBirthday(Integer userWhetherBirthday) {
        this.userWhetherBirthday = userWhetherBirthday;
    }

    public Integer getUserWhetherAddress() {
        return userWhetherAddress;
    }

    public void setUserWhetherAddress(Integer userWhetherAddress) {
        this.userWhetherAddress = userWhetherAddress;
    }

    public Integer getUserWhetherPosition() {
        return userWhetherPosition;
    }

    public void setUserWhetherPosition(Integer userWhetherPosition) {
        this.userWhetherPosition = userWhetherPosition;
    }

    public Integer getUserWhetherPhone() {
        return userWhetherPhone;
    }

    public void setUserWhetherPhone(Integer userWhetherPhone) {
        this.userWhetherPhone = userWhetherPhone;
    }

    public Integer getUserWhetherQq() {
        return userWhetherQq;
    }

    public void setUserWhetherQq(Integer userWhetherQq) {
        this.userWhetherQq = userWhetherQq;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getUserMarkdownIntroduce() {
        return userMarkdownIntroduce;
    }

    public void setUserMarkdownIntroduce(String userMarkdownIntroduce) {
        this.userMarkdownIntroduce = userMarkdownIntroduce;
    }

    public String getUserHtmlIntroduce() {
        return userHtmlIntroduce;
    }

    public void setUserHtmlIntroduce(String userHtmlIntroduce) {
        this.userHtmlIntroduce = userHtmlIntroduce;
    }
}