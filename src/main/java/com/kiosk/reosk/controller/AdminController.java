package com.kiosk.reosk.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiosk.reosk.entity.Prod;
import com.kiosk.reosk.entity.User;
import com.kiosk.reosk.service.ProdService;
import com.kiosk.reosk.service.UserService;

@Controller
@RequestMapping("/reosk")

public class AdminController {


	
	@GetMapping("/admin")
	public String admin(){
		
		return "/reosk/admin";
	}
	
	@GetMapping("/setup")
	public String setup(){
		
		return "/reosk/setup";
	}
	
	
	
}
