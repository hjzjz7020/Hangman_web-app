package com.dao;

import com.domain.Game;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * GameDao interface
 */
@Mapper
public interface GameDao {

    // save new game.
    @Insert("INSERT INTO game (ID, word, state, remainingGuesses, currentGuess) VALUES (#{id}, #{word}, 'ACTIVE', 10, #{currentGuess})")
    void insert(Game game);

    // find game by id.
    @Select("SELECT * FROM game WHERE ID=#{id}")
    Game select(String id);

    // update a game.
    @Update("UPDATE game SET state=#{gameState}, remainingGuesses=#{remainingGuesses}, currentGuess=#{currentGuess} WHERE ID=#{id}")
    void update(Game game);
}
