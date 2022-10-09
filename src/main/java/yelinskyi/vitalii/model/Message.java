package yelinskyi.vitalii.model;

public class Message {

    private Long id;
    private String dateTime;
    private User user;
    private String text;

    public Message(String dateTime, User user, String text) {
        this.dateTime = dateTime;
        this.user = user;
        this.text = text;
    }

    public String getDateTime() {
        return dateTime;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return dateTime
                + "_____" + user.getNickname()
                + ":_____" + text + '\'';
    }

}
