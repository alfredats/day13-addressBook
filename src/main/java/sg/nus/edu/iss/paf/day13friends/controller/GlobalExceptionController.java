package sg.nus.edu.iss.paf.day13friends.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import sg.nus.edu.iss.paf.day13friends.exception.AddressBookException;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value = {AddressBookException.class})
    protected ModelAndView handleAddressBookException(
        HttpServletRequest req,
        AddressBookException ex
    ) {
        /* see "Global Exception Handling: Using @Controller advice methods" 
           in https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc */

        final ModelAndView mav = new ModelAndView("error.html");
        mav.addObject("errorMsg",ex.getMessage());
        mav.setStatus(HttpStatus.BAD_REQUEST);
        ex.printStackTrace();

        return mav;
    }

    @ExceptionHandler(value = DataAccessException.class)
    protected ModelAndView handleDataAccessException(
        HttpServletRequest req,
        DataAccessException ex
    ) {
        final ModelAndView mav = new ModelAndView("error.html");
        mav.addObject("errorMsg", ex.getMessage());
        mav.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
        ex.printStackTrace();

        return mav;
    }



    
}
