package com.kiosk.reosk.controller;

import com.kiosk.reosk.dto.OrdersDetailDTO;
import com.kiosk.reosk.entity.Menu;
import com.kiosk.reosk.entity.OrdersDetail;
import com.kiosk.reosk.service.MenuService;
import com.kiosk.reosk.service.ReoskService;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/reosk")
@Log4j2
public class ReoskController {

    @Autowired
    ReoskService reoskService;

    @GetMapping("/")
    public String index(HttpSession session) {

        session.setAttribute("onum", 1L);
        return "/reosk/index";
    }
    @GetMapping("/orderList")
    public String orderList(HttpSession session, Model model , @RequestParam("cartData") String body) throws Exception {
    	System.out.println("body :" + body);
        reoskService.saveOrder(body,session);
        
        Enumeration<String> attributes = session.getAttributeNames();
        while(attributes.hasMoreElements()){
            String attribute = attributes.nextElement();
            System.out.println("session : " + attribute + " : " + session.getAttribute(attribute));
        }
        
        
        
        Long onum = (Long) session.getAttribute("onum");
        
        List<OrdersDetailDTO> all_price = reoskService.getOrdersDetailByOnum(onum);

        Long b = all_price.stream().mapToLong(sum -> sum.getTotalPrice()).sum();

        model.addAttribute("orders", all_price);
        model.addAttribute("allPrice", b);
        System.out.println(model.getAttribute("orders"));

        return "/reosk/orderList";
    }

    @GetMapping("/Bpayment")
    public String Bpayment(Model model){
    	model.addAttribute("PonNum","1");
        return "/reosk/payment";
    }
    @GetMapping("/payment")
    public String payment(Model model){
    	
    	return "/reosk/payment";
    }


//    

    
    @GetMapping("/menutest")
    public	String	menu() {
    	return "/reosk/menutest";
    }
    
    @GetMapping("/product")
    public	String	product() {
    	return "/reosk/product";
    }
    
    
    @PostMapping("/cof")
    public String saveToSession(@RequestParam("value") String value, HttpSession session , Model model) {
    	session.setAttribute("myKey", value);
        model.addAttribute("sessionValue", value);
        return    "/reosk/index2"; 
    }
    @GetMapping("/loding")
    public String loding() {
    	return "/reosk/loding";
    }

}