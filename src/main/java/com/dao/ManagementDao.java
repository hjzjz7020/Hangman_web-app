package com.dao;

import com.domain.Game;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ManagementDao interface
 */
@Mapper
public interface ManagementDao {

    // Find all games.
    @Select("select * from game")
    List<Game> findAll();

}
