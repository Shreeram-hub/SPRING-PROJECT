package com.java_framework.validation;

import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoForbiddenWordValidator implements ConstraintValidator<NoForbiddenWord, String> {

	// 禁止ワードリスト
	private static final List<String> FORBIDDEN_WORDS = List.of("バカ", "アホ", "死ね");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.isBlank()) {
			return true; // 空チェックは @NotBlank に任せる
		}

		for (String word : FORBIDDEN_WORDS) {
			if (value.contains(word)) {
				return false;
			}
		}
		return true;
	}
}
