package com.app.services;

import com.app.dao.UserDao;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User validateUser(User user) {
        if(!user.getFirstName().isEmpty() && !user.getLastName().isEmpty() &&
                !user.getEmail().isEmpty() && !user.getPhone().isEmpty()) {

            String phone = user.getPhone().trim().replaceAll("\\(", "")
                    .replaceAll("\\)", "");
            user.setPhone(phone);

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());//Захешировали пароль
            user.setPassword(encodedPassword);//Сохраняем этот пароль для пользователя который идет в базу данных

            userDao.storeUser(user);
            return user;
        }

        return null;
    }
}
