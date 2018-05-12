package service;

import repository.KlantDetailsRepository;
import entity.KlantDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlantDetailsService {

    @Autowired
    private KlantDetailsRepository klantRepository;

    public List<KlantDetails> getAllKlantDetails(){
        return this.klantRepository.findAll();
    }
}