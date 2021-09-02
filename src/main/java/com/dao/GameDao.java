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

    // Find all words.
    @Select("SELECT word FROM word")
    String[] loadWordList();

    // save new game.
    @Insert("INSERT INTO game (ID, word, state, remainingGuesses, currentGuess) VALUES (#{id}, #{word}, 0, 10, #{currentGuess})")
    void saveNewGame(Game game);

    // find game by id.
    @Select("SELECT * FROM game WHERE ID=#{id}")
    Game getGame(String id);

    // update a game.
    @Update("UPDATE game SET state=#{gameState}, remainingGuesses=#{remainingGuesses}, currentGuess=#{currentGuess} WHERE ID=#{id}")
    void updateGame(Game game);
}
