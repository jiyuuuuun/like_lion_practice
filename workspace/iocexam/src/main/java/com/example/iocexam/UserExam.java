package com.example.iocexam;

import com.example.iocexam.Controller.UserController;
import com.example.iocexam.config.UserConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserExam {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);

        UserController controller = (UserController) context.getBean("userController");
        controller.joinUser();

    }
}

