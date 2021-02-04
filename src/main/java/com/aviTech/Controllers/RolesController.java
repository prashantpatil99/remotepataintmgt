package com.aviTech.Controllers;

import com.aviTech.Models.Roles;
import com.aviTech.Services.RolesService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class RolesController {
    private static final Logger log= LoggerFactory.getLogger(RolesController.class);
    @Autowired
    private RolesService rolesService;

    @PostMapping("/saveRole")
    public Roles saveRoleController(@RequestBody Roles roles){
        Roles roles1=null;
        try{
            roles1=rolesService.saveRoleService(roles);
            log.info("Saved Role={}",roles.getRoleType());
        }catch(Exception e){
            e.printStackTrace();
        }
        return  roles1;
    }

    @GetMapping("/getAllRoles")
    public List<Roles> getAllRoles(){
        List<Roles> roles=null;
            try{

                roles=rolesService.getAllRoles();
                //log.debug("Successfully all Roles are fetched");
            }catch (Exception e){
                e.printStackTrace();
            }
            return roles;
    }


    @GetMapping("/getRolesById/{rolesId}")
    public Optional<Roles> getRolesById(@PathVariable long rolesId){
        Optional<Roles> roles=null;
        try{
           roles= rolesService.getRoleById(rolesId);

        }catch (Exception e){
            e.printStackTrace();
        }
        return roles;
    }

    @DeleteMapping("/deleteRoleById/{rolesId}")
    public Optional<Roles> deleteRolesById(@PathVariable long rolesId){
        Optional<Roles> roles=null;
        String res=null;
        try{
            log.info("Request id for delete Role :={}",rolesId);
            roles=rolesService.deleteById(rolesId);

        }catch(Exception e){
            e.printStackTrace();
        }
        return  roles;
    }

    @PutMapping(value = "/editRole")
    public  String editRoles(@RequestBody Roles roles){
        Roles r=null;
        List<Roles> list=null;
        try{
            r=rolesService.editRole(roles);
        }catch(Exception e){
            e.printStackTrace();
        }

        return  r.toString();
    }

}
