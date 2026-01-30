package com.poticard.api.namecard.model;

public class NamecardDto {

    // userId 값만 받는 request Dto
    public static class NamecardReq {
        private String userId;

        public NamecardReq() {
        }

        public NamecardReq(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

    // userId를 기준으로 조회한 명함의 상세 정보를 담는 Response Dto
    public static class NamecardRes {
        private String userId;
        private String name;
        private String email;
        private String url;
        private String affiliation;
        private String namecardTitle;
        private String phone;
        private String address;
        private String gender;
        private String color;
        private String typoFont;
        private String cardTexture;
        private Boolean logo;
        private Boolean qrcode;
        private String avatar;
        private String keywords;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAffiliation() {
            return affiliation;
        }

        public void setAffiliation(String affiliation) {
            this.affiliation = affiliation;
        }

        public String getNamecardTitle() {
            return namecardTitle;
        }

        public void setNamecardTitle(String namecardTitle) {
            this.namecardTitle = namecardTitle;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getTypoFont() {
            return typoFont;
        }

        public void setTypoFont(String typoFont) {
            this.typoFont = typoFont;
        }

        public String getCardTexture() {
            return cardTexture;
        }

        public void setCardTexture(String cardTexture) {
            this.cardTexture = cardTexture;
        }

        public Boolean getLogo() {
            return logo;
        }

        public void setLogo(Boolean logo) {
            this.logo = logo;
        }

        public Boolean getQrcode() {
            return qrcode;
        }

        public void setQrcode(Boolean qrcode) {
            this.qrcode = qrcode;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public NamecardRes(String userId, String name, String email, String url, String affiliation, String namecardTitle, String phone, String address, String gender, String color, String typoFont, String cardTexture, Boolean logo, Boolean qrcode, String avatar, String keywords) {
            this.userId = userId;
            this.name = name;
            this.email = email;
            this.url = url;
            this.affiliation = affiliation;
            this.namecardTitle = namecardTitle;
            this.phone = phone;
            this.address = address;
            this.gender = gender;
            this.color = color;
            this.typoFont = typoFont;
            this.cardTexture = cardTexture;
            this.logo = logo;
            this.qrcode = qrcode;
            this.avatar = avatar;
            this.keywords = keywords;
        }
    }
}
