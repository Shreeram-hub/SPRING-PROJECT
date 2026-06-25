
package com.java_framework.entity;

import com.java_framework.validation.NoForbiddenWord;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "board")

public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//投稿者

	@NotBlank(message = "投稿者名は必要です")
	private String name;

	
	@Size(min = 10, message = "本文は10文字以上入力してください")
	@NoForbiddenWord
	private String content;

	//日時
	private String date;

	//ジャンル
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private GenreEntity genre;

}
