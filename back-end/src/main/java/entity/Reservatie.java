package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Reservatie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ZaalType> gekozenZalen;

    @OneToOne(cascade = CascadeType.ALL)
    private KlantDetails klantDetails;

    private Reservatie(Builder builder){
        this.id = builder.id;
        this.date = builder.date;
        this.klantDetails = builder.klantDetails;
        this.gekozenZalen = builder.gekozenZalen;
    }

    private Reservatie(){

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
        private List<ZaalType> gekozenZalen;

        public Reservatie build(){
            assertObjectValid();
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

        public Builder withGekozenZalen(List<ZaalType> gekozenZalen) {
            this.gekozenZalen = gekozenZalen;
            return this;
        }

        public void assertObjectValid(){

        }
    }
}
