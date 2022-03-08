package com.loginAppStruts2;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

public class UserImageSaveAction extends ActionSupport {

    private File userImage;
    private String userImageContentType;
    private String userImageFileName;

    public File getUserImage() {
        return userImage;
    }

    public void setUserImage(File userImage) {
        this.userImage = userImage;
    }

    public String getUserImageContentType() {
        return userImageContentType;
    }

    public void setUserImageContentType(String userImageContentType) {
        this.userImageContentType = userImageContentType;
    }

    public String getUserImageFileName() {
        return userImageFileName;
    }

    public void setUserImageFileName(String userImageFileName) {
        this.userImageFileName = userImageFileName;
    }

    @Override
    public String execute() throws IOException {
        ServletContext servletContext = ServletActionContext.getServletContext();
        String filePath = servletContext.getRealPath("/").concat("userimages");

        System.out.println("Image file location" + filePath);
        File fileToCreate = new File(filePath,userImageFileName);
        FileUtils.copyFile(userImage,fileToCreate);

        return SUCCESS;
    }
}
