package cn.elmi.sample.mybatis.vo;

import java.util.Date;

public class ChatMessage extends BaseVo {
    private Integer id;

    private Integer selfId;

    private Byte contentType;

    private String content;

    private Integer fromId;

    private String userName;

    private String avatar;

    private Integer groupId;

    private String groupName;

    private String groupAvatar;

    private Integer chatId;

    private String chatName;

    private String chatAvatar;

    private Byte messageType;

    private String timestamp;

    private String createTimestamp;

    private Date createTime;

    private String topTimestamp;

    private Date topTime;

    private Boolean topMark;

    private Boolean shieldMark;

    private Boolean mine;

    private Integer userId;

    private String friendNote;

    private Integer offlineMessageNumber;

    private String filePath;

    private String voiceCall;

    private Boolean isRead;

    private Boolean isChatPageOpen;

    private Boolean isPlaying;

    private Boolean isShow;

    private Boolean isChecked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSelfId() {
        return selfId;
    }

    public void setSelfId(Integer selfId) {
        this.selfId = selfId;
    }

    public Byte getContentType() {
        return contentType;
    }

    public void setContentType(Byte contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupAvatar() {
        return groupAvatar;
    }

    public void setGroupAvatar(String groupAvatar) {
        this.groupAvatar = groupAvatar == null ? null : groupAvatar.trim();
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName == null ? null : chatName.trim();
    }

    public String getChatAvatar() {
        return chatAvatar;
    }

    public void setChatAvatar(String chatAvatar) {
        this.chatAvatar = chatAvatar == null ? null : chatAvatar.trim();
    }

    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp == null ? null : timestamp.trim();
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp == null ? null : createTimestamp.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTopTimestamp() {
        return topTimestamp;
    }

    public void setTopTimestamp(String topTimestamp) {
        this.topTimestamp = topTimestamp == null ? null : topTimestamp.trim();
    }

    public Date getTopTime() {
        return topTime;
    }

    public void setTopTime(Date topTime) {
        this.topTime = topTime;
    }

    public Boolean getTopMark() {
        return topMark;
    }

    public void setTopMark(Boolean topMark) {
        this.topMark = topMark;
    }

    public Boolean getShieldMark() {
        return shieldMark;
    }

    public void setShieldMark(Boolean shieldMark) {
        this.shieldMark = shieldMark;
    }

    public Boolean getMine() {
        return mine;
    }

    public void setMine(Boolean mine) {
        this.mine = mine;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFriendNote() {
        return friendNote;
    }

    public void setFriendNote(String friendNote) {
        this.friendNote = friendNote == null ? null : friendNote.trim();
    }

    public Integer getOfflineMessageNumber() {
        return offlineMessageNumber;
    }

    public void setOfflineMessageNumber(Integer offlineMessageNumber) {
        this.offlineMessageNumber = offlineMessageNumber;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getVoiceCall() {
        return voiceCall;
    }

    public void setVoiceCall(String voiceCall) {
        this.voiceCall = voiceCall == null ? null : voiceCall.trim();
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Boolean getIsChatPageOpen() {
        return isChatPageOpen;
    }

    public void setIsChatPageOpen(Boolean isChatPageOpen) {
        this.isChatPageOpen = isChatPageOpen;
    }

    public Boolean getIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(Boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }
}