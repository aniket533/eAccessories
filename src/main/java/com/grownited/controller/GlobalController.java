package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.grownited.entity.UserEntity;
import com.grownited.repository.CartRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class GlobalController {

    @Autowired
    CartRepository repoCart;

    @ModelAttribute
    public void addCartCountToModel(HttpSession session, Model model) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user != null) {
            int count = repoCart.getCartCountByUserId(user.getUserId());
            model.addAttribute("cartCount", count);
        } else {
            model.addAttribute("cartCount", 0);
        }
    }
}
