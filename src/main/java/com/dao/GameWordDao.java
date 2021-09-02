package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * GameWordDao interface
 */
@Mapper
public interface GameWordDao {

    // Find all words.
    @Select("SELECT word FROM word")
    String[] loadWordList();
}
