package captiveportal.controllers.captiveportal;


import captiveportal.exceptions.InputValidationException;
import captiveportal.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;


    //add input validation, hardwareProvider must be supported and hotelID must exist
    @RequestMapping(path="/{hotelID}/{hardwareProvider}",method = RequestMethod.GET)
    public String getLoginPage(@RequestParam Map<String, String> allRequestParams, @PathVariable String hotelID, @PathVariable String hardwareProvider, Map<String, Object> model) throws InputValidationException{
        return loginService.appendRequestParametersToModelAndReturnLoginPage(hotelID, hardwareProvider, allRequestParams, model);
    }



}
