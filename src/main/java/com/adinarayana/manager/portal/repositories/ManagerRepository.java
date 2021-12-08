package com.adinarayana.manager.portal.repositories;

import com.adinarayana.manager.portal.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Manager findByEmailId(String emailId);
}
