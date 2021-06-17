package com.cpw.dao.impl;

import com.cpw.dao.ManagerDao;
import com.cpw.pojo.Manager;

public class ManagerDaoImpl extends BaseDao implements ManagerDao {
    @Override
    public Manager queryUserByUsername(String username) {
        String sql = "select `username`,`password` from t_manager where username = ?";
        return queryForOne(Manager.class, sql, username);
    }

    @Override
    public Manager queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `username`,`password`from t_manager where username = ? and password = ?";
        return queryForOne(Manager.class, sql, username,password);
    }

}
