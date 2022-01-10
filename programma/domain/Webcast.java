package programma.domain;

import java.util.Date;

public class Webcast {
    // Attributes
    private String beschrijving;
    private String sprekerNaam;
    private String organisatieNaam;
    private int tijdsduur;
    private Date publicatieDatum;
    private String url;

    // Constructor
    public Webcast(String beschrijving, String sprekerNaam, String organisatieNaam, int tijdsduur, Date publicatieDatum, String url) {
        this.beschrijving = beschrijving;
        this.sprekerNaam = sprekerNaam;
        this.organisatieNaam = organisatieNaam;
        this.tijdsduur = tijdsduur;
        this.publicatieDatum = publicatieDatum;
        this.url = url;
    }

    // Getters and Setters
    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getSprekerNaam() {
        return sprekerNaam;
    }

    public void setSprekerNaam(String sprekerNaam) {
        this.sprekerNaam = sprekerNaam;
    }

    public String getOrganisatieNaam() {
        return organisatieNaam;
    }

    public void setOrganisatieNaam(String organisatieNaam) {
        this.organisatieNaam = organisatieNaam;
    }

    public int getTijdsduur() {
        return tijdsduur;
    }

    public void setTijdsduur(int tijdsduur) {
        this.tijdsduur = tijdsduur;
    }

    public Date getPublicatieDatum() {
        return publicatieDatum;
    }

    public void setPublicatieDatum(Date publicatieDatum) {
        this.publicatieDatum = publicatieDatum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return
                "Description='" + getBeschrijving() + "'" +
                        ", name speaker='" + getSprekerNaam() + "'" +
                        ", org. name='" + getOrganisatieNaam() + "'" +
                        ", time='" + getTijdsduur() + "'" +
                        ", publication date='" + getPublicatieDatum() + "'" +
                        ", url='" + getUrl() + "'";
    }

}