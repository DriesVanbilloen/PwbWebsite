package mapper;

import dto.KlantDetailsDto;
import entity.KlantDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class KlantDetailsMapper {

    private final AdresMapper adresMapper;

    @Autowired
    public KlantDetailsMapper(AdresMapper adresMapper) {
        this.adresMapper = adresMapper;
    }

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
        return details
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
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
