package com.sda.demo.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Collections;
import java.util.List;

import javax.naming.AuthenticationException;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import com.sda.demo.dto.WorkerDto;
import com.sda.demo.model.Category;
import com.sda.demo.model.Worker;
import com.sda.demo.repo.WorkerRepo;
import com.sda.demo.service.Categoryservice;
import com.sda.demo.service.WorkerService;
import com.sda.demo.util.ImageUtils;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpSession;

@Controller
public class WorkerController {
	
    private static final Logger logger = (Logger) LoggerFactory.getLogger(WorkerController.class);
    @Autowired
    private WorkerService workerService;
    
    @Autowired Categoryservice categoryservice;
    
    @Autowired
    private WorkerRepo workerRepo; // Inject the repository

    @GetMapping("/worker")
    public String viewWorkerHomePage() {
        return "WorkerHome";
    }

    @GetMapping("/goToWorkerLogin")
    public String goToWorkerLogin() {
        return "LoginForWorker";
    }

    @GetMapping("/addNewWorker")
    public String addNewWorker(Model model) {
        WorkerDto worker = new WorkerDto();
        List<Category> categories=categoryservice.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("worker", worker);
        return "SignupForWorker";
    }

    @PostMapping("/saveWorker")
    public String saveWorker(@ModelAttribute("worker") WorkerDto workerdto) throws IOException {
           workerService.save(workerdto);
           return "redirect:/worker";
    }

    @GetMapping("/worker/someEndpoint")
    @PreAuthorize("hasRole('WORKER')")
    public String workerEndpoint() {
        // Your logic here
        return "workerPage";
    }

  
    
    @GetMapping("/allcategories")
	public String listCategories(Model model) {
		model.addAttribute("categories", categoryservice.getAllCategories());
		return "categories";
	}
    @GetMapping("/worker/WorkerHome")
    public String workerHomePage() {
        return "WorkerHome";
    }
    
   
    /*private AuthenticationManager authenticationManager;
    @PostMapping("/loginw")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
    	  // Server-side validation
        if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            model.addAttribute("loginError", true);
            model.addAttribute("validationError", "Please enter both email and password.");
            return "LoginForWorker";
        }

        try {
        	
        	
            // Authenticate worker
     org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Retrieve worker details
            Worker worker = workerService.findByEmail(email);

            // Check if the worker has the required role
            if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                    .anyMatch(role -> role.getAuthority().equals("ROLE_WORKER"))) {
                // Successful login
                return "redirect:/worker";
            } else {
                // Worker doesn't have the required role
                model.addAttribute("loginError", true);
                model.addAttribute("validationError", "Invalid worker credentials.");
                return "LoginForWorker";
            }
        } catch (Exception e) {
            // Failed login
            model.addAttribute("loginError", true);
            model.addAttribute("validationError", "Invalid worker credentials.");
            return "LoginForWorker";
        }
    }

	*/
	@GetMapping("/allworkers/{id}")
	public String listWorkers(@PathVariable Long id,Model model) {
		List<Worker> workers=workerService.getWorkersByCategory(id);
		for(Worker worker:workers) {
		    worker.setPhoto(ImageUtils.decompressImage(worker.getPhoto()));
		}
		model.addAttribute("workers", workers);
		return "workers";
	}
    
}