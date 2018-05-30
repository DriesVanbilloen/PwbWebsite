package dto;

import java.util.Date;
import java.util.List;

public class ReservatieDto {
    private Long id;
    private Date date;
    private List<String> gekozenZalen;
    private KlantDetailsDto klantDetails;

    private ReservatieDto(Builder builder){
        this.id = builder.id;
        this.date = builder.date;
        this.klantDetails = builder.klantDetails;
        this.gekozenZalen = builder.gekozenZalen;
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

    public static class Builder{
        private Long id;
        private Date date;
        private KlantDetailsDto klantDetails;
        private List<String> gekozenZalen;

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
    }
}
