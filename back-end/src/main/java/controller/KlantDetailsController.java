package controller;

import domain.service.KlantDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/klantendetails")
public class KlantDetailsController {
    private final KlantDetailsService klantenService;

    public KlantDetailsController(KlantDetailsService klantenService) {
        this.klantenService = klantenService;
    }

    @RequestMapping(method = RequestMethod.GET, value="/all")
    public String getAlleKlanten(){
//        return klantenService.getAllKlantenDetails();
        return "Een leuke klant";
    }
}
