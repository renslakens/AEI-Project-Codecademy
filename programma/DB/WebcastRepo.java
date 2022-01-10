package programma.DB;

import programma.domain.Webcast;

import java.sql.ResultSet;
import java.util.ArrayList;

public class WebcastRepo {


    public void create(Webcast params) {
        String beschrijving = params.getBeschrijving();
        String sprekerNaam = params.getSprekerNaam();
        String organisatieNaam = params.getOrganisatieNaam();
        String tijdsduur = String.valueOf(params.getTijdsduur());
        String publicatieDatum = String.valueOf(params.getPublicatieDatum());
        String url = params.getUrl();

        boolean rs = DatabaseConnection.executeQuery(String.format(
                "INSERT INTO Webcast(Tijdsduur, Url, Spreker, Organisatie) VALUES ('%s', '%s', '%s','%s')",
                tijdsduur, url, sprekerNaam, organisatieNaam));

    }

    public ArrayList<Webcast> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Webcast");
        ArrayList<Webcast> webcastList = new ArrayList<>();

        try {
            while (rs.next()) {
                Webcast webcast = new Webcast(null,null,null,0,null,null);
                webcast.setBeschrijving(rs.getString("Beschrijving"));
                webcast.setSprekerNaam(rs.getString("Spreker"));
                webcast.setOrganisatieNaam(rs.getString("Organisatie"));
                webcast.setTijdsduur(rs.getInt("Tijdsduur"));
                webcast.setPublicatieDatum(rs.getDate("Datum"));
                webcast.setUrl(rs.getString("Url"));
                webcastList.add(webcast);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return webcastList;
    }
    public Webcast getWebast(int id) {
        ResultSet rs = DatabaseConnection
                .execute(String.format("SELECT * FROM Webcast WHERE ContentItemID = %d",id));
        Webcast webcast = new Webcast(null,null,null,0,null,null);

        try {
            while (rs.next()) {
                webcast.setBeschrijving(rs.getString("Beschrijving"));
                webcast.setSprekerNaam(rs.getString("Spreker"));
                webcast.setOrganisatieNaam(rs.getString("Organisatie"));
                webcast.setTijdsduur(rs.getInt("Tijdsduur"));
                webcast.setPublicatieDatum(rs.getDate("Datum"));
                webcast.setUrl(rs.getString("Url"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return webcast;
    }
    public void update(int id, Webcast params) {
        String beschrijving = params.getBeschrijving();
        String sprekerNaam = params.getSprekerNaam();
        String organisatieNaam = params.getOrganisatieNaam();
        String tijdsduur = String.valueOf(params.getTijdsduur());
        String publicatieDatum = String.valueOf(params.getPublicatieDatum());
        String url = params.getUrl();

        boolean rs = DatabaseConnection.executeQuery(String.format(
                "UPDATE Webcast SET Spreker = '%s', Url = '%s', Organisatie = '%s', Geslacht = '%s', Adres = '%s',Stad = '%s', Land = '%s', postcode = '%s' WHERE ContentItemID = %d;",
                email,naam, geboortedatum, geslacht, adres, stad, land, postcode,id));


    }

    public void delete(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Webcast WHERE ContentItemID = %d; SELECT * FROM Webcast;", id));
    }
}