package com.loginAppStruts2.interceptor;

import com.loginAppStruts2.model.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class MyInterceptor implements Interceptor {

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ValueStack valueStack = actionInvocation.getStack();
        User user = (User) valueStack.findValue("user");

        user.setUserName(user.getUserName().toUpperCase());

        valueStack.setValue("user",user);

        System.out.println(user.getUserName());

        return actionInvocation.invoke();
    }
}
