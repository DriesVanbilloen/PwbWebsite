package dto;

import entity.KlantDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KlantDetailsMapper {

    @Autowired
    private AdresMapper adresMapper;

    public KlantDetailsDto convertToDto(KlantDetails details){
        return new KlantDetailsDto.Builder()
                .withId(details.getId())
                .withNaam(details.getNaam())
                .withVoornaam(details.getVoornaam())
                .withAdres(adresMapper.convertToDto(details.getAdres()))
                .withEmail(details.getEmail())
                .withVereniging(details.isVereniging())
                .withRekeningIBAN(details.getRekeningIBAN())
                .build();
    }

    public List<KlantDetailsDto> convertListToListDto(List<KlantDetails> details){
        List<KlantDetailsDto> result = new ArrayList<KlantDetailsDto>();
        for(KlantDetails detail: details){
            result.add(convertToDto(detail));
        }
        return result;
    }

    public KlantDetails convertToEntity(KlantDetailsDto details) {
        return new KlantDetails.Builder()
                .withId(details.getId())
                .withNaam(details.getNaam())
                .withVoornaam(details.getVoornaam())
                .withAdres(adresMapper.convertToEntity(details.getAdres()))
                .withEmail(details.getEmail())
                .withVereniging(details.isVereniging())
                .withRekeningIBAN(details.getRekeningIBAN())
                .build();
    }
}
