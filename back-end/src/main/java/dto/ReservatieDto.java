package dto;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ReservatieDto {

    private Long id;

    @NotNull(message = "reservatie.date.verplicht")
    @Future(message = "reservatie.date.toekomst")
    private Date date;

    private List<String> gekozenZalen;

    private Map<String, Integer> gekozenDranken;

    @Valid
    private KlantDetailsDto klantDetails;

    private boolean gasfriteuse;
    private boolean koffiemachine;
    private boolean champagneGlazen;
    private boolean eetGerief;
    private boolean receptieBeamer;

    @Min(value = 1, message = "reservatie.personen.negatief")
    private int aantalPersonen;

    private String beginuur;
    private String einduur;

    private ReservatieDto(Builder builder){
        this.id = builder.id;
        this.date = builder.date;
        this.klantDetails = builder.klantDetails;
        this.gekozenZalen = builder.gekozenZalen;
        this.gekozenDranken = builder.gekozenDranken;
        this.gasfriteuse = builder.gasfriteuse;
        this.koffiemachine = builder.koffiemachine;
        this.champagneGlazen = builder.champagneGlazen;
        this.eetGerief = builder.eetGerief;
        this.receptieBeamer = builder.receptieBeamer;
        this.aantalPersonen = builder.aantalPersonen;
        this.beginuur = builder.beginuur;
        this.einduur = builder.einduur;
    }

    private ReservatieDto(){

    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public KlantDetailsDto getKlantDetails() {
        return klantDetails;
    }

    public List<String> getGekozenZalen() {
        return gekozenZalen;
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

    public Map<String, Integer> getGekozenDranken() {
        return gekozenDranken;
    }

    public static class Builder{
        private Long id;
        private Date date;
        private KlantDetailsDto klantDetails;
        private List<String> gekozenZalen;
        private boolean gasfriteuse;
        private boolean koffiemachine;
        private boolean champagneGlazen;
        private boolean eetGerief;
        private boolean receptieBeamer;
        private Map<String, Integer> gekozenDranken;

        private int aantalPersonen;

        private String beginuur;
        private String einduur;

        public ReservatieDto build(){
            return new ReservatieDto(this);
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder withKlantDetails(KlantDetailsDto klantDetails) {
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
