package com.example.kartgp.controller_app;

import com.example.kartgp.bean.UserBean;
import com.example.kartgp.dao.UserDao;
import com.example.kartgp.entity.User;

import java.sql.SQLException;

public class UserControllerApp {

    //region get

    public static void login(UserBean userBean) throws Exception{
        UserDao userDao = new UserDao();
        User user = userDao.login(userBean.getUsername(), userBean.getPassword());
        userBean.setRole(user.getRole());
        userBean.setUsername(user.getUsername());
        userBean.setPassword(user.getPassword());
        userBean.setId(user.getId());
    }

    public static Boolean signing(UserBean userBean) throws Exception {
        UserDao userDao = new UserDao();
        userDao.signing(userBean.getUsername(), userBean.getPassword(), userBean.getRole());
        return true;
    }
    //endregion
}
