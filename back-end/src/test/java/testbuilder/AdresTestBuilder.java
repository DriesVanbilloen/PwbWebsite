package testbuilder;

import entity.Adres;

public class AdresTestBuilder {
    private static final Long ID = 0L;
    private static final String STRAAT = "Boerenkrijglaan";
    private static final String STAD = "Leuven";
    private static final int NUMMER = 33;
    private static final int POSTCODE = 3010;
    private static final String BUS = "1B";


    public Adres build(){
        return new Adres.Builder()
                .withId(ID)
                .withStraatNaam(STRAAT)
                .withStad(STAD)
                .withBus(BUS)
                .withHuisnummer(NUMMER)
                .withPostcode(POSTCODE)
                .withBus(BUS)
                .build();
    }
}
