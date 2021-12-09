package com.adinarayana.manager.portal.services;

import com.adinarayana.manager.portal.models.Role;
import com.adinarayana.manager.portal.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleDao;

    public Role findByName(String name) {
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}
