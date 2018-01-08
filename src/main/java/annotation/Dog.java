package annotation;

import java.io.Serializable;

public class Dog  implements Serializable{

    private static final long serialVersionUID = 782778282365529264L;

    private long id;
    private String name;
    private User user;

    public Dog() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
