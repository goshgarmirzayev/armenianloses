package az.onbir.tv.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@Entity
@XmlRootElement
@Table(name = "man")
public class Man implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "info")
    private String info;
    public Integer getId() {
        return id;
    }

    public Man setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public Man setInfo(String info) {
        this.info = info;
        return this;
    }
}
