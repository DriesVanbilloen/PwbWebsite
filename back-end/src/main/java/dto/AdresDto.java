package dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AdresDto {

    private Long id;

    @NotEmpty(message = "{adres.straat}")
    private String straatNaam;

    @NotEmpty(message = "{adres.stad}")
    private String stad;

    private String bus;

    @Min(value = 1 , message = "{adres.huisnummer}")
    private int huisnummer;

    @NotNull(message = "{adres.postcode}")
    private int postcode;


    private AdresDto(Builder builder){
        this.id = builder.id;
        this.straatNaam = builder.straatNaam;
        this.stad = builder.stad;
        this.bus = builder.bus;
        this.huisnummer = builder.huisnummer;
        this.postcode = builder.postcode;
    }

    private AdresDto(){

    }

    public Long getId() {
        return id;
    }

    public String getStraatNaam() {
        return straatNaam;
    }

    public String getStad() {
        return stad;
    }

    public String getBus() {
        return bus;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public int getPostcode() {
        return postcode;
    }

    public static class Builder{
        private Long id;
        private String straatNaam, stad, bus;
        private int huisnummer, postcode;

        public AdresDto build(){
            return new AdresDto(this);
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withStraatNaam(String straatNaam) {
            this.straatNaam = straatNaam;
            return this;
        }

        public Builder withStad(String stad) {
            this.stad = stad;
            return this;
        }

        public Builder withBus(String bus) {
            this.bus = bus;
            return this;
        }

        public Builder withHuisnummer(int huisnummer) {
            this.huisnummer = huisnummer;
            return this;
        }

        public Builder withPostcode(int postcode) {
            this.postcode = postcode;
            return this;
        }
    }
}