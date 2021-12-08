package com.adinarayana.manager.portal.services;

import com.adinarayana.manager.portal.models.Employee;
import com.adinarayana.manager.portal.models.Manager;
import com.adinarayana.manager.portal.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public Manager addManager(Manager manager) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        manager.setPassword(bCryptPasswordEncoder.encode(manager.getPassword()));
        return managerRepository.save(manager);
    }

    public List<Manager> retrieveManagers() {
        return managerRepository.findAll();
    }

    public Manager updateManager(Manager manager) throws Exception {
        Optional<Manager> manager1 = managerRepository.findById(manager.getManagerPk());
        if(!manager1.isPresent()) {
            throw new Exception("User Not Found");
        }
        Manager updateManagerDetails = manager1.get();
        updateManagerDetails.setFirstName(manager.getFirstName());
        updateManagerDetails.setLastName(manager.getLastName());
        updateManagerDetails.setAddress(manager.getAddress());
        updateManagerDetails.setCompanyName(manager.getCompanyName());
        updateManagerDetails.setBirthDate(manager.getBirthDate());
        return managerRepository.save(updateManagerDetails);
    }

    public void deleteManager(Manager manager) {
        managerRepository.deleteById(manager.getManagerPk());
    }
}
