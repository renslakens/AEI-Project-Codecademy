package programma.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** schermen:
 * cursus materiaal (je kan hier: toevoegen/veranderen)
 * cursisten (je kan hier: toevoegen/veranderen)
 * overzicht voor: cursus, webcast, cursistenaccount
 */ 

public class UI extends Application{
      @Override
      public void start(Stage window){
          window.setTitle("Codecadamy");

          Button cursusButton = new Button("Cursus");
          Button cursistButton = new Button("Cursist");
          Button overzichtButton = new Button("Overzicht");
          VBox menu = new VBox();
          menu.getChildren().addAll(cursusButton, cursistButton, overzichtButton);

          Scene hoofdmenu = new Scene(menu, 900,500); 
          window.setScene(hoofdmenu);


          window.show();
      }




      public static void main(String[] args){
          launch(UI.class);
      }
}
