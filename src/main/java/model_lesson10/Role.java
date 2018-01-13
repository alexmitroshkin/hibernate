package model_lesson10;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="role")
public class Role extends Model {

    private static final long serialVersionUID = -384042479514616171L;
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "role")
    private Set<User> users;

    public Role(){}

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
