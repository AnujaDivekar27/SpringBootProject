package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String getIndexPage()
	{
		System.out.println("Request Handler Method Called....");
		return "index";
	}
}
