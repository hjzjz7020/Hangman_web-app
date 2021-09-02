package com.service.impl;

import com.dao.GameWordDao;
import com.service.GameWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gameWordService")
public class GameWordServiceImpl implements GameWordService {

    @Autowired
    private GameWordDao gameWordDao;

    // Load all target words.
    public String[] loadWordList() {
        return gameWordDao.loadWordList();
    }

}
