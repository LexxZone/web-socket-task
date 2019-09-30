package ru.codeinside.websocket.model;

/**
 * @author Alexey Dvoryaninov
 * @since 2019-09-28
 */
public class Message {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        JOIN, // TODO maybe add to logic in further
        CHAT,
        LEAVE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
