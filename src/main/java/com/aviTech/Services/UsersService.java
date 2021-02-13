package com.aviTech.Services;

import com.aviTech.Models.Users;
import com.aviTech.Repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private static final Logger log= LoggerFactory.getLogger(UsersService.class);

    @Autowired
    UsersRepository usersRepository;

    public Users saveUser(Users users){
        try{
            log.info("inside saveUser()");
            usersRepository.save(users);
            log.info("==========saved user is:- {}",users);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  users;
    }

    public List<Users> getAllUsersService(){
        List<Users> users=null;
        try{
            log.info("calling getAllUsersService()");
           users=usersRepository.findAll();
           if(users.isEmpty()){
               log.error("Records are not presents in this table");
           }else {
               log.info("Records are presents in this table");
           }

        }catch(Exception e){

        }
        return users;
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


    public Users editUserService(Users users){
        Users ex_User=null;
        try{
            ex_User=usersRepository.getOne(users.getUserId());
            if(ex_User==null){
                log.error("Requested User is not present for ID:- {}",users.getUserId());
            }else {
                log.info("Requested user is present for ID:- {}",users.getUserId());
                ex_User.setCreatedBy(users.getCreatedBy());
                ex_User.setCreatedOn(users.getCreatedOn());
                ex_User.setLastModifiedBy(users.getLastModifiedBy());
                ex_User.setLastModifiesOn(users.getLastModifiesOn());
                ex_User.setName(users.getName());
                ex_User.setAddress(users.getAddress());
                ex_User.setMobile(users.getMobile());
                ex_User.setEmail(users.getEmail());
                ex_User.setOrganizationId(users.getOrganizationId());
                usersRepository.save(ex_User);
                log.info("=====================User is updated==========================");

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return ex_User;
    }


}
