package dto;

import entity.Adres;
import org.springframework.stereotype.Component;

@Component
public class AdresMapper {

    public AdresDto convertToDto(Adres adres){
        return new AdresDto.Builder()
                .withId(adres.getId())
                .withStraatNaam(adres.getStraatNaam())
                .withPostcode(adres.getPostcode())
                .withStad(adres.getStad())
                .withHuisnummer(adres.getHuisnummer())
                .build();
    }

    public Adres convertToEntity(AdresDto adresDto){
        return new Adres.Builder()
                .withId(adresDto.getId())
                .withStraatNaam(adresDto.getStraatNaam())
                .withStad(adresDto.getStad())
                .withPostcode(adresDto.getPostcode())
                .withHuisnummer(adresDto.getHuisnummer())
                .withBus(adresDto.getBus())
                .build();
    }
}
