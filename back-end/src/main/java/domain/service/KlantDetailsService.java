package domain.service;

import domain.db.KlantDetailsRepository;
import org.springframework.stereotype.Component;

@Component
public class KlantDetailsService {

    private final KlantDetailsRepository klantRepository;


    public KlantDetailsService(KlantDetailsRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

}