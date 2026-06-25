package com.java_framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java_framework.entity.GenreEntity;

public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {

}