package com.java_framework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java_framework.entity.BoardEntity;



public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {

    @Query("SELECT b.name FROM BoardEntity b WHERE b.id = :id")
    String findNameById(@Param("id") int id);

    
    
     List<BoardEntity>findByGenre_Id(Integer genreId);
}
