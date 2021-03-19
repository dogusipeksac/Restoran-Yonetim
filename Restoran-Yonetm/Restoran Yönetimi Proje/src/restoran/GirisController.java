/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author TEK-A
 */
public class GirisController implements Initializable {
   
    
    @FXML
     public void yoneticiGirisi(ActionEvent event) throws IOException
    {
         Parent tableViewParent=FXMLLoader.load(getClass().getResource("YoneticiGiris.fxml"));
         Scene tableViewScene=new Scene(tableViewParent);
         //this line gets the stage information
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(tableViewScene);
         window.show();
    }
     @FXML
      public void garsonGiris(ActionEvent event) throws IOException
    {
         Parent tableViewParent=FXMLLoader.load(getClass().getResource("GarsonGiris.fxml"));
         Scene tableViewScene=new Scene(tableViewParent);
         //this line gets the stage information
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(tableViewScene);
         window.show();
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
