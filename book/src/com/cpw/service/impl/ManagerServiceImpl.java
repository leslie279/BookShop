package com.cpw.service.impl;

import com.cpw.dao.ManagerDao;
import com.cpw.dao.impl.ManagerDaoImpl;
import com.cpw.pojo.Manager;
import com.cpw.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao = new ManagerDaoImpl();

    @Override
    public Manager login(Manager user) {
        return managerDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (managerDao.queryUserByUsername(username) == null) {
            // 等于null,说明没查到，没查到表示可用
            return false;
        }
        return true;

    }
}
