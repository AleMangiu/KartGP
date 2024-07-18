package com.example.kartgp.controller_app;

import com.example.kartgp.bean.UserBean;
import com.example.kartgp.dao.UserDao;
import com.example.kartgp.entity.User;

import java.sql.SQLException;

public class UserControllerApp {

    private UserControllerApp() {
        throw new IllegalStateException("Utility class");
    }

    //region get

    public static void login(UserBean userBean) throws SQLException {
        UserDao userDao = new UserDao();
        User user = userDao.login(userBean.getUsername(), userBean.getPassword());
        userBean.setRole(user.getRoleEntity());
        userBean.setUsername(user.getUsernameEntity());
        userBean.setPassword(user.getPasswordEntity());
        userBean.setId(user.getIdEntity());
    }

    public static Boolean signing(UserBean userBean) throws SQLException {
        UserDao userDao = new UserDao();
        userDao.signing(userBean.getUsername(), userBean.getPassword(), userBean.getRole());
        return true;
    }
    //endregion
}
