package model_lesson10;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alex on 13.01.2018.
 */
@MappedSuperclass
public abstract class Model implements Serializable{

    private static final long serialVersionUID = -6588099302858074912L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    public Model() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
