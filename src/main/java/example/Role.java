package example;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable {

    private static final long serialVersionUID = -8429349750683663523L;

    private long id;
    private String title;
    private Set<User> users;

    public Role(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
