/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran;

import Sınıflar.Giris;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author TEK-A
 */
public class YoneticiGirisController extends ControlAbstract implements Initializable {

    @FXML
    private TextField kullaniciAdiText;
    @FXML
    private PasswordField sifrePass;

    public void yoneticiGirisKontrol(ActionEvent event) throws IOException {
        Giris giris = new Giris();

        if (giris.yoneticiGirisKontrol(kullaniciAdiText.getText(), sifrePass.getText())) {

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("YoneticiEkran.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } else {
            JOptionPane.showMessageDialog(null, "Hatali sifre veya kullanici adi !");
        }

    }

    @FXML
    @Override
    public void geri(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GirisFXML.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        //this line gets the stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
