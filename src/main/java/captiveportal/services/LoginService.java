package captiveportal.services;


//import captiveportal.repository.CustomizedOptionsRepository;
import captiveportal.exceptions.InputValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
public class LoginService {

    @Value("${providers}")
    private String[] providers;

    @Value("${hotelIdentifiers}")
    private String[] hotelIdentifiers;


    @Autowired
    private AppendParametersService appendParametersService;

//    @Autowired
//    private CustomizedOptionsRepository customizedOptionsRepository;

    public String appendRequestParametersToModelAndReturnLoginPage(String hotelID, String hardwareProvider, Map<String, String> allRequestParams, Map<String, Object> model){
        if(Arrays.asList(providers).contains(hardwareProvider) && Arrays.asList(hotelIdentifiers).contains(hotelID)){
            return appendRequestParametersToModelAndReturnLoginPageForVenue(hardwareProvider, hotelID,allRequestParams, model);
        }
        else{
            throw new InputValidationException("The hardware provider or hotel identifier is not supported.");
        }
    }


    public String appendRequestParametersToModelAndReturnLoginPageForVenue(String hardwareProvider, String hotelID, Map<String, String> allRequestParams, Map<String, Object> model){
        model = appendParametersService.appendRequestParametersToModel(hardwareProvider, allRequestParams, model);
        addCustomizedStyleToModel(model, hotelID);
            switch(hardwareProvider) {
                case "meraki":
                    return "login-page-meraki";
                case "cisco":
                    return "login-page-cisco";
                case "ruckus-sz":
                    return "login-page-ruckus-zd";
                case "ruckus-zd":
                    return "login-page-ruckus-sz";
                case "ruckus-unleashed":
                    return "login-page-ruckus-sz";
                case "aruba-instant":
                    return "login-page-aruba-instant";
                case "aruba":
                    return "login-page-aruba";
                default:
                    return "error";
            }
    }

//    get customized model map entries from repository and add to model
    public void addCustomizedStyleToModel(Map<String, Object> model, String venue){
        model.put("message", "Welcome this is the test login page");
//        customizedOptionsRepository.findById();
    }



}
