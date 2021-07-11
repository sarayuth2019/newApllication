package com.powergroup.util;


import com.powergroup.model.service.UserEntityRepository;
import com.powergroup.model.table.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContextUtil {

    @Autowired
    private UserEntityRepository userEntityRepository;

    public Optional<UserEntity> getUserDataFromContext() {
        User contextUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity optUserData = userEntityRepository.findByEmail(contextUser.getUsername());
        if (optUserData == null) {
            return Optional.empty();
        } else {
            return Optional.of(optUserData);
        }
    }

}
