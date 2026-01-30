package com.poticard.api.namecard.model;

public class NamecardCreateDto {

    // 명함 새로 생성할때 필요한 정보들
    public static class Register {
        private String userId;
        private String namecardTitle;
        private String layoutType;
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

        public String getNamecardTitle() {
            return namecardTitle;
        }

        public void setNamecardTitle(String namecardTitle) {
            this.namecardTitle = namecardTitle;
        }

        public String getLayoutType() {
            return layoutType;
        }

        public void setLayoutType(String layoutType) {
            this.layoutType = layoutType;
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

        public Register(String userId, String namecardTitle, String layoutType, String color, String typoFont, String cardTexture, Boolean logo, Boolean qrcode, String avatar, String keywords) {
            this.userId = userId;
            this.namecardTitle = namecardTitle;
            this.layoutType = layoutType;
            this.color = color;
            this.typoFont = typoFont;
            this.cardTexture = cardTexture;
            this.logo = logo;
            this.qrcode = qrcode;
            this.avatar = avatar;
            this.keywords = keywords;
        }
        public Register() {

        }
    }
    public static class Response{
        private Boolean success;

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public Response(Boolean success) {
            this.success = success;
        }
    }
}
