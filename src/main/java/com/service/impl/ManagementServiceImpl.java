package com.service.impl;

import com.dao.ManagementDao;
import com.domain.Game;
import com.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("managementService")
public class ManagementServiceImpl implements ManagementService {

    @Autowired
    private ManagementDao managementDao;

    // Find all accounts.
    public List<Game> findAll() {
        System.out.println("Business layer: find all games.");
        return managementDao.findAll();
    }
}
