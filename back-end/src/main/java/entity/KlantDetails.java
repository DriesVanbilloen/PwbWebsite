package entity;

import javax.persistence.*;


@Entity
public class KlantDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naam, voornaam, email;

    @OneToOne(cascade = CascadeType.ALL)
    private Adres adres;

    private boolean isVereniging;
    private String rekeningIBAN;

    private KlantDetails(Builder builder) {
        this.id = builder.id;
        this.naam = builder.naam;
        this.voornaam = builder.voornaam;
        this.email = builder.email;
        this.adres = builder.adres;
        this.isVereniging = builder.isVereniging;
        this.rekeningIBAN = builder.rekeningIBAN;
    }

    private KlantDetails() {
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

    public Adres getAdres() {
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
        private Adres adres;
        private boolean isVereniging;
        private String rekeningIBAN;

        public KlantDetails build() {
            assertValidObject();
            return new KlantDetails(this);
        }

        private void assertValidObject() {
            if (this.naam == null || naam.isEmpty()) {
                throw new IllegalArgumentException("De naam mag niet leeggelaten worden.");
            }
            if (voornaam == null || voornaam.isEmpty()) {
                throw new IllegalArgumentException("De voornaam mag niet leeggelaten worden");
            }
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

        public Builder withAdres(Adres adres) {
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