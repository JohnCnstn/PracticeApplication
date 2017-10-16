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
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "start_date")
    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    private Date start_date;

    @Column(name = "end_date")
    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    private Date end_date;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "headMaster_id", nullable = false)
    private HeadMaster headMaster;

    public Practice() {
    }

    public Practice(Date start_date, Date end_date, Student student, HeadMaster headMaster) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.student = student;
        this.headMaster = headMaster;
    }
}
