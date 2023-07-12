package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolaMundo {
	
	@GetMapping("/inicio")
	public String holaMundo(Model model) {
		
		List<Item> items = new ArrayList<>();
		
		items.add(new Item(1, "Computador", 5));
		items.add(new Item(2, "Celular", 10));
		items.add(new Item(3, "Libro", 6));
		
		model.addAttribute("items", items);
		
		return "holamundo";
	}

}

