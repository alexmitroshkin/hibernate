package annotation;

import java.io.Serializable;
import java.util.Set;

public class Friend implements Serializable {

    private static final long serialVersionUID = 8557377721020971606L;

    private long id;
    private String firstName;
    private String lastName;
    private Set<User> users;

    public Friend() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
