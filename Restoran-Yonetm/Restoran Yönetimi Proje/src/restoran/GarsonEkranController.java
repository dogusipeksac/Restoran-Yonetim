package restoran;

import Sınıflar.DosyaIslemleri;
import Sınıflar.EvYemekleri;
import Sınıflar.Fastfood;
import Sınıflar.ISiparis;
import Sınıflar.Icecek;
import Sınıflar.MasaSiparis;
import Sınıflar.Menu;
import Sınıflar.PaketSiparis;
import Sınıflar.Siparis;
import Sınıflar.Tatli;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class GarsonEkranController extends ControlAbstract implements Initializable {
    
    @FXML
    private TableView<Menu> masaMenuTable;
    @FXML
    private TableColumn<Menu, String> masaMenuYemekSutun;
    @FXML
    private TableColumn<Menu, Integer> masaMenuFiyatSutun;
    @FXML
    private TableColumn<Menu, Integer> masaMenuAdetSutun;
    
    @FXML
    private TableView<MasaSiparis> masaSiparisTable;
    @FXML
    private TableColumn<MasaSiparis, String> masaSiparisSutun;
    @FXML
    private TableColumn<MasaSiparis, Integer> masaFiyatSutun;
    @FXML
    private TableColumn<MasaSiparis, Integer> masaAdetSutun;
    
    @FXML
    private TextField masaNoText;
    @FXML
    private Label masaHesapLabel;
    @FXML
    private ComboBox masaMenuComb;
    @FXML
    private ComboBox masaCombo;
    
    @FXML
    private Label paketHesapLabel;
    @FXML
    private TableView<Menu> paketMenuTable;
    @FXML
    private TableColumn<Menu, String> paketMenuYemekSutun;
    @FXML
    private TableColumn<Menu, Integer> paketMenuFiyatSutun;
    @FXML
    private TableColumn<Menu, Integer> paketMenuAdetSutun;
    @FXML
    private TableView<PaketSiparis> paketSiparisTable;
    @FXML
    private TableColumn<PaketSiparis, String> paketSiparisSutun;
    @FXML
    private TableColumn<PaketSiparis, Integer> paketFiyatSutun;
    @FXML
    private TableColumn<PaketSiparis, Integer> paketAdetSutun;
    @FXML
    private TextField adresText;
    @FXML
    private TextField telefonText;
    @FXML
    private TextField musteriAdiText;
    @FXML
    private ComboBox paketMenuComb;
    @FXML
    private Label hesapLabel;
    
    public void masaNoAc() {
        
        int kontrol = 1;
        int masaNo = 0;
        
        for (Object l : masaCombo.getItems()) {
            System.out.println("a");
            if (l.toString().equals(masaNoText.getText().toString())) {                
                System.out.println("b");
                kontrol = 0;
            }
        }
        
        if (kontrol == 1) {
            try {
                masaNo = Integer.valueOf(masaNoText.getText());
                masaCombo.getItems().add(masaNo);
                masaNoText.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Masa numarasina geçersiz karakter girdiniz !");
            }
        } else {
            JOptionPane.showMessageDialog(null, masaNoText.getText() + " numarali masa zaten acik !");
        }
    }
    
    public void masaComboKontrol() {
        
        int kontrol = 2;
        if (!masaSiparisTable.getItems().isEmpty()) {
            kontrol = JOptionPane.showConfirmDialog(null, "Masa kapatilmadi,masayi kapatılsın mı ?", "Uyari!", 0, 0);
            if (kontrol == 0) {
                masaKapat();
            } else if (kontrol == 1) {
                masaSiparisTable.getItems().clear();
            }
        }
    }
    
    public void masaSiparisHesapla() {
        int toplamTutar = 0;
        ISiparis masaSiparis = new MasaSiparis();
        MasaSiparis siparis = new MasaSiparis();
        toplamTutar = masaSiparis.hesapla(siparis.donustur(masaSiparisTable.getItems()));
        masaHesapLabel.setText("" + toplamTutar + " ₺");
    }
    
    public void masaSiparisEkle() {
        
        Menu secilenSiparis;
        
        if (masaCombo.getValue() != null) {
            secilenSiparis = masaMenuTable.getSelectionModel().getSelectedItem();
            Siparis siparis = new MasaSiparis(masaCombo.getValue().toString(), secilenSiparis.getAdi(), secilenSiparis.getFiyat());
            masaSiparisTable.getItems().add((MasaSiparis) siparis);
        } else {
            JOptionPane.showMessageDialog(null, "Masa numarası seçiniz!");
        }
    }
    
    public void masaKapat() {
        
        DosyaIslemleri dosya = new DosyaIslemleri();
        if (masaCombo.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Masa Secilmemis !");
        } else if (masaSiparisTable.getItems().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sipariş seçilmemiş !");
        } else {
            
            List<MasaSiparis> masaSipariss = new ArrayList<>();
            for (MasaSiparis m : masaSiparisTable.getItems()) {
                masaSipariss.add(m);
            }
            
            dosya.masaSiparisYaz(masaSipariss);
            masaSiparisTable.getItems().clear();
            masaHesapLabel.setText("");
            JOptionPane.showMessageDialog(null, "Masa siparişiniz kaydedildi!");
        }
    }
    
    public void masaSiparisSil() {
        Siparis secilenSiparis;
        secilenSiparis = masaSiparisTable.getSelectionModel().getSelectedItem();
        masaSiparisTable.getItems().remove(secilenSiparis);
        
    }
    
    public void masaMenuCombo() {
        
        DosyaIslemleri dosya = new DosyaIslemleri();
        
        if ("FastFood".equals(masaMenuComb.getValue().toString())) {
            
            masaMenuTable.getItems().clear();
            
            Fastfood fast = new Fastfood();
            for (Fastfood m : dosya.fastFoodOku()) {
                
                Menu a = new Menu(m.getAdi(), m.getFiyat());
                masaMenuTable.getItems().add(a);
            }
            
        } else if ("Ev Yemeği".equals(masaMenuComb.getValue().toString())) {
            
            masaMenuTable.getItems().clear();
            
            for (EvYemekleri m : dosya.evYemekleriOku()) {
                
                Menu a = new Menu(m.getAdi(), m.getFiyat());
                masaMenuTable.getItems().add(a);
            }
            
        } else if ("Tatli".equals(masaMenuComb.getValue().toString())) {
            
            masaMenuTable.getItems().clear();
            Tatli fast = new Tatli();
            
            for (Tatli m : dosya.tatliOku()) {
                
                Menu a = new Menu(m.getAdi(), m.getFiyat());
                masaMenuTable.getItems().add(a);
            }
            
        } else if ("İcecek".equals(masaMenuComb.getValue().toString())) {
            
            masaMenuTable.getItems().clear();
            Icecek fast = new Icecek();
            
            for (Icecek m : dosya.icecekOku()) {
                
                Menu a = new Menu(m.getAdi(), m.getFiyat());
                masaMenuTable.getItems().add(a);
            }
        }
    }
    
    public void paketSiparisEkle() {
        
        Menu sipariss;
        sipariss = paketMenuTable.getSelectionModel().getSelectedItem();
        if (!"".equals(musteriAdiText.getText()) && !"".equals(adresText.getText()) || !"".equals(telefonText.getText())) {
            String paketBilgisi = "" + musteriAdiText.getText() + " " + adresText.getText() + " " + telefonText.getText() + " ";
            Siparis siparis = new PaketSiparis(paketBilgisi, sipariss.getAdi(), sipariss.getFiyat());
            paketSiparisTable.getItems().add((PaketSiparis) siparis);
        } else {
            JOptionPane.showMessageDialog(null, "Boş alan bırakamayınız!");
        }
    }
    
    public void paketMenuCombo() {
        
        DosyaIslemleri dosya = new DosyaIslemleri();
        
        if ("FastFood".equals(paketMenuComb.getValue().toString())) {
            
            paketMenuTable.getItems().clear();
            
            Fastfood fast = new Fastfood();
            
            for (Fastfood m : dosya.fastFoodOku()) {
                
                Menu a = new Menu(m.getAdi(), m.getFiyat());
                paketMenuTable.getItems().add(a);
            }
            
        } else if ("Ev Yemeği".equals(paketMenuComb.getValue().toString())) {
            
            paketMenuTable.getItems().clear();
            EvYemekleri fast = new EvYemekleri();
            
            for (EvYemekleri m : dosya.evYemekleriOku()) {
                
                Menu a = new Menu(m.getAdi(), m.getFiyat());
                paketMenuTable.getItems().add(a);
            }
            
        } else if ("Tatli".equals(paketMenuComb.getValue().toString())) {
            
            paketMenuTable.getItems().clear();
            Tatli fast = new Tatli();
            
            for (Tatli m : dosya.tatliOku()) {
                Menu a = new Menu(m.getAdi(), m.getFiyat());
                paketMenuTable.getItems().add(a);
            }
            
        } else if ("İcecek".equals(paketMenuComb.getValue().toString())) {
            
            paketMenuTable.getItems().clear();
            Icecek fast = new Icecek();
            
            for (Icecek m : dosya.icecekOku()) {
                
                Menu a = new Menu(m.getAdi(), m.getFiyat());
                paketMenuTable.getItems().add(a);
            }
        }
    }
    
    public void paketSiparisHesapla() {
        int toplamTutar = 0;
        ISiparis paketSiparis = new PaketSiparis();
        PaketSiparis siparis = new PaketSiparis();
        toplamTutar = paketSiparis.hesapla(siparis.Donustur(paketSiparisTable.getItems()));
        hesapLabel.setText("" + toplamTutar + " ₺");
    }
    
    public void paketSiparisSil() {
        Siparis secilenSiparis;
        secilenSiparis = paketSiparisTable.getSelectionModel().getSelectedItem();
        paketSiparisTable.getItems().remove(secilenSiparis);
    }
    
    @Override
    public void geri(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GirisFXML.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        //this line gets the stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    public void paketSiparisOnayla() {
        
        PaketSiparis paketSiparis = new PaketSiparis();
        DosyaIslemleri dosya = new DosyaIslemleri();
        if (musteriAdiText.getText().toString().equals("") || adresText.getText().toString().equals("") || telefonText.getText().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Boş alan bırakmayınız !");
        } else if (paketSiparisTable.getItems().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sipariş seçilmemiş !");
        } else {
            
            dosya.paketSiparisYaz(paketSiparisTable.getItems());
            adresText.setText("");
            musteriAdiText.setText("");
            hesapLabel.setText("");
            telefonText.setText("");
            paketSiparisTable.getItems().clear();
            JOptionPane.showMessageDialog(null, "Paket siparişiniz kaydedildi!");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        masaMenuComb.getItems().addAll("FastFood", "Ev Yemeği", "Tatli", "İcecek");
        paketMenuComb.getItems().addAll("FastFood", "Ev Yemeği", "Tatli", "İcecek");
        
        masaSiparisSutun.setCellValueFactory(new PropertyValueFactory<MasaSiparis, String>("siparisAdi"));
        masaFiyatSutun.setCellValueFactory(new PropertyValueFactory<MasaSiparis, Integer>("fiyat"));
        
        masaSiparisTable.setEditable(true);
        
        masaMenuYemekSutun.setCellValueFactory(new PropertyValueFactory<Menu, String>("adi"));
        masaMenuFiyatSutun.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("fiyat"));
        masaMenuTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        paketMenuYemekSutun.setCellValueFactory(new PropertyValueFactory<Menu, String>("adi"));
        paketMenuFiyatSutun.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("fiyat"));
        
        paketSiparisSutun.setCellValueFactory(new PropertyValueFactory<PaketSiparis, String>("siparisAdi"));
        paketFiyatSutun.setCellValueFactory(new PropertyValueFactory<PaketSiparis, Integer>("fiyat"));
        
        paketSiparisTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        paketMenuTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        masaMenuTable.setEditable(true);
    }
    
}
