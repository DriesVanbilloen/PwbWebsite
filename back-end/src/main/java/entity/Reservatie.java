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

    @ElementCollection
    @CollectionTable(name = "gekozen_zalen", joinColumns = @JoinColumn(name = "reservatie_id"))
    @Column(name = "zaal")
    private List<String> gekozenZalen;

    @OneToOne(cascade = CascadeType.ALL)
    private KlantDetails klantDetails;

//    @ElementCollection
//    @CollectionTable(name = "")
//    private List<String> gekozenDranken;

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

    public List<String> getZaalType() {
        return gekozenZalen;
    }

    public static class Builder{
        private Long id;
        private Date date;
        private KlantDetails klantDetails;
        private List<String> gekozenZalen;

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
    }
}
