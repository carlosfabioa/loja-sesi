package com.senai.loja.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class errorController implements ErrorController{
	@GetMapping("/error")
    public String handleError(HttpServletRequest request) {
	   Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == 403) {
                return "error/error-403";
            } else if (statusCode == 404) {
                return "error/error-404";
            } else if (statusCode == 500) {
                return "error/error-500";
            }
        }

        return "error/error";
    }
   
 
    
}
