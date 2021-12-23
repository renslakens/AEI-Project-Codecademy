package programma.ui;

import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import programma.DB.CursistRepo;
import programma.domain.Cursist;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddCursistenController {
    CursistRepo cursistRepo = new CursistRepo();

    @FXML
    private Button btnTerug;

    @FXML
    private TextField txtNaam;

    @FXML
    private TextField txtGeslacht;

    @FXML
    private TextField txtAdres;

    @FXML
    private TextField txtLand;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPostcode;
    @FXML
    private TextField txtStad;
    @FXML
    private DatePicker dtGeboortedatum;
    @FXML
    private Label txtSucces;

    @FXML
    private Button btnAdd;

    @FXML
    void handleAddButton(ActionEvent event) throws ParseException {

        if (txtEmail.getText() != null && txtNaam.getText() != null && dtGeboortedatum.getValue() != null && txtGeslacht.getText() !=null
            && txtAdres.getText() != null && txtStad.getText()!= null && txtLand.getText() != null && txtPostcode.getText() != null) {

            cursistRepo.create(new Cursist(txtEmail.getText(), txtNaam.getText(), java.sql.Date.valueOf(dtGeboortedatum.getValue()), txtGeslacht.getText(),
                    txtAdres.getText(), txtStad.getText(), txtLand.getText(), txtPostcode.getText()));
            clearForm();
        }
        txtSucces.setText("Cursist succesvol toegevoegd");
    }

    void clearForm(){
        txtEmail.clear(); txtNaam.clear(); dtGeboortedatum.disarm(); txtGeslacht.clear();
                txtAdres.clear(); txtStad.clear(); txtLand.clear(); txtPostcode.clear();
    }
    @FXML
    void handleTerug() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/cursisten.fxml"));
        Stage window = (Stage)btnTerug.getScene().getWindow();
        window.setScene(new Scene(root, 1080,600));
    }

}
