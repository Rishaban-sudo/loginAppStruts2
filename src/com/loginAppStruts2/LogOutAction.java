package com.loginAppStruts2;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LogOutAction extends ActionSupport implements SessionAware {

    private SessionMap<String,Object> sessionMap;

    @Override
    public String execute() {
        System.out.println("Logout action start");

        if (sessionMap != null) {
            sessionMap.remove("user");
            sessionMap.invalidate();
        }

        System.out.println("logout finished!!");

        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap = (SessionMap<String, Object>) map;
    }
}
