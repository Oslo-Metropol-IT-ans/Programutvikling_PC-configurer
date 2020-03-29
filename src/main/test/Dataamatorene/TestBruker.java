package Dataamatorene;

import Dataamatorene.Brukere.BrukerValidering;
import Dataamatorene.Datakomponenter.KomponentValidering;
import Dataamatorene.Exceptions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBruker {

    @Test
    public void testValidBrukernavn() {
        BrukerValidering.sjekkBrukernavn("Admin");
    }

    @Test
    public void testInvalidBrukernavn() {
        assertThrows(InvalidBrukerException.class, () -> BrukerValidering.sjekkBrukernavn("Admin 123"));
        assertThrows(InvalidBrukerException.class, () -> BrukerValidering.sjekkBrukernavn(" Admin123"));
        assertThrows(InvalidBrukerException.class, () -> BrukerValidering.sjekkBrukernavn("Admin123 "));
    }

    @Test
    public void testValidPassword() {
        BrukerValidering.sjekkPassord("Admin123");
    }

    @Test
    public void testInvalidPassword() {
        assertThrows(InvalidPasswordException.class, () -> BrukerValidering.sjekkPassord("Admin"));
    }

    @Test
    public void testValidPris() {
        KomponentValidering.prisValidering("123.4");
    }

    @Test
    public void testInvalidPris () {
        assertThrows(InvalidPrisException.class, () -> KomponentValidering.prisValidering("Hei"));
        assertThrows(InvalidPrisException.class, () -> KomponentValidering.prisValidering("-123.4"));
    }

}
