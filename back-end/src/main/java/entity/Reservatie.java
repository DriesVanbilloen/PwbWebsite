package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public class Reservatie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;

    private boolean gasfriteuse;
    private boolean koffiemachine;
    private boolean champagneGlazen;
    private boolean eetGerief;
    private boolean receptieBeamer;

    private int aantalPersonen;

    private String beginuur;
    private String einduur;

    @ElementCollection
    @CollectionTable(name = "gekozen_zalen", joinColumns = @JoinColumn(name = "reservatie_id"))
    @Column(name = "zaal")
    private List<String> gekozenZalen;

    @OneToOne(cascade = CascadeType.ALL)
    private KlantDetails klantDetails;

    @ElementCollection
    @MapKeyColumn(name = "drank_naam")
    @Column(name = "aantal")
    private Map<String, Integer> gekozenDranken;

    private Reservatie(Builder builder){
        this.id = builder.id;
        this.date = builder.date;
        this.klantDetails = builder.klantDetails;
        this.gekozenZalen = builder.gekozenZalen;
        this.einduur = builder.einduur;
        this.beginuur = builder.beginuur;
        this.eetGerief = builder.eetGerief;
        this.gasfriteuse = builder.gasfriteuse;
        this.champagneGlazen = builder.champagneGlazen;
        this.koffiemachine = builder.koffiemachine;
        this.gekozenDranken = builder.gekozenDranken;
        this.receptieBeamer = builder.receptieBeamer;
        this.aantalPersonen = builder.aantalPersonen;
    }

    private Reservatie(){

    }

    public void updateReservatie(Reservatie reservatie){
        this.date = reservatie.date;
        this.gekozenZalen = reservatie.gekozenZalen;
        this.klantDetails = reservatie.klantDetails;
        this.beginuur = reservatie.beginuur;
        this.einduur = reservatie.einduur;
        this.koffiemachine = reservatie.koffiemachine;
        this.champagneGlazen = reservatie.champagneGlazen;
        this.gasfriteuse = reservatie.gasfriteuse;
        this.eetGerief = reservatie.eetGerief;
        this.receptieBeamer = reservatie.receptieBeamer;
        this.aantalPersonen = reservatie.aantalPersonen;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public KlantDetails getKlantDetails() {
        return klantDetails;
    }

    public boolean isGasfriteuse() {
        return gasfriteuse;
    }

    public boolean isKoffiemachine() {
        return koffiemachine;
    }

    public boolean isChampagneGlazen() {
        return champagneGlazen;
    }

    public boolean isEetGerief() {
        return eetGerief;
    }

    public boolean isReceptieBeamer() {
        return receptieBeamer;
    }

    public int getAantalPersonen() {
        return aantalPersonen;
    }

    public String getBeginuur() {
        return beginuur;
    }

    public String getEinduur() {
        return einduur;
    }

    public List<String> getGekozenZalen() {
        return gekozenZalen;
    }

    public Map<String, Integer> getGekozenDranken() {
        return gekozenDranken;
    }

    public static class Builder{
        private Long id;
        private Date date;
        private KlantDetails klantDetails;
        private List<String> gekozenZalen;

        private boolean gasfriteuse;
        private boolean koffiemachine;
        private boolean champagneGlazen;
        private boolean eetGerief;
        private boolean receptieBeamer;

        private int aantalPersonen;

        private String beginuur;
        private String einduur;

        private Map<String, Integer> gekozenDranken;

        public Reservatie build(){
            return new Reservatie(this);
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder withKlantDetails(KlantDetails klantDetails) {
            this.klantDetails = klantDetails;
            return this;
        }

        public Builder withGekozenZalen(List<String> gekozenZalen) {
            this.gekozenZalen = gekozenZalen;
            return this;
        }

        public Builder withGasfriteuse(boolean gasfriteuse) {
            this.gasfriteuse = gasfriteuse;
            return this;
        }

        public Builder withKoffiemachine(boolean koffiemachine) {
            this.koffiemachine = koffiemachine;
            return this;
        }

        public Builder withChampagneGlazen(boolean champagneGlazen) {
            this.champagneGlazen = champagneGlazen;
            return this;
        }

        public Builder withEetGerief(boolean eetGerief) {
            this.eetGerief = eetGerief;
            return this;
        }

        public Builder withReceptieBeamer(boolean receptieBeamer) {
            this.receptieBeamer = receptieBeamer;
            return this;
        }

        public Builder withAantalPersonen(int aantalPersonen) {
            this.aantalPersonen = aantalPersonen;
            return this;
        }

        public Builder withBeginuur(String beginuur) {
            this.beginuur = beginuur;
            return this;
        }

        public Builder withEinduur(String einduur) {
            this.einduur = einduur;
            return this;
        }

        public Builder withGekozenDranken(Map<String, Integer> gekozenDranken) {
            this.gekozenDranken = gekozenDranken;
            return this;
        }
    }
}
