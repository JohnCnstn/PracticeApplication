package classes.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "practice")
public class Practice {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "startDate")
    @Getter
    @Setter
    private String startDate;

    @Column(name = "endDate")
    @Getter
    @Setter
    private String endDate;

//    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinColumn(name = "user_id")
//    @Getter
//    @Setter
//    private User user;
//
//    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinColumn(name = "headMaster_id")
//    @Getter
//    @Setter
//    private HeadMaster headMaster;
}
