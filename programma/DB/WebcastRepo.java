package programma.DB;

import programma.domain.Webcast;

import java.sql.ResultSet;
import java.util.ArrayList;

public class WebcastRepo {


    public void create(Webcast params) {
        String titel = params.getTitel();
        String beschrijving = params.getBeschrijving();
        String sprekerNaam = params.getSprekerNaam();
        String organisatieNaam = params.getOrganisatieNaam();
        String tijdsduur = String.valueOf(params.getTijdsduur());
        String publicatieDatum = String.valueOf(params.getPublicatieDatum());
        String url = params.getUrl();

        boolean rs = DatabaseConnection.executeQuery(String.format(
                "INSERT INTO Cursist(CursistEmail,Naam, Geboortedatum, Geslacht, Adres,Stad, Land, postcode) VALUES ('%s', '%s', '%s','%s','%s','%s','%s','%s')",
                email,naam, geboortedatum, geslacht, adres, stad, land, postcode));

    }

    public ArrayList<Webcast> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Webcast");
        ArrayList<Webcast> webcastList = new ArrayList<>();

        try {
            while (rs.next()) {

                Webcast webcast = new Webcast(null,null,null,null,0,null,null);
                webcast.setCursistID(rs.getInt("CursistID"));
                webcast.setEmail(rs.getString("CursistEmail"));
                webcast.setAdres(rs.getString("Adres"));
                webcast.setNaam(rs.getString("Naam"));
                webcast.setGeboorteDatum(rs.getDate("Geboortedatum"));
                webcast.setGeslacht(rs.getString("Geslacht"));
                webcast.setStad(rs.getString("Stad"));
                webcast.setLand(rs.getString("Land"));
                webcast.setPostcode(rs.getString("postcode"));
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
                .execute(String.format("SELECT * FROM Webcast WHERE WebcastID = %d",id));
        Webcast webcast = new Webcast(null,null,null,null,0,null,null);

        try {
            while (rs.next()) {

                webcast.setCursistID(rs.getInt("CursistID"));
                webcast.setEmail(rs.getString("CursistEmail"));
                webcast.setAdres(rs.getString("Adres"));
                webcast.setNaam(rs.getString("Naam"));
                webcast.setGeboorteDatum(rs.getDate("Geboortedatum"));
                webcast.setGeslacht(rs.getString("Geslacht"));
                webcast.setStad(rs.getString("Stad"));
                webcast.setLand(rs.getString("Land"));
                webcast.setPostcode(rs.getString("postcode"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return webcast;
    }
    public void update(int id, Webcast params) {
        int webcastID = params.getCursistID();
        String adres = params.getAdres();
        String naam = params.getNaam();
        String email = params.getEmail();
        String geboortedatum = String.valueOf(params.getGeboorteDatum());
        String geslacht = params.getGeslacht();
        String stad = params.getStad();
        String land = params.getLand();
        String postcode = params.getPostcode();

        boolean rs = DatabaseConnection.executeQuery(String.format(
                "UPDATE Webcast SET WebcastTitel = '%s', Naam = '%s', Geboortedatum = '%s', Geslacht = '%s', Adres = '%s',Stad = '%s', Land = '%s', postcode = '%s' WHERE WebcastID = %d;",
                email,naam, geboortedatum, geslacht, adres, stad, land, postcode,id));


    }

    public void delete(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Webcast WHERE WebcastID = %d; SELECT * FROM Webcast;", id));
    }
}