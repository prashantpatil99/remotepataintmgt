package com.aviTech.Services;

import com.aviTech.Models.Roles;
import com.aviTech.Repositories.RolesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    private static final Logger log= LoggerFactory.getLogger(RolesService.class);
    @Autowired
    private RolesRepository rolesRepository;

    public Roles saveRoleService(Roles roles){
       // Roles roles1=null;
        try{
            log.info("inside saveRoleService()");
            rolesRepository.save(roles);
            log.info("Role saved {}",roles);
        }catch(Exception e){
            e.printStackTrace();
        }
        return roles;
    }

    public List<Roles> getAllRoles(){
        List<Roles> allRoles=null;
        try{
            log.info("inside getAllRoles()");
              allRoles=rolesRepository.findAll();

              if(allRoles.isEmpty()){
                  log.error("Records are not present in this table");
              }else{
                  log.info("Records are present in this table");
              }

        }catch(Exception e){
            e.printStackTrace();
        }
        return  allRoles;

    }

    public Optional<Roles> getRoleById(long roleId){
        Optional<Roles> roles=null;
        try{
            roles=rolesRepository.findById(roleId);
            if(roles.isPresent()){
                log.info("Record is present by given id ={}",roleId);
                roles= rolesRepository.findById(roleId);
            }else{
                log.error("record is not present for given id = {}",roleId);

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return roles;
    }

    public Optional<Roles> deleteById(long rolesId){
        Optional<Roles> roles=null;

        try{
            roles=rolesRepository.findById(rolesId);
            if(roles.isPresent()){
                log.info("Record is present by given id ={}",rolesId);
                rolesRepository.deleteById(rolesId);
            }else{
                log.error("record is not present for given id = {}",rolesId);

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return roles;
    }


    public Roles editRole(Roles roles){
        Optional<Roles> r=null;
        Roles existingData=null;
        try{
            existingData=rolesRepository.getOne(roles.getRoleId());
            if(existingData==null){
                    log.error("Record id not available with id :={}",roles.getRoleId());
            }else{
                log.info("record is available with given id :={}",roles.getRoleId());
                existingData.setRoleType(roles.getRoleType());
                existingData.setCreatedOn(roles.getCreatedOn());
                existingData.setCreatedBy(roles.getCreatedBy());
                existingData.setLastModifiedBy(roles.getLastModifiedBy());
                existingData.setLastModifiedOn(roles.getLastModifiedOn());
                rolesRepository.save(existingData); //role isd is taken from the db we just add editable fields only
                log.info("=====================Role is updated==========================");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return  existingData;
    }
}
