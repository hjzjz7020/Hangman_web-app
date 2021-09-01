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
    @Insert("insert into game (ID, state, word, playerID) values (#{id}, 0, #{word}, #{playerId})")
    void saveNewGame(Game newGame);

    // find game by id.
    @Select("select * from game where ID=#{id}")
    Game getGame(String id);
}
