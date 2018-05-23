package service;

import repository.KlantDetailsRepository;
import entity.KlantDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlantDetailsService {

    private final KlantDetailsRepository klantRepository;

    public KlantDetailsService(KlantDetailsRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    public List<KlantDetails> getAllKlantDetails(){
        return this.klantRepository.findAll();
    }

    public void createNewKlantDetails(KlantDetails klantDetails) {
        this.klantRepository.saveAndFlush(klantDetails);
    }
}