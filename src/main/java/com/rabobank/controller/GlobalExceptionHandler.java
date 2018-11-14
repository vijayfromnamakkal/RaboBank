package com.rabobank.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author ksvijaynkl
 * Handler class for global exception
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * Method to handle error of file processing globally
     * @param e
     * @param redirectAttributes
     * @return String
     */
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:/uploadStatus";

    }

}
