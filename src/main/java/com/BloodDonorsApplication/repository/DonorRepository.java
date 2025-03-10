package com.BloodDonorsApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BloodDonorsApplication.entity.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
}
