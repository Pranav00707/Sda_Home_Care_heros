package com.sda.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sda.demo.model.User;
import com.sda.demo.service.UserService;
import com.sda.demo.util.ImageUtils;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService; // Inject UserService

    @GetMapping("/profile")
    public String showProfilePage(Model model, Authentication authentication) {
        String username = authentication.getName();
        User user = userService.getUserByEmail(username); // Use injected userService

        // Ensure user is not null before proceeding
        if (user != null) {
            User userCompressed = new User();
            userCompressed.setPhoto(ImageUtils.decompressImage(user.getPhoto()));
            userCompressed.setName(user.getName());
            userCompressed.setEmail(user.getEmail());
            userCompressed.setContact(user.getContact());
            userCompressed.setLocation(user.getLocation());

            String base64EncodedImage = ImageUtils.encodeToBase64(userCompressed.getPhoto());

            model.addAttribute("user", userCompressed);
            model.addAttribute("userImage", base64EncodedImage);

            return "userprofile";
        } else {
           
            return "error"; // You can create an "error" view
        }
    }
}
