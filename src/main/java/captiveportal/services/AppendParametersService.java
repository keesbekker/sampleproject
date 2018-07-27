package captiveportal.services;

import captiveportal.utils.MapUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AppendParametersService {

    public Map<String, Object> appendRequestParametersToModel(String hardwareProvider, Map<String, String> allRequestParams, Map<String, Object> model){
        switch(hardwareProvider){
            case "meraki": return appendRequestParametersToModelForMeraki(allRequestParams, model);
            case "cisco": return appendRequestParametersToModelForCiscoWLC(allRequestParams, model);
            case "ruckus-sz": return appendRequestParametersToModelForRuckusSZ(allRequestParams, model);
            case "ruckus-zd": return appendRequestParametersToModelForRuckusZD(allRequestParams, model);
            case "aruba-instant": return appendRequestParametersToModelForArubaInstant(allRequestParams, model);
            default: return model;
        }
    }


    public Map<String, Object> appendRequestParametersToModelForMeraki(Map<String, String> allRequestParams, Map<String, Object> model){
        model.put("login_url", allRequestParams.get("login_url"));
        model.put("continue_url", allRequestParams.get("continue_url"));
        model.put("username", "guest");
        model.put("password", "guest");
        return model;
    }

    public Map<String, Object> appendRequestParametersToModelForCiscoWLC(Map<String, String> allRequestParams, Map<String, Object> model){
        model.put("switch_url", allRequestParams.get("switch_url"));
        model.put("redirect_url", allRequestParams.get("redirect"));
        model.put("username", "guest");
        model.put("password", "guest");
        return model;

    }

    public Map<String, Object> appendRequestParametersToModelForRuckusSZ(Map<String, String> allRequestParams, Map<String, Object> model){
        model.put("provider", allRequestParams.get("provider"));
        model.put("allQueryParametersRuckusSZ", MapUtils.mapToString(allRequestParams));
        return model;

    }

    public Map<String, Object> appendRequestParametersToModelForRuckusZD(Map<String, String> allRequestParams, Map<String, Object> model){
        model.put("provider", allRequestParams.get("provider"));
        model.put("allQueryParametersRuckusZD", MapUtils.mapToString(allRequestParams));
        return model;

    }

    public Map<String, Object> appendRequestParametersToModelForArubaInstant(Map<String, String> allRequestParams, Map<String, Object> model){
        model.put("provider", allRequestParams.get("provider"));
        model.put("allQueryParametersArubaInstant", MapUtils.mapToString(allRequestParams));
        return model;
    }




}
