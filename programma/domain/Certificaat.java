package programma.domain;

import java.sql.Date;

public class Certificaat {
    // Attributes
    private int certificaatID;
    private int beoordeling; // ten hoogste 10
    private String medewerkerNaam;

    // constructor
    public Certificaat(int certificaatID, int beoordeling, String medewerkerNaam) {
        this.certificaatID = certificaatID;
        this.beoordeling = beoordeling;
        this.medewerkerNaam = medewerkerNaam;
    }

    public int getCertificaatID() {
        return certificaatID;
    }

    public void setCertificaatID(int certificaatID) {
        this.certificaatID = certificaatID;
    }

    public int getBeoordeling() {
        return beoordeling;
    }

    public void setBeoordeling(int beoordeling) {
        this.beoordeling = beoordeling;
    }

    public String getMedewerkerNaam() {
        return medewerkerNaam;
    }

    public void setMedewerkerNaam(String medewerkerNaam) {
        this.medewerkerNaam = medewerkerNaam;
    }

    @Override
    public String toString() {
        return " certificate='" + getCertificaatID() + "'" +
                ", rating='" + getBeoordeling() + "'" +
                ", name employee='" + getMedewerkerNaam() + "'";
    }

}
