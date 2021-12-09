package com.adinarayana.manager.portal.controllers;

import com.adinarayana.manager.portal.models.Manager;
import com.adinarayana.manager.portal.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @PostMapping("/")
    public Manager postEmployee(@Valid @RequestBody Manager manager) {
        return managerService.addManager(manager);
    }
}
