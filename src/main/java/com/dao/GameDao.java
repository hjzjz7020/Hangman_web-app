package com.dao;

import com.domain.Game;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * GameDao interface
 */
@Mapper
public interface GameDao {

    // Find all words.
    @Select("select word from word")
    String[] loadWordList();

    // save new game.
    @Insert("insert into game (state, word, playerID) values (0, #{word}, #{playerId})")
    void saveNewGame(Game newGame);
}
