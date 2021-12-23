package programma.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import programma.DB.CursistRepo;
import programma.domain.Cursist;
import javafx.scene.Node;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CursistenController implements Initializable {
    CursistRepo cursistRepo = new CursistRepo();
    Stage stage;
    @FXML
    private TableView<Cursist> cursistTableView;

    @FXML
    private TableColumn<Cursist, String> cursistEmailColumn;

    @FXML
    private TableColumn<Cursist, String>  naamColumn;

    @FXML
    private TableColumn<Cursist, String>  geboortedatumColumn;
    @FXML
    private TableColumn<Cursist, String>  postcodeColumn;
    @FXML
    private TableColumn<Cursist, String>  geslachtColumn;

    @FXML
    private TableColumn<Cursist, String>  adresColumn;

    @FXML
    private TableColumn<Cursist, String>  stadColumn;

    @FXML
    private TableColumn<Cursist, String>  landColumn;

    @FXML
    private TextField zoekCursist;
    @FXML
    private Button btnCursist;


    ObservableList<Cursist> cursistObservableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cursistObservableList.addAll(cursistRepo.get());

            cursistEmailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
            adresColumn.setCellValueFactory(new PropertyValueFactory<>("adres"));
            landColumn.setCellValueFactory(new PropertyValueFactory<>("land"));
            geboortedatumColumn.setCellValueFactory(new PropertyValueFactory<>("geboorteDatum"));
            naamColumn.setCellValueFactory(new PropertyValueFactory<>("naam"));
            stadColumn.setCellValueFactory(new PropertyValueFactory<>("stad"));
            geslachtColumn.setCellValueFactory(new PropertyValueFactory<>("geslacht"));
            postcodeColumn.setCellValueFactory(new PropertyValueFactory<>("postcode"));





        cursistTableView.setItems(cursistObservableList);
    }
    public void handleBtn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/addCursist.fxml"));
        Stage window = (Stage)btnCursist.getScene().getWindow();
        window.setScene(new Scene(root, 1080,600));
    }
}
