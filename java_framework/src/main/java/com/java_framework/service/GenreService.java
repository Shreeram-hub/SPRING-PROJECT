package com.java_framework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java_framework.entity.GenreEntity;
import com.java_framework.repository.GenreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    public List<GenreEntity> findAll() {
        return genreRepository.findAll();
    }
}