package org.springframework.samples.escalade.web;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/tests")
public class HelloAnnoController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView sayHello() {
        String now = (new Date()).toString();
        logger.info("Running " + this);
        return new ModelAndView("hello", "now", now);
    }

    @RequestMapping(value = "/plus10", method = RequestMethod.GET)
    public ModelAndView plus10(
            @RequestParam(value = "num", defaultValue = "100") Integer value) {
        logger.info("Running plus10 controler with param = " + value);
        return new ModelAndView("/hellos/hello", "now", value + 10);
    }
    
}