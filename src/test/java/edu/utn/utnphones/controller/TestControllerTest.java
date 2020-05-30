package edu.utn.utnphones.controller;

import edu.utn.utnphones.domain.User;
import edu.utn.utnphones.exception.UserNotexistException;
import edu.utn.utnphones.projections.CallsByLineCant;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class TestControllerTest {
    UserController userController;
    CallController callController;

    @Before
    public void setUp() {
        userController = mock(UserController.class);
        callController = mock(CallController.class);
        ResponseEntity<List<CallsByLineCant>> responseEntity;
    }

    @Test
    public void testGetCallsByLineCantsOK() throws UserNotexistException {
        User user = User.builder().userId(1).build();
        when(userController.getUserById(1)).thenReturn(user);

            List<CallsByLineCant> list = new ArrayList<CallsByLineCant>();;
            CallsByLineCant callsByLineCant;
            list.add(callsByLineCant);
            when(callController.getCallsByLineCants(user.getUserId())).thenReturn(list);
                ResponseEntity.ok().body(list);
    }


    @Test
    public void testGetCallsByLineCantsEmpty(){

    }


    @Test(expected = UserNotexistException.class)
    public void testGetCallsByLineCantUserNotExist(){

    }
}
