package com.BloodDonorsApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BloodDonorsApplication.entity.Donor;
import com.BloodDonorsApplication.repository.DonorRepository;

@RestController
@RequestMapping("/api/donors")
public class DonorRestController {

    @Autowired
    private DonorRepository donorRepository;

    @PostMapping
    public Donor addDonor(@RequestBody Donor donor) {
        return donorRepository.save(donor);
    }

    @GetMapping
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Donor> getDonorById(@PathVariable Long id) {
        return donorRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Donor updateDonor(@PathVariable Long id, @RequestBody Donor donorDetails) {
        return donorRepository.findById(id).map(donor -> {
            donor.setName(donorDetails.getName());
            donor.setBloodGroup(donorDetails.getBloodGroup());
            donor.setContact(donorDetails.getContact());
            return donorRepository.save(donor);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteDonor(@PathVariable Long id) {
        donorRepository.deleteById(id);
        return "Donor deleted id "+id+" successfully!";
    }
}
