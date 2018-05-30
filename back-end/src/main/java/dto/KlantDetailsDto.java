package dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;

public class KlantDetailsDto {

    private Long id;

    @NotEmpty(message = "{klantdetails.naam}")
    private String naam;

    @NotEmpty(message = "{klantdetails.voornaam}")
    private String voornaam;

    @NotEmpty(message = "{klantdetails.email}")
    @Email(message = "{klantdetails.email.format}")
    private String email;

    @Valid
    private AdresDto adres;

    private boolean isVereniging;
    private String rekeningIBAN;

    private KlantDetailsDto(Builder builder){
        this.id = builder.id;
        this.naam = builder.naam;
        this.voornaam = builder.voornaam;
        this.email = builder.email;
        this.adres = builder.adres;
        this.isVereniging = builder.isVereniging;
        this.rekeningIBAN = builder.rekeningIBAN;
    }

    private KlantDetailsDto(){

    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getEmail() {
        return email;
    }

    public AdresDto getAdres() {
        return adres;
    }

    public boolean isVereniging() {
        return isVereniging;
    }

    public String getRekeningIBAN() {
        return rekeningIBAN;
    }

    public static class Builder {
        private Long id;
        private String naam, voornaam, email;
        private AdresDto adres;
        private boolean isVereniging;
        private String rekeningIBAN;

        public KlantDetailsDto build(){
            return new KlantDetailsDto(this);
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withNaam(String naam) {
            this.naam = naam;
            return this;
        }

        public Builder withVoornaam(String voornaam) {
            this.voornaam = voornaam;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withAdres(AdresDto adres) {
            this.adres = adres;
            return this;
        }

        public Builder withVereniging(boolean vereniging) {
            isVereniging = vereniging;
            return this;
        }

        public Builder withRekeningIBAN(String rekeningIBAN) {
            this.rekeningIBAN = rekeningIBAN;
            return this;
        }
    }
}