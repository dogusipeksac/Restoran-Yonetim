package restoran;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

abstract class ControlAbstract {

    public abstract void geri(ActionEvent event) throws IOException;

    public void cikis(ActionEvent event) throws IOException {
        int A = JOptionPane.showConfirmDialog(null, "Çıkmak istediğinizden emin misiniz ?", "Uyari!", 0, 0);

        if (A == 0) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("GirisFXML.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        }
    }

}
