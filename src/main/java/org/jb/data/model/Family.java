package org.jb.data.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "family")
public class Family {

    @Id
    @SequenceGenerator(name = "family_id_seq", sequenceName = "family_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "family_id_seq")
    private Integer id;
    private String address;
    private String notes;
    @OneToMany(mappedBy = "family", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Members> membersList;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                '}';
    }


    public List<Members> getMembersList() {
        return membersList;
    }

    public void setMembersList(List<Members> membersList) {
        this.membersList = membersList;
    }
}
