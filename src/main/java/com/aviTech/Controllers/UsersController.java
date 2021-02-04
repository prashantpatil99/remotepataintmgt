package com.aviTech.Controllers;

import com.aviTech.Models.Users;
import com.aviTech.Services.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsersController {
    private static final Logger log= LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private UsersService usersService;

    @PostMapping("/saveUser")
    public String saveUserController(@RequestBody Users users){
        try{
            log.debug("Request for save User is:={}",users.getName());
            usersService.saveUser(users);
            log.debug("Saved User is:={}",users.getName());
        }catch(Exception e){
            e.printStackTrace();
        }
        return "saved User is:="+users.getName();
    }

    @DeleteMapping("/deleteUserById/{id}")
    public Optional<Users> deletebyId(@PathVariable long id){
        Optional<Users> user=null;
        try{
            log.info("Request for delete user id:- {}",id);
            user=usersService.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }




}
