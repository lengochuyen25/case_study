package com.codegym.casestudybookmanagerment.controller;

import com.codegym.casestudybookmanagerment.model.Product;
import com.codegym.casestudybookmanagerment.model.User;
import com.codegym.casestudybookmanagerment.service.ProductService;
import com.codegym.casestudybookmanagerment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class SecurityController {

    @Autowired
    private ProductService productService;

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/")
    public ModelAndView listProducts(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Product> products;
        if(s.isPresent()){
            products=productService.findAllByNameContaining(s.get(),pageable);
        }else {
            products = productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/product/homepage");
        modelAndView.addObject("products", products);
        return modelAndView;
    }




}
