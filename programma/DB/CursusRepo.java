package programma.DB;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import programma.DB.Crud;
import programma.domain.Cursus;

public class CursusRepo {


    public void create(Cursus params) {
        int cursusID = params.getVolgnummer();
        String naam = params.getCursusNaam();
        String onderwerp = params.getOnderwerp();
        String introductieTekst = params.getIntroductieTekst();
        String niveau = params.getNiveau();
        String interestingCourse = String.valueOf(params.getInterestingCursus());

        boolean rs = DatabaseConnection.executeQuery(String.format(
                "INSERT INTO Cursus(volgnummer, cursusNaam, onderwerp, introductieTekst, niveau, interestingCursus) VALUES ('%s', '%s', '%s','%s','%s','%s','%s','%s')",
                cursusID, naam, onderwerp, introductieTekst, niveau, interestingCourse));

    }

    public ArrayList<Cursus> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Cursus");
        ArrayList<Cursus> cursusList = new ArrayList<>();

        try {
            while (rs.next()) {

                Cursus cursus = new Cursus(null,null,null,null,null,null);
                cursus.setVolgnummer(rs.getInt("Volgnummer"));
                cursus.setCursusNaam(rs.getString("cursusNaam"));
                cursus.setOnderwerp(rs.getString("onderwerp"));
                cursus.setIntroductieTekst(rs.getString("introductieTekst"));
                cursus.setNiveau(rs.getString("niveau"));
                cursus.setInterestingCursus(); // Geen rs.getArrayList ?
                cursusList.add(cursus);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cursusList;
    }
    public Cursus getCursus(int id) {
        ResultSet rs = DatabaseConnection
                .execute(String.format("SELECT * FROM Cursus WHERE CursusID = %d",id));
        Cursus cursus = new Cursus(null,null,null,null,null,null);

        try {
            while (rs.next()) {

                cursus.setVolgnummer(rs.getInt("Volgnummer"));
                cursus.setCursusNaam(rs.getString("cursusNaam"));
                cursus.setOnderwerp(rs.getString("onderwerp"));
                cursus.setIntroductieTekst(rs.getString("introductieTekst"));
                cursus.setNiveau(rs.getString("niveau"));
                cursus.setInterestingCursus(); // Geen rs.getArrayList ?
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cursus;
    }
    public void update(int id, Cursus params) {
        int cursusID = params.getVolgnummer();
        String naam = params.getCursusNaam();
        String onderwerp = params.getOnderwerp();
        String introductieTekst = params.getIntroductieTekst();
        String niveau = params.getNiveau();
        String interestingCourse = String.valueOf(params.getInterestingCursus());

        boolean rs = DatabaseConnection.executeQuery(String.format(
                "UPDATE Cursus SET Volgnummer = '%s', cursusNaam = '%s', Onderwerp = '%s', introductieTekst = '%s', Niveau = '%s', interestingCourse = '%s' WHERE Volgnummer = %d;",
                cursusID, naam, onderwerp, introductieTekst, niveau, interestingCourse, cursusID));
    }

    public void delete(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Cursus WHERE Volgnummer = %d; SELECT * FROM Cursus;", id));
    }
}