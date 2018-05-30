package controller;

import dto.ReservatieDto;
import entity.Reservatie;
import mapper.ReservatieMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ReservatieService;

import javax.validation.Valid;
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
        return reservatieMapper.convertListToDto(reservatieService.getAlleReservaties());
    }

    @RequestMapping(method= RequestMethod.GET, value = "/{reservatieId}")
    public ResponseEntity<ReservatieDto> getReservatieById(@PathVariable("reservatieId") Long id){
        return this.getResponseReservatie(reservatieService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> createReservatie(@RequestBody @Valid ReservatieDto reservatieDto) {
        this.reservatieService.createReservatie(this.reservatieMapper.convertToEntity(reservatieDto));
        return this.getResponseMessage("De reservatie is aangemaakt." , HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = "application/json", value = "/remove/{reservatieId}")
    public ResponseEntity<String> deleteReservatie(@PathVariable("reservatieId") Long reservatieId){
        this.reservatieService.removeReservatie(reservatieId);
        return this.getResponseMessage("De reservatie is verwijderd" , HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", value = "/update/{reservatieId}")
    public ResponseEntity<String> updateReservatie(@PathVariable("reservatieId")Long reservatieId, @RequestBody ReservatieDto reservatieDto){
        this.reservatieService.updateReservatieMetId(reservatieId, reservatieMapper.convertToEntity(reservatieDto));

        return this.getResponseMessage("De reservatie is geupdated" , HttpStatus.OK);
    }

    private ResponseEntity<String> getResponseMessage(String message, HttpStatus status){
        return new ResponseEntity<>(message, status);
    }

    private ResponseEntity<ReservatieDto> getResponseReservatie(Reservatie reservatie, HttpStatus status) {
        return new ResponseEntity<>(reservatieMapper.convertToDto(reservatie), status);
    }
}
