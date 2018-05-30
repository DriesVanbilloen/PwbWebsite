package service;

import entity.Reservatie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ReservatieRepository;

import java.util.List;

@Service
public class ReservatieService {

    private final ReservatieRepository reservatieRepository;

    public ReservatieService(ReservatieRepository reservatieRepository) {
        this.reservatieRepository = reservatieRepository;
    }

    @Transactional
    public void createReservatie(Reservatie reservatie){
        this.reservatieRepository.saveAndFlush(reservatie);
    }

    public List<Reservatie> getAlleReservaties(){
        return this.reservatieRepository.findAll();
    }

    public void removeReservatie(Long id){
        this.reservatieRepository.delete(id);

    }

    public Reservatie findById(Long id) {
        return this.reservatieRepository.findOne(id);
    }
}
