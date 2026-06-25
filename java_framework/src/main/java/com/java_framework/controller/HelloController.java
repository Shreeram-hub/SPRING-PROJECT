
package com.java_framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String view() {
		return "index";
	}

	@GetMapping("/index")
	public String lesson() {
		return "lesson";
	}

}
