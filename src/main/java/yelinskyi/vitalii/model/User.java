package yelinskyi.vitalii.model;

public class User {

    private Long id;

    private String nickname;

    public User(String nickname) {
        this.nickname = nickname;
    }

    public User(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

}
