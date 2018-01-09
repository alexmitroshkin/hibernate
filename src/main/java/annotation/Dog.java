package annotation;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="dog")
public class Dog  implements Serializable{

    private static final long serialVersionUID = 782778282365529264L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkDog")
    private long id;
    @Column(name = "name")
    private String name;
    @OneToOne(mappedBy = "dog")
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
