package com.aviTech.ServicesTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.aviTech.Models.Roles;
import com.aviTech.Repositories.RolesRepository;
import com.aviTech.Services.RolesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
public class RolesServiceTest {

    @Autowired
    private RolesService  rolesService;

    @MockBean
    private RolesRepository rolesRepository;

    @Test
    public void getAllRolesTest(){
            when(rolesRepository.findAll()).thenReturn(Stream.of(new Roles(1,"Admin" ,"Prashant Patil","03-FEB-2021","Prashant Patil","03-FEB-2021"),
                                                                new Roles(1,"Admin" ,"Prashant Patil","03-FEB-2021","Prashant Patil","03-FEB-2021")
                                                                         ).collect(Collectors.toList()));
            assertEquals(2,rolesService.getAllRoles().size());
    }

    @Test
    public void  saveRoleTest() {
        Roles r=new Roles(1,"Admin" ,"Prashant Patil","03-FEB-2021","Prashant Patil","03-FEB-2021");
        when(rolesRepository.save(r)).thenReturn(r);
        assertEquals(r,rolesService.saveRoleService(r));
    }
}
