package com.aviTech.ServicesTest;

import com.aviTech.Models.Users;
import com.aviTech.Repositories.UsersRepository;
import com.aviTech.Services.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UsersService usersService ;

    @MockBean
    private UsersRepository usersRepository ;

    @Test
    public void saveUserTest(){
        Users users=new Users( 2,  "Hanmant Tone",  "hanmanttone@gmail.com",  "6789543", "yelavi", "Hanmant Tone", "13-FEB-2021",  "Hanmant Tone", "13-FEB-2021", 2);
        when(usersRepository.save(users)).thenReturn(users);
        assertEquals(users,usersService.saveUser(users));
    }

}
