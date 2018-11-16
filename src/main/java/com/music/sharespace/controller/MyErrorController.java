package com.music.sharespace.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

public class MyErrorController implements ErrorController {

    private Logger logger = LogManager.getLogger(MyErrorController.class);

    public String handleError(HttpServletRequest request, ModelMap modelMap) {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
