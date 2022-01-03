package programma.domain;

import java.util.ArrayList;

public class Cursus {
    // Attributes
    private int volgnummer;
    private String cursusNaam;
    private String onderwerp;
    private String introductieTekst;
    private String niveau;
    private ArrayList<Cursus> interestingCursus;

    // Constructor
    public Cursus(int volgnummer, String cursusNaam, String onderwerp, String introductieTekst, String niveau,
            ArrayList<Cursus> interestingCursus) {
        this.volgnummer = volgnummer;
        this.cursusNaam = cursusNaam;
        this.onderwerp = onderwerp;
        this.introductieTekst = introductieTekst;
        this.niveau = niveau;
        this.interestingCursus = new ArrayList<>();
    }

    public int getVolgnummer() {
        return volgnummer;
    }

    public void setVolgnummer(int volgnummer) {
        this.volgnummer = volgnummer;
    }

    public String getCursusNaam() {
        return cursusNaam;
    }

    public void setCursusNaam(String cursusNaam) {
        this.cursusNaam = cursusNaam;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public void setOnderwerp(String onderwerp) {
        this.onderwerp = onderwerp;
    }

    public String getIntroductieTekst() {
        return introductieTekst;
    }

    public void setIntroductieTekst(String introductieTekst) {
        this.introductieTekst = introductieTekst;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public ArrayList<Cursus> getInterestingCursus() {
        return interestingCursus;
    }

    public void setInterestingCursus(ArrayList<Cursus> interestingCursus) {
        this.interestingCursus = interestingCursus;
    }

    @Override
    public String toString() {
        return " Cursus='" + getCursusNaam() + "'" +
                ", number='" + getVolgnummer() + "'" +
                ", subject='" + getOnderwerp() + "'" +
                ", level='" + getNiveau() + "'" +
                ", introduction='" + getIntroductieTekst() + "'" +
                ", interesting courses='" + getInterestingCursus() + "'";
    }
}
