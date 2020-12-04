package com.example.datetime.controllers;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateTimeController {

	@RequestMapping("/")
	public String index(Model model) {
		String name = "Human";
		model.addAttribute("name", name);
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat myDateFormat = new SimpleDateFormat("EEEE, 'the' d 'of' MMMMM, yyyy");
		String formattedDate = myDateFormat.format(new java.util.Date());

		model.addAttribute("test_date", formattedDate);
		return "date.jsp";
	}

	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat myTimeFormat = new SimpleDateFormat("h:mm a");
		String formattedTime = myTimeFormat.format(new java.util.Date());
		model.addAttribute("test_time", formattedTime);
		return "time.jsp";
	}

}
