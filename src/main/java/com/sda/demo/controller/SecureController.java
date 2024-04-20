package com.sda.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sda.demo.model.Worker;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class SecureController {

    @GetMapping("/securePage")
    public String securePage(HttpSession session, Model model) {
        if (session.getAttribute("loggedInWorker") != null) {
            // Worker is logged in, proceed with secure logic
            Worker loggedInWorker = (Worker) session.getAttribute("loggedInWorker");
            model.addAttribute("loggedInWorker", loggedInWorker);
            return "securePage";
        } else {
            // Worker is not logged in, redirect to the login page
            return "redirect:/LoginForWorker";
        }
    }
}

