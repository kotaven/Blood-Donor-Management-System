package com.BloodDonorsApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "donors")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donor_seq")
    @SequenceGenerator(name = "donor_seq", sequenceName = "donor_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

    @Column(name = "contact", nullable = false)
    private String contact;

    public Donor() {}

    public Donor(String name, String bloodGroup, String contact) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.contact = contact;
    }

    public Long getId() {
    	return id; 
    	}
    public void setId(Long id) { 
    	this.id = id; 
    	}

    public String getName() { 
    	return name; 
    	}
    public void setName(String name) { 
    	this.name = name; 
    	}

    public String getBloodGroup() { 
    	return bloodGroup; 
    	}
    public void setBloodGroup(String bloodGroup) { 
    	this.bloodGroup = bloodGroup; 
    	}

    public String getContact() { 
    	return contact; 
    }
    public void setContact(String contact) {
    	this.contact = contact; 
    }
}
