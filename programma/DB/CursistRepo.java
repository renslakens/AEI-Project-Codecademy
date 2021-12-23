package programma.DB;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import programma.DB.Crud;
import programma.domain.Cursist;

public class CursistRepo {


    public void create(Cursist params) {
        String adres = params.getAdres();
        String naam = params.getNaam();
        String email = params.getEmail();
        String geboortedatum = String.valueOf(params.getGeboorteDatum());
        String geslacht = params.getGeslacht();
        String stad = params.getStad();
        String land = params.getLand();
        String postcode = params.getPostcode();

        boolean rs = DatabaseConnection.executeQuery(String.format(
                "INSERT INTO Cursisten(CursistEmail,Naam, Geboortedatum, Geslacht, Adres,Stad, Land, postcode) VALUES ('%s', '%s', '%s','%s','%s','%s','%s','%s')",
                email,naam, geboortedatum, geslacht, adres, stad, land, postcode));

    }

    public ArrayList<Cursist> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Cursisten");
        ArrayList<Cursist> cursistsList = new ArrayList<>();

        try {
            while (rs.next()) {

                Cursist cursist = new Cursist(null,null,null,null,null,null,null,null);
                cursist.setEmail(rs.getString("CursistEmail"));
                cursist.setAdres(rs.getString("Adres"));
                cursist.setNaam(rs.getString("Naam"));
                cursist.setGeboorteDatum(rs.getDate("Geboortedatum"));
                cursist.setGeslacht(rs.getString("Geslacht"));
                cursist.setStad(rs.getString("Stad"));
                cursist.setLand(rs.getString("Land"));
                cursist.setPostcode(rs.getString("postcode"));
                cursistsList.add(cursist);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cursistsList;
    }

}