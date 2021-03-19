/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran;

import Sınıflar.DosyaIslemleri;
import Sınıflar.EvYemekleri;
import Sınıflar.Fastfood;
import Sınıflar.Icecek;
import Sınıflar.MasaSiparis;
import Sınıflar.OrganizasyonSiparis;
import Sınıflar.PaketSiparis;
import Sınıflar.Siparis;
import Sınıflar.Tatli;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author TEK-A
 */
public class Restoran extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GirisFXML.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        Image image = new Image("icon.png");
        
        stage.getIcons().add(image);
        stage.setTitle("X RESTORAN");
        stage.setScene(scene);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        

    }
    
}
