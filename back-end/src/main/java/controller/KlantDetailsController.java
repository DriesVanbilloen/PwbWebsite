package controller;

import org.springframework.beans.factory.annotation.Autowired;
import service.KlantDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/klantendetails")
public class KlantDetailsController {

    @Autowired
    private KlantDetailsService klantenService;

    @RequestMapping(method = RequestMethod.GET, value="/all")
    public String getAlleKlanten(){
        klantenService.getAllKlantDetails();
        return "Een leuke klant";
    }
}
