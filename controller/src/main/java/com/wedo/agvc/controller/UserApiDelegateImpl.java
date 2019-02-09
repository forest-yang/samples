package com.wedo.agvc.controller;

import com.wedo.agvc.api.UserApiDelegate;
import com.wedo.agvc.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author forestyang
 * @date 2/9/2019
 */
@Service
public class UserApiDelegateImpl implements UserApiDelegate {

    @Override
    public ResponseEntity<User> getUserByName(String username) {

        User user = new User();
        user.setUsername(username);
        user.setId(1L);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }
}
