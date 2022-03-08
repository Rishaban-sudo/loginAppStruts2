package com.loginAppStruts2;

import com.loginAppStruts2.dao.UserInfoDao;
import com.loginAppStruts2.model.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {
    private String userName;
    private String password;
    private String errorMsg;
    private SessionMap<String,Object> sessionMap;

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    //    @Override
//    public void validate() {
//
//        if (StringUtils.isEmpty(getUserName()) && StringUtils.isEmpty(getPassword())) {
//            addActionError("Fields can't be blank");
//            return;
//        }
//
//        if (StringUtils.isEmpty(getUserName())) {
//            addFieldError("userName","User Name cannot be blank!!");
//        }
//        if (StringUtils.isEmpty(getPassword())) {
//            addFieldError("password","Password cannot be blank!!");
//        }
//    }


    @Override
    public String execute() throws Exception {

        String status;

        UserInfoDao userInfoDao = UserInfoDao.getInstance();

        try {

            userInfoDao.connect();
            User user = userInfoDao.authenticateUser(userName,password);

            if (user != null) {
                sessionMap.put("user",user);
                status = SUCCESS;
                errorMsg = "";
            }
            else {
                status = LOGIN;
                errorMsg = "User Name or password is incorrect";
            }
        } finally {
            userInfoDao.disconnect();
        }


        System.out.println("End ...");

        return status;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap = (SessionMap<String, Object>) map;
    }
}
