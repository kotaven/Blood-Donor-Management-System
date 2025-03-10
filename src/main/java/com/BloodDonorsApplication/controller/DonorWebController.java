package com.BloodDonorsApplication.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.BloodDonorsApplication.entity.Donor;
import com.BloodDonorsApplication.repository.DonorRepository;

@Controller
public class DonorWebController {

    @Autowired
    private DonorRepository donorRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Welcome to the Blood Donor Management System!");
        return "index";  // Make sure 'index.html' exists in the templates folder
    }

    @GetMapping("/list")
    public String listDonors(Model model) {
        model.addAttribute("donors", donorRepository.findAll());
        return "donor_list";  // Ensure 'donor_list.html' exists in templates
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("donor", new Donor());
        return "add_donor";  // Ensure 'add_donor.html' exists in templates
    }
    
    @PostMapping("/save")
    public String saveDonor(@ModelAttribute Donor donor) {
        donorRepository.save(donor);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Donor> donor = donorRepository.findById(id);
        if (donor.isPresent()) {
            model.addAttribute("donor", donor.get());
            return "edit_donor";  
        }
        return "redirect:/list";
    }

    @PostMapping("/update/{id}")
    public String updateDonor(@PathVariable Long id, @ModelAttribute Donor donorDetails) {
        return donorRepository.findById(id).map(donor -> {
            donor.setName(donorDetails.getName());
            donor.setBloodGroup(donorDetails.getBloodGroup());
            donor.setContact(donorDetails.getContact());
            donorRepository.save(donor);
            return "redirect:/list";
        }).orElse("redirect:/list");
    }

    @GetMapping("/delete/{id}")
    public String deleteDonor(@PathVariable Long id) {
        donorRepository.deleteById(id);
        return "redirect:/list";
    }
}
