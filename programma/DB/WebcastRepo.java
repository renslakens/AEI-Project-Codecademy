package programma.DB;

import programma.domain.Webcast;

import java.sql.ResultSet;
import java.util.ArrayList;

public class WebcastRepo {


    public void create(Webcast params) {
        String titel = params.getTitel();
        String sprekerNaam = params.getSprekerNaam();
        String organisatieNaam = params.getOrganisatieNaam();
        String tijdsduur = String.valueOf(params.getTijdsduur());
        String publicatieDatum = String.valueOf(params.getPublicatieDatum());
        String url = params.getUrl();

        boolean rs = DatabaseConnection.executeQuery(String.format(
                "INSERT INTO Webcasts(Tijdsduur, Url, Spreker, Organisatie,Titel,DatumPublicatie) VALUES ('%s', '%s', '%s','%s','%s','%s')",
                tijdsduur, url, sprekerNaam, organisatieNaam,titel, publicatieDatum));

    }

    public ArrayList<Webcast> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Webcasts");
        ArrayList<Webcast> webcastList = new ArrayList<>();

        try {
            while (rs.next()) {
                Webcast webcast = new Webcast(null,null,0,null,null,null);
                webcast.setWebcastID(rs.getInt("ContentItemID"));
                webcast.setTitel(rs.getString("Titel"));
                webcast.setSprekerNaam(rs.getString("Spreker"));
                webcast.setOrganisatieNaam(rs.getString("Organisatie"));
                webcast.setTijdsduur(rs.getInt("Tijdsduur"));
                webcast.setPublicatieDatum(rs.getDate("DatumPublicatie"));
                webcast.setUrl(rs.getString("Url"));
                webcastList.add(webcast);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FAILED TO LOAD");
            return null;
        }
        return webcastList;
    }
    public Webcast getWebast(int id) {
        ResultSet rs = DatabaseConnection
                .execute(String.format("SELECT * FROM Webcasts WHERE ContentItemID = %d",id));
        Webcast webcast = new Webcast(null,null,0,null,null,null);

        try {
            while (rs.next()) {
                webcast.setWebcastID(rs.getInt("ContentItemID"));
                webcast.setTitel(rs.getString("Titel"));
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
        String titel = params.getTitel();
        String sprekerNaam = params.getSprekerNaam();
        String organisatieNaam = params.getOrganisatieNaam();
        String tijdsduur = String.valueOf(params.getTijdsduur());
        String publicatieDatum = String.valueOf(params.getPublicatieDatum());
        String url = params.getUrl();

//        boolean rs = DatabaseConnection.executeQuery(String.format(
//                "UPDATE Webcasts SET Spreker = '%s', Url = '%s', Organisatie = '%s', Geslacht = '%s', Adres = '%s',Stad = '%s', Land = '%s', postcode = '%s' WHERE ContentItemID = %d;",
//                email,naam, geboortedatum, geslacht, adres, stad, land, postcode,id));


    }

    public void delete(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Webcasts WHERE ContentItemID = %d; SELECT * FROM Webcast;", id));
    }
}