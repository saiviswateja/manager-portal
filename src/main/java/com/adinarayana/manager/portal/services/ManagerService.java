package com.adinarayana.manager.portal.services;

import com.adinarayana.manager.portal.models.Employee;
import com.adinarayana.manager.portal.models.Manager;
import com.adinarayana.manager.portal.models.Role;
import com.adinarayana.manager.portal.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private RoleService roleService;

    public Manager addManager(Manager manager) throws Exception {
        Manager manager1 = managerRepository.findByEmailId(manager.getEmailId());
        if(manager1!=null) {
            throw new Exception("User already exists");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        manager.setPassword(bCryptPasswordEncoder.encode(manager.getPassword()));
        Set<Role> roleSet = new HashSet<>();
        if (manager.getIsAdmin()==1) {
            Role role = roleService.findByName("ADMIN");
            roleSet.add(role);
        } else {
            Role role = roleService.findByName("ADMINTRAINEE");
            roleSet.add(role);
        }
        manager.setRoles(roleSet);
        return managerRepository.save(manager);
    }

    public List<Manager> retrieveManagers() {
        return managerRepository.findAll();
    }

    public Manager updateManager(Manager manager) throws Exception {
        Optional<Manager> manager1 = managerRepository.findById(manager.getManagerPk());
        if (!manager1.isPresent()) {
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
