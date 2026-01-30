package com.poticard.api.chat.model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

public class ChatDto {

    // 채팅방 생성 요청 DTO
    public static class ChatRoomCreateRequest {
        private Integer guestId;

        public ChatRoomCreateRequest() {
        }

        public ChatRoomCreateRequest(Integer guestId) {
            this.guestId = guestId;
        }

        public Integer getGuestId() {
            return guestId;
        }

        public void setGuestId(Integer guestId) {
            this.guestId = guestId;
        }
    }

    // 채팅방 생성 응답 DTO
    public static class ChatRoomCreateResponse {
        private Integer id;           // 채팅방 ID (또는 유저 ID)
        private String name;       // 상대방 이름
        private String company;    // 소속 회사
        private String role;       // 역할/직무
        private int unread;        // 읽지 않은 메시지 개수
        private String content;    // 마지막 메시지 내용
        private String[] tags; // 관련 태그 리스트
        private String avatar;     // 프로필 이미지 URL
        private String intro;

        public ChatRoomCreateResponse() {
        }

        public ChatRoomCreateResponse(Integer id, String name, String company, String role, int unread, String content, String[] tags, String avatar, String intro) {
            this.id = id;
            this.name = name;
            this.company = company;
            this.role = role;
            this.unread = unread;
            this.content = content;
            this.tags = tags;
            this.avatar = avatar;
            this.intro = intro;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public int getUnread() {
            return unread;
        }

        public void setUnread(int unread) {
            this.unread = unread;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String[] getTags() {
            return tags;
        }

        public void setTags(String[] tags) {
            this.tags = tags;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }
    }

    // 채팅방 불러오기 Response DTO
    public static class ChatRoomListReadResponse {
        private String avatar;
        private Long roomId;
        private String name;
        private String company;
        private String role;
        private Long unread;
        private String content;

        public ChatRoomListReadResponse() {
        }

        public ChatRoomListReadResponse(String avatar, Long roomId, String name, String company, String role, Long unread, String content) {
            this.avatar = avatar;
            this.roomId = roomId;
            this.name = name;
            this.company = company;
            this.role = role;
            this.unread = unread;
            this.content = content;
        }

        public Long getRoomId() {
            return roomId;
        }

        public void setRoomId(Long roomId) {
            this.roomId = roomId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Long getUnread() {
            return unread;
        }

        public void setUnread(Long unread) {
            this.unread = unread;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }

    // 채팅 메세지 전송 Request DTO
    public static class ChatMessageSendRequest {
        private String contents;
        private String contentType;

        public ChatMessageSendRequest() {
        }

        public ChatMessageSendRequest(String contents, String contentType) {
            this.contents = contents;
            this.contentType = contentType;
        }

        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }
    }

    // 채팅 메세지 전송 Response DTO
    public static class ChatMessageSendResponse {
        private Integer messageId;
        private Integer senderId;
        private String contents;
        private String contentType;
        private OffsetDateTime createdAt;

        public ChatMessageSendResponse() {
        }

        public ChatMessageSendResponse(Integer messageId, Integer senderId, String contents, String contentType, OffsetDateTime createdAt) {
            this.messageId = messageId;
            this.senderId = senderId;
            this.contents = contents;
            this.contentType = contentType;
            this.createdAt = createdAt;
        }

        public Integer getMessageId() {
            return messageId;
        }

        public void setMessageId(Integer messageId) {
            this.messageId = messageId;
        }

        public Integer getSenderId() {
            return senderId;
        }

        public void setSenderId(Integer senderId) {
            this.senderId = senderId;
        }

        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public OffsetDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
        }
    }

    // 채팅 내역 불러오기 ResponseDto
    public static class ChatRoomHistoryResponse {
        private Integer roomId;
        private String roomStatus;
        private UserInfo host;
        private UserInfo guest;
        private List<MessageDetail> messages;
        private int totalMessageCount;

        public ChatRoomHistoryResponse() {
        }

        public ChatRoomHistoryResponse(Integer roomId, String roomStatus, UserInfo host, UserInfo guest, List<MessageDetail> messages, int totalMessageCount) {
            this.roomId = roomId;
            this.roomStatus = roomStatus;
            this.host = host;
            this.guest = guest;
            this.messages = messages;
            this.totalMessageCount = totalMessageCount;
        }

        public Integer getRoomId() {
            return roomId;
        }

        public void setRoomId(Integer roomId) {
            this.roomId = roomId;
        }

        public String getRoomStatus() {
            return roomStatus;
        }

        public void setRoomStatus(String roomStatus) {
            this.roomStatus = roomStatus;
        }

        public UserInfo getHost() {
            return host;
        }

        public void setHost(UserInfo host) {
            this.host = host;
        }

        public UserInfo getGuest() {
            return guest;
        }

        public void setGuest(UserInfo guest) {
            this.guest = guest;
        }

        public List<MessageDetail> getMessages() {
            return messages;
        }

        public void setMessages(List<MessageDetail> messages) {
            this.messages = messages;
        }

        public int getTotalMessageCount() {
            return totalMessageCount;
        }

        public void setTotalMessageCount(int totalMessageCount) {
            this.totalMessageCount = totalMessageCount;
        }

        public static class UserInfo {
            private Integer userId;
            private String userName;

            public UserInfo() {
            }

            public UserInfo(Integer userId, String userName) {
                this.userId = userId;
                this.userName = userName;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }
        }

        public static class MessageDetail {
            private Integer messageId;
            private Integer senderId;
            private String content;
            private String contentType;
            private boolean isRead;
            private OffsetDateTime createdAt;
            private OffsetDateTime updatedAt;

            public MessageDetail() {
            }

            public MessageDetail(Integer messageId, Integer senderId, String content, String contentType, boolean isRead, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
                this.messageId = messageId;
                this.senderId = senderId;
                this.content = content;
                this.contentType = contentType;
                this.isRead = isRead;
                this.createdAt = createdAt;
                this.updatedAt = updatedAt;
            }

            public Integer getMessageId() {
                return messageId;
            }

            public void setMessageId(Integer messageId) {
                this.messageId = messageId;
            }

            public Integer getSenderId() {
                return senderId;
            }

            public void setSenderId(Integer senderId) {
                this.senderId = senderId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getContentType() {
                return contentType;
            }

            public void setContentType(String contentType) {
                this.contentType = contentType;
            }

            public boolean isRead() {
                return isRead;
            }

            public void setRead(boolean read) {
                isRead = read;
            }

            public OffsetDateTime getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(OffsetDateTime createdAt) {
                this.createdAt = createdAt;
            }

            public OffsetDateTime getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(OffsetDateTime updatedAt) {
                this.updatedAt = updatedAt;
            }
        }
    }
}
