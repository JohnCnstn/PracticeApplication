package classes.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persistent_logins")
public class PersistentLogin {

    @Id
    @Column(name = "series")
    @Getter
    @Setter
    private String series;

    @Column(name = "userName")
    @Getter
    @Setter
    private String username;

    @Column(name = "token")
    @Getter
    @Setter
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date last_used;
}
