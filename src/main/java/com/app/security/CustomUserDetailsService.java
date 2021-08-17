package com.app.security;

import com.app.dao.UserDao;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
//Этот сервис идет в базу данных
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) {        //username полученный из /login - email
        List<User> users = userDao.getUserByEmail(username);

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        User user = users.get(0);

        return new CustomUserDetails(user);
    }
}
