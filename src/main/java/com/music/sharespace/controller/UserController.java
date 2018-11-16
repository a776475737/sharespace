package com.music.sharespace.controller;

import com.music.sharespace.domain.User;
import com.music.sharespace.service.filedirectory.FileDirectoryCreateService;
import com.music.sharespace.service.user.UserCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
public class UserController {

    @Autowired
    private UserCreateService userCreateService;

    @Autowired
    private FileDirectoryCreateService fileDirectoryCreateService;



    @RequestMapping("/createuserform")
    public String createUserForm(Model model){
        model.addAttribute("user", new User());
        return "createuser";
    }

    @RequestMapping(value="/createuser", method=RequestMethod.POST)
    public String createUser(@ModelAttribute User user){
        userCreateService.createUser(user);
        fileDirectoryCreateService.createFileDirectoryForUser(user.getUsername());
        return "redirect:/";
    }

}
