package com.springjdbc.bootjdbcexample;

import com.springjdbc.bootjdbcexample.dao.UserRepository;
import com.springjdbc.bootjdbcexample.entity.User;
import com.springjdbc.bootjdbcexample.service.Service;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ServiceMockitoTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    Service service;
    @Test
    public void getAllUsersTest() {
        List<User> myUser = new ArrayList<>();
        myUser.add(new User(1,"amritha","kavya","amru",22));
        myUser.add(new User(2,"atha","kav","amrufggsd",24));
        when(userRepository.allUsers()).thenReturn(myUser);
        assertEquals(2,service.allUsers().size());
    }
    @Test
    public void addUserTest() {
        User user = new User(444, "Kavya", "Amritha",  "kavyaAmritha@gmail.com",23);
        //List.of(user);
        //Collections.singleton(user);
        when(userRepository.saveUser(user)).thenReturn(user);
        assertEquals(user, service.saveUser(user));
    }
         @Test
     public void getUserByIdTest() {
        User user = new User(444, "Kavya", "Amritha","kavyaAmritha@gmail.com",21);
        when(userRepository.getById(anyInt())).thenReturn(user);
        assertEquals(user, service.getById(anyInt()));
     }
     @Test
    public void deleteUserTest(){
         User user = new User(444, "Kavya", "Amritha","kavyaAmritha@gmail.com",21);
         service.deleteById(anyInt());
         verify(userRepository,times(1)).deleteById(anyInt());

     }
     @Test
    public void updateUser(){
         User user = new User(444, "Kavya", "Amritha","kavyaAmritha@gmail.com",21);
         when(userRepository.updateUser(user)).thenReturn(user);
         assertEquals(user,service.updateUser(user));
    }
}
