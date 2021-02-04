package com.aviTech.Services;

import com.aviTech.Models.Users;
import com.aviTech.Repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private static final Logger log= LoggerFactory.getLogger(UsersService.class);

    @Autowired
    UsersRepository usersRepository;

    public void saveUser(Users users){
        try{
            log.info("inside saveUser()");
            usersRepository.save(users);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Optional<Users> deleteById(long id){
        Optional<Users> user=null;
        try{
            user=usersRepository.findById(id);
            if(user.isPresent()){
                usersRepository.deleteById(id);
                log.info("User Deleted by id:= {}",id);
            }else{
                log.info("User not find of given id:- {}",id);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }


}
