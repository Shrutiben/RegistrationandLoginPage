package com.registrationapp.registrationapp.Controller;

import com.registrationapp.registrationapp.Model.UserDtls;
import com.registrationapp.registrationapp.Service.UserService;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }
    @RequestMapping("/signin")
    public String login(){
        return "login";
    }
//
//    @RequestMapping("/register")
//    public String register(){
//        return "register";
//    }
//@RequestMapping(value="/register", method=RequestMethod.POST)
//public String registerUser(@RequestParam String username, HttpSession session) {
//    session.setAttribute("username", username);
//    return "redirect:/secondpage";
//}
//
//    @RequestMapping(value="/secondpage", method=RequestMethod.POST)
//    public String secondPage(HttpSession session) {
//        if (session.getAttribute("username") == null) {
//            return "redirect:/registration";
//        }
//        return "secondpage";
//    }
//
//    @RequestMapping(value = "/thirdpage", method = RequestMethod.POST)
//    public String page3(HttpServletRequest request, Model model) {
//
//        // Retrieve session data
//        HttpSession session = request.getSession();
//        String username = (String) session.getAttribute("username");
//        int age = (Integer) session.getAttribute("age");
//
//        // Add session data as attribute to the model
//        model.addAttribute("username", username);
//        model.addAttribute("age", age);
//
//        return "thirdpage";
//    }

    @GetMapping("/register")
    public String getFirstPage(Model model, HttpSession session) {
        // logic for page 1
        session.setAttribute("myAttribute", "myValue");

//        String username = (String) session.getAttribute("username");
//        String role = (String) session.getAttribute("role");
        return "register";
    }


    @PostMapping("/createUser")
    public String createUser(@ModelAttribute @RequestBody UserDtls user, HttpSession session){

        boolean f =userService.checkEmail(user.getEmail());

        if(f) {
//			System.out.println("user already registered");
            session.setAttribute("msg", "Email Id already exists");
        }
        else {
            UserDtls userDtls = userService.createUser(user);
            if(userDtls != null) {
                session.setAttribute("msg", "Register Successfully");
            }
            else {
                session.setAttribute("msg", "Something went wrong in server");
            }
        }
        return "redirect:/register";
    }
    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String password) {
        User user = userService.getUserByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            return "redirect:/login?error=true";
        }
        session.setAttribute("username", username);
        session.setAttribute("password", user.getPassword());
        return "redirect:/finalPage";
    }

}
