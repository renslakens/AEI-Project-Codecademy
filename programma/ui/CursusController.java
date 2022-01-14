package programma.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import programma.DB.CursusRepo;
import programma.DB.WebcastRepo;
import programma.domain.Cursus;
import programma.domain.Webcast;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CursusController implements Initializable {
    CursusRepo cursusRepo = new CursusRepo();
    Stage stage;


    @FXML
    private TableView<Webcast> webcastTopThreeTableView;


    @FXML
    private TableView<Cursus> cursusTableView;

    @FXML
    private TableColumn<Cursus, Integer> IDcolumn;

    @FXML
    private TableColumn<Cursus, String> cursusColumn;

    @FXML
    private TableColumn<Cursus, String>onderwerpColumn;

    @FXML
    private TableColumn<Cursus, String> introductieColumn;

    @FXML
    private TableColumn<Cursus, String> niveauColumn;

    @FXML
    private TableColumn<Cursus, String> webcastColumn;

    @FXML
    private TableColumn<Cursus, String> moduleColumn;



    @FXML
    private TableColumn<Webcast, String > titelTopThreeColumn;

    @FXML
    private TableColumn<Webcast, String> sprekerTopThreeColumn;

    @FXML
    private TextField zoekCursist;
    @FXML
    private Button btnCursus;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;

    ObservableList<Cursus> cursusObservableList = FXCollections.observableArrayList();
    ObservableList<Webcast> webcastsObservableListTop3 = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            cursusObservableList.addAll(cursusRepo.get());
            //webcastsObservableListTop3.addAll(webcastRepo.getTop3());
            IDcolumn.setCellValueFactory(new PropertyValueFactory<>("volgnummer"));
            cursusColumn.setCellValueFactory(new PropertyValueFactory<>("cursusNaam"));
            introductieColumn.setCellValueFactory(new PropertyValueFactory<>("introductieTekst"));
            niveauColumn.setCellValueFactory(new PropertyValueFactory<>("niveau"));
            webcastColumn.setCellValueFactory(new PropertyValueFactory<>("webcastTitel"));
            moduleColumn.setCellValueFactory(new PropertyValueFactory<>("moduleTitel"));
            onderwerpColumn.setCellValueFactory(new PropertyValueFactory<>("onderwerp"));
            cursusTableView.setItems(cursusObservableList);

            //Top 3

       // titelTopThreeColumn.setCellValueFactory(new PropertyValueFactory<>("titel"));
       // sprekerTopThreeColumn.setCellValueFactory(new PropertyValueFactory<>("sprekerNaam"));
       // webcastTopThreeTableView.setItems(webcastsObservableListTop3);


    }
    public void handleBtn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/addCursus.fxml"));
        Stage window = (Stage)btnCursus.getScene().getWindow();
        window.setScene(new Scene(root, 1080,600));
        window.setResizable(false);
    }

     @FXML
    void handleDeleteBtn() {
        int selectedID = cursusTableView.getSelectionModel().getSelectedIndex();

            if(selectedID > -1) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure you want to delete this?", ButtonType.YES, ButtonType.CANCEL);

                alert.showAndWait();

                if (alert.getResult() == ButtonType.YES) {
                    cursusRepo.delete(IDcolumn.getCellData(selectedID));
                    cursusTableView.getItems().remove(selectedID);
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to delete, there is no data to delete \nPlease make sure your selected a row to delete"  , ButtonType.CLOSE);

                alert.showAndWait();
            }

    }
    @FXML
    void handleUpdateBtn() throws IOException {
      /* int selectedID = webcastTableView.getSelectionModel().getSelectedIndex();

        if(selectedID > -1) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure you want to update this?", ButtonType.YES, ButtonType.CANCEL);

            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                UpdateWebcastsController.indexCursist = IDcolumn.getCellData(selectedID);
                System.out.println(IDcolumn.getCellData(selectedID));
                Parent root = FXMLLoader.load(getClass().getResource("fxml/updateWebcast.fxml"));
                Stage window = (Stage)btnUpdate.getScene().getWindow();
                window.setScene(new Scene(root, 1080,600));
                window.setResizable(false);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to load update page, there is no data to update \nPlease make sure your selected a row to update"  , ButtonType.CLOSE);

            alert.showAndWait();
        }
*/
    }
}
