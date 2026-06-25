package com.java_framework.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java_framework.entity.BoardEntity;
import com.java_framework.entity.GenreEntity;
import com.java_framework.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {


private final BoardRepository boardRepository;


// Entityにセットする
public BoardEntity setEntity(
        String name,
        Integer genre,
        String content,
        String formatNowDate) {

    BoardEntity entity = new BoardEntity();

    entity.setName(name);
    entity.setContent(content);
    entity.setDate(formatNowDate);

    GenreEntity genreEntity = new GenreEntity();
    genreEntity.setId(genre);

    entity.setGenre(genreEntity);

    return entity;
}

// 現在日時取得
public String getNowDate() {

    LocalDateTime time = LocalDateTime.now();

    DateTimeFormatter day =
            DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm");

    return day.format(time);
}

public String findNameByID(int id) {
    return boardRepository.findNameById(id);
}

// 全件取得
public List<BoardEntity> findAllPosts() {
    return boardRepository.findAll();
}

// 保存
public void save(BoardEntity entity) {
    boardRepository.save(entity);
}

// ID検索
public BoardEntity findById(int id) {
    return boardRepository.findById(id).orElseThrow();
}

// 削除
public void delete(int id) {
    boardRepository.deleteById(id);
}

// ジャンル絞り込み
public List<BoardEntity> genreFilter(Integer genreId) {

    if (genreId != null) {
        return boardRepository.findByGenre_Id(genreId);
    }

    return boardRepository.findAll();
}


}
