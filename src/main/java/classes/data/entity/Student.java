package classes.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student extends User {

    @Column(name = "userName")
    @Getter
    @Setter
    private String userName;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_profile_id", nullable = false)
    @Getter
    @Setter
    private UserProfile userProfile;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "faculty_id")
    @Getter
    @Setter
    private Faculty faculty;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "practice_id")
    @Getter
    @Setter
    private Practice practice;
}
