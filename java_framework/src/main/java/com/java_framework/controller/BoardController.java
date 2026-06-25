package com.java_framework.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java_framework.entity.BoardEntity;
import com.java_framework.entity.GenreEntity;
import com.java_framework.service.BoardService;
import com.java_framework.service.GenreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final GenreService genreService;

    private List<GenreEntity> setGenreList() {
        return genreService.findAll();
    }

    // 一覧表示 + ジャンル絞り込み
    @GetMapping("/board")
    public String board(
            @RequestParam(required = false) Integer genre,
            Model model) {

        List<BoardEntity> posts = boardService.genreFilter(genre);

        model.addAttribute("posts", posts);
        model.addAttribute("genres", setGenreList());
        model.addAttribute("title", "掲示板");
        model.addAttribute("selectedGenre", genre);
        model.addAttribute("size", posts.size());
        return "board";
    }

    // 投稿画面表示
    @GetMapping("/input")
    public String input(Model model) {

        model.addAttribute("entity", new BoardEntity());
        model.addAttribute("genres", setGenreList());
        return "input";
    }
   

    // 編集画面表示
    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Integer id,
            Model model) {

        BoardEntity entity = boardService.findById(id);

        model.addAttribute("entity", entity);
        model.addAttribute("genres", setGenreList());

        return "edit";
    }

    // 投稿処理
    @PostMapping("/post")
    public String post(
            @Valid @ModelAttribute("entity") BoardEntity entity,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute("genres", setGenreList());

            return "/input";
        }

        boardService.save(entity);

        return "redirect:/board";
    }

    // 削除処理
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        boardService.delete(id);

        return "redirect:/board";
    }
}