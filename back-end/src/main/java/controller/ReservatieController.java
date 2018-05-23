package controller;

import dto.ReservatieDto;
import entity.Reservatie;
import mapper.ReservatieMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ReservatieService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservatie")
public class ReservatieController {

    private final ReservatieService reservatieService;
    private final ReservatieMapper reservatieMapper;

    public ReservatieController(ReservatieService reservatieService, ReservatieMapper reservatieMapper) {
        this.reservatieService = reservatieService;
        this.reservatieMapper = reservatieMapper;
    }

    @RequestMapping(method = RequestMethod.GET , value = "/all")
    public List<ReservatieDto> getAlleReservaties(){
        this.reservatieService.createReservatie(
                new Reservatie.Builder()
                .withId(0L)
                .withKlantDetails(null)
                .withGekozenZalen(Arrays.asList("BreughelZaal" , "Keuken"))
                .withDate(new Date())
                .build()

        );
        return reservatieMapper.convertListToDto(reservatieService.getAlleReservaties());
    }
}
