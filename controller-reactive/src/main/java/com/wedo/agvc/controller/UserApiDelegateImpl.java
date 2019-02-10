package com.wedo.agvc.controller;

import com.wedo.agvc.api.UserApiDelegate;
import com.wedo.agvc.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author forestyang
 * @date 2/9/2019
 */
@Service
public class UserApiDelegateImpl implements UserApiDelegate {

    @Override
    public Mono<ResponseEntity<User>> getUserByName(String username,
                                                    ServerWebExchange exchange) {
        User user = new User();
        user.setUsername(username);
        Mono<User> result = Mono.just(user);

        return result.map(u -> new ResponseEntity<>(u, HttpStatus.OK));

    }
}
