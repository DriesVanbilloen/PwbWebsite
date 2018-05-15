package controller;

import dto.KlantDetailsDto;
import dto.KlantDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.KlantDetailsService;

import java.util.List;

@RestController
@RequestMapping("/api/klantendetails")
public class KlantDetailsController {

    @Autowired
    private KlantDetailsService klantenService;

    @Autowired
    private KlantDetailsMapper klantDetailsMapper;

    @RequestMapping(method = RequestMethod.GET, value="/all")
    public List<KlantDetailsDto> getAlleKlanten(){
        return klantDetailsMapper.convertListToListDto(klantenService.getAllKlantDetails());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<?> createNewKlantDetails(@RequestBody KlantDetailsDto klantDetailsDto){
        klantenService.createNewKlantDetails(klantDetailsMapper.convertToEntity(klantDetailsDto));
        return getResponseMessage("Geslaagd", HttpStatus.CREATED);
    }

    private ResponseEntity<String> getResponseMessage(String message, HttpStatus status){
        return new ResponseEntity<String>(message, status);
    }
}
