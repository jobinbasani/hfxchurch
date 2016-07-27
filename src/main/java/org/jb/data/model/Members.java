package org.jb.data.model;

import javax.persistence.*;

/**
 * Created by jobinbasani on 7/26/16.
 */
@Entity
@Table(name = "members")
public class Members {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "member_id_seq", sequenceName = "member_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "member_id_seq")
    private Integer memberId;

    @ManyToOne
    private Family family;

    private String firstName;


    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Members{" +
                "memberId=" + memberId +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
