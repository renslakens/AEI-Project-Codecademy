package programma.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.net.URL;
import java.util.ResourceBundle;

public class NavbarController implements Initializable {
    static int terug;
    @FXML
     BorderPane borderpane;
    @FXML
    private Button home;

    @FXML
    private Button cursisten;

    @FXML
    private Button cursussen;

    @FXML
    private Button webcasts;

    @FXML
    private Button certificaten;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(terug+"= TERUG");
        if (terug == 1){
            try {
                btnCursisten();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (terug == 2){
            try {
                btnWebcasts();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                btnHome();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @FXML
    void btnCertificaten(ActionEvent event) {

    }

    @FXML
    void btnCursisten() throws IOException {
        Pane view = FXMLLoader.load(getClass().getResource("fxml/cursisten.fxml"));
        borderpane.setCenter((view));
    }

    @FXML
    void btnCursussen(ActionEvent event) {

    }

    @FXML
    void btnHome() throws IOException {
        Pane view = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
        borderpane.setCenter((view));
    }

    @FXML
    void btnWebcasts() throws IOException {
        Pane view = FXMLLoader.load(getClass().getResource("fxml/webcasts.fxml"));
        borderpane.setCenter((view));
    }

}
