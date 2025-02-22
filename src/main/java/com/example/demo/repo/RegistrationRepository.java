package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
