package org.jb.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "family")
public class Family {

    @Id
    @SequenceGenerator(name = "family_id_seq", sequenceName = "family_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "family_id_seq")
    private Integer id;
    private String address;
    private String notes;

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
        return "Family ID=" + id;
    }

}
