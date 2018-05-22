package entity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class KlantDetailsTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void whenNameEmpty_thenThrowIllegalArgumentException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("De naam mag niet leeg gelaten worden.");

        new KlantDetails.Builder()
                .withId(1L)
                .withNaam("")
                .build();
    }

    @Test
    public void whenAdresIsNull_thenThrowIllegalArgumentException() {
        exception.expectMessage("Het adres is verplicht.");
        exception.expect(IllegalArgumentException.class);

        new KlantDetails.Builder()
                .withId(1L)
                .withNaam("Naam")
                .withAdres(null)
                .build();
    }
}
