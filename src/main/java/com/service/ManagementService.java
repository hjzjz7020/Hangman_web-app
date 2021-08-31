package com.service;

import com.domain.Game;

import java.util.List;

public interface ManagementService {

    // find all games.
    List<Game> findAll();
}
