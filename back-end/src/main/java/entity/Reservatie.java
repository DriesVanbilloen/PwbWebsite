package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservatie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    private KlantDetails klantDetails;

    private Reservatie(Builder builder){

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

    class Builder{
        private Long id;
        private Date date;
        private KlantDetails klantDetails;

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

        private void assertObjectValid(){

        }
    }
}
