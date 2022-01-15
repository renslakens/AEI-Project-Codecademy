package programma.DB;

import programma.domain.Certificaat;
import programma.domain.Cursist;
import programma.domain.Module;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CertificaatRepo {


    public void create(Certificaat params) {
        int certificaatID = params.getCertificaatID();
        int beoordeling = params.getBeoordeling();
        String ondertekenaar = params.getOndertekenaar();
        String cursist = params.getCursist();
        String cursus = params.getCursus();
        String geslachtCursist = params.getGeslachtCursist();


        boolean rs = DatabaseConnection.executeQuery(String.format(
                "INSERT INTO Certificate(Beoordeling,Ondertekenaar, Cursist, Cursus,GeslachtCursist) VALUES ('%d', '%s','%s','%s','%s')",
                beoordeling,ondertekenaar, cursist, cursus, geslachtCursist));

    }

    public ArrayList<Certificaat> get() {
        ResultSet rs = DatabaseConnection
                .execute("SELECT * FROM Certificate");
        ArrayList<Certificaat> certificaatList = new ArrayList<>();

        try {
            while (rs.next()) {

                Certificaat certificaat = new Certificaat(0,null,null,null,null);
                certificaat.setCertificaatID(rs.getInt("CertificaatID"));
                certificaat.setBeoordeling(rs.getInt("Beoordeling"));
                certificaat.setOndertekenaar(rs.getString("Ondertekenaar"));
                certificaat.setCursist(rs.getString("Cursist"));
                certificaat.setCursus(rs.getString("Cursus"));
                certificaat.setGeslachtCursist(rs.getString("GeslachtCursist"));
                certificaatList.add(certificaat);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return certificaatList;
    }
    public Certificaat getModule(int id) {
        ResultSet rs = DatabaseConnection
                .execute(String.format("SELECT * FROM Certificate WHERE Certificate = %d",id));
        Certificaat certificaat = new Certificaat(0,null,null,null,null);

        try {
            while (rs.next()) {

                certificaat.setCertificaatID(rs.getInt("CertificaatID"));
                certificaat.setBeoordeling(rs.getInt("Beoordeling"));
                certificaat.setOndertekenaar(rs.getString("Ondertekenaar"));
                certificaat.setCursist(rs.getString("Cursist"));
                certificaat.setCursus(rs.getString("Cursus"));
                certificaat.setGeslachtCursist(rs.getString("GeslachtCursist"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return certificaat;
    }
    public void update(int id, Certificaat params) {
        //TODO
        int certificaatID = params.getCertificaatID();
        int beoordeling = params.getBeoordeling();
        String ondertekenaar = params.getOndertekenaar();
        String cursist = params.getCursist();
        String cursus = params.getCursus();
        String geslachtCursist = params.getGeslachtCursist();

        boolean rs = DatabaseConnection.executeQuery(String.format(
                "UPDATE Certificate SET Beoordeling = '%d', Ondertekenaar = '%s' WHERE CertificaatID = %d;",
                beoordeling,ondertekenaar,id));

    }
}