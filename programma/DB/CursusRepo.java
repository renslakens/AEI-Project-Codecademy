package programma.DB;

import java.sql.ResultSet;
import java.util.ArrayList;

import programma.domain.Cursus;

public class CursusRepo {


    public void create(Cursus params) {
        int cursusID = params.getVolgnummer();
        String naam = params.getCursusNaam();
        String onderwerp = params.getOnderwerp();
        String introductieTekst = params.getIntroductieTekst();
        String niveau = params.getNiveau();
        String webcastTitel = params.getWebcastTitel();
        String moduleTitel = params.getModuleTitel();
        boolean rs = DatabaseConnection.executeQuery(String.format(
                "INSERT INTO Cursussen(CursusNaam, Onderwerp, IntroductieTekst, Niveau, WebCastTitel,ModuleTitel ) VALUES ('%s', '%s', '%s','%s','%s','%s')",
                naam, onderwerp, introductieTekst, niveau,webcastTitel,moduleTitel));

    }

    public ArrayList<Cursus> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Cursussen");
        ArrayList<Cursus> cursusList = new ArrayList<>();

        try {
            while (rs.next()) {

                Cursus cursus = new Cursus(null,null,null,null,null,null);
                cursus.setVolgnummer(rs.getInt("VolgNummer"));
                cursus.setCursusNaam(rs.getString("CursusNaam"));
                cursus.setOnderwerp(rs.getString("Onderwerp"));
                cursus.setIntroductieTekst(rs.getString("IntroductieTekst"));
                cursus.setNiveau(rs.getString("Niveau"));
                cursus.setModuleTitel(rs.getString("ModuleTitel"));
                cursus.setWebcastTitel(rs.getString("WebcastTitel"));

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
                .execute(String.format("SELECT * FROM Cursus WHERE VolgNummer = %d",id));
        Cursus cursus = new Cursus(null,null,null,null,null,null);

        try {
            while (rs.next()) {

                cursus.setVolgnummer(rs.getInt("VolgNummer"));
                cursus.setCursusNaam(rs.getString("CursusNaam"));
                cursus.setOnderwerp(rs.getString("Onderwerp"));
                cursus.setIntroductieTekst(rs.getString("IntroductieTekst"));
                cursus.setNiveau(rs.getString("Niveau"));
                cursus.setModuleTitel(rs.getString("ModuleTitel"));
                cursus.setWebcastTitel(rs.getString("WebcastTitel"));
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
        String moduleTitel = params.getModuleTitel();
        String webcastTitel = params.getWebcastTitel();
        boolean rs = DatabaseConnection.executeQuery(String.format(
                "UPDATE Cursus SET Volgnummer = '%s', cursusNaam = '%s', Onderwerp = '%s', introductieTekst = '%s', Niveau = '%s', interestingCourse = '%s' WHERE Volgnummer = %d;",
                cursusID, naam, onderwerp, introductieTekst, niveau, cursusID));
    }

    public void delete(int id) {
        ResultSet rs = DatabaseConnection.execute(String.format("DELETE FROM Cursussen WHERE Volgnummer = %d; SELECT * FROM Cursussen;", id));
    }
}