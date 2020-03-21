package org.springframework.samples.escalade.web;


import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Service("/hello.htm")
public class HelloController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request, //
            HttpServletResponse response) throws ServletException, IOException {
    	String msg = " Bravo!";
        String now = (new Date()).toString() + msg;
        
        logger.info("Returning hello view with " + now );
        
        return new ModelAndView("/hellos/hello", "now",  now );    
               
        
    }
    
    
    @RequestMapping(value = "/voir/{param}", method = RequestMethod.GET)
    public ModelAndView voir(@PathVariable("param") Integer param) {
        logger.info("Running param controler with param=" + param);
        return new ModelAndView("/hellos/hello", "now", param);
    }

}