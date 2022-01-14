package programma.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import programma.DB.CursistRepo;
import programma.DB.CursusRepo;
import programma.DB.ModuleRepo;
import programma.DB.WebcastRepo;
import programma.domain.Cursist;
import programma.domain.Cursus;
import programma.domain.Module;
import programma.domain.Webcast;
import programma.logic.Validatie;

import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.util.ResourceBundle;

public class AddCursusController implements Initializable {
    NavbarController navbarController = new NavbarController();
    CursusRepo cursusRepo = new CursusRepo();
    WebcastRepo webcastRepo = new WebcastRepo();
    ModuleRepo moduleRepo = new ModuleRepo();
    @FXML
    private Button btnTerug;

    @FXML
    private TextField txtCursus;

    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtOnderwerp;

    @FXML
    private Label txtSucces;

    @FXML
    private TextField txtIntroductie;

    @FXML
    private ChoiceBox<String> cbNiveau;

    @FXML
    private ChoiceBox<String> cbWebcast;

    @FXML
    private ChoiceBox<String> cbModule;


    @FXML
    private TableView<Module> ModuleTableView;

    @FXML
    private TableColumn<Module, Integer> IDColumn;

    @FXML
    private TableColumn<Module, String> titleColumn;

    @FXML
    private TableColumn<Module, String> versieColumn;

    @FXML
    private TableColumn<Module, String> beschrijvingColumn;

    @FXML
    private TableColumn<Module, String> naamColumn;

    @FXML
    private TableColumn<Module, String> emailColumn;

    ObservableList<Module> moduleObservableList = FXCollections.observableArrayList();

    @FXML
    void handleAddButton(ActionEvent event) throws ParseException {

        if (txtOnderwerp.getText() != null && txtCursus.getText() != null && txtIntroductie.getText() != null && cbModule.getValue() !=null
             && cbWebcast.getValue()!= null && cbNiveau.getValue() != null) {
        try {
            cursusRepo.create(new Cursus(txtCursus.getText(), txtOnderwerp.getText(), txtIntroductie.getText(), cbNiveau.getValue(),
                    cbModule.getValue(),cbWebcast.getValue()));
            txtSucces.setText("Cursus succesvol toegevoegd");
            txtSucces.setTextFill(Color.GREEN);
        }catch (Exception e){
            txtSucces.setText("Cursus toevoegen mislukt");
            txtSucces.setTextFill(Color.RED);
            return;
        }
            clearForm();
        }else {
            txtSucces.setText("Cursus toevoegen mislukt");
            txtSucces.setTextFill(Color.RED);
        }


    }

    void clearForm(){
        txtCursus.clear(); txtIntroductie.clear(); txtOnderwerp.clear();

    }
    @FXML
    void handleTerug() throws Exception{
        NavbarController.terug = 3;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/navbar.fxml"));
        Stage window = (Stage)btnTerug.getScene().getWindow();
        window.setScene(new Scene(root, 1370,600));
        window.setResizable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set Module Table
        moduleObservableList.addAll(moduleRepo.get());
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("moduleID"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("contactEmail"));
        naamColumn.setCellValueFactory(new PropertyValueFactory<>("contactNaam"));
        beschrijvingColumn.setCellValueFactory(new PropertyValueFactory<>("beschrijving"));
        versieColumn.setCellValueFactory(new PropertyValueFactory<>("versie"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("titel"));

        ModuleTableView.setItems(moduleObservableList);



        //set checkboxes
        cbNiveau.setItems(FXCollections.observableArrayList("BEGINNER","GEVORDERD","EXPERT"));
        cbWebcast.setItems(FXCollections.observableArrayList(webcastRepo.getTitels()));
        cbModule.setItems(FXCollections.observableArrayList(moduleRepo.getTitels()));

    }
}
