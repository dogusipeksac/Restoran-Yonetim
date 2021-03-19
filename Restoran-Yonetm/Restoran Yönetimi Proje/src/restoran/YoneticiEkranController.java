package restoran;

import Sınıflar.DosyaIslemleri;
import Sınıflar.EvYemekleri;
import Sınıflar.Fastfood;
import Sınıflar.ISiparis;
import Sınıflar.Icecek;
import Sınıflar.MasaSiparis;
import Sınıflar.Menu;
import Sınıflar.Mutfak;
import Sınıflar.OrganizasyonSiparis;
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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class YoneticiEkranController extends ControlAbstract implements Initializable {

    @FXML
    private TableView<Mutfak> malzemeTable;
    @FXML
    private TableColumn<Mutfak, String> malzemeAdSutun;
    @FXML
    private TableColumn<Mutfak, String> malzemeAdetSutun;
    @FXML
    private TextField malzemeAdText;
    @FXML
    private TextField malzemeAdetText;

    @FXML
    private TableView<Menu> menuKontrolTable;
    @FXML
    private TableColumn<Menu, String> kmenuAdSutun;
    @FXML
    private TableColumn<Menu, Integer> kmenuFiyatSutun;
    @FXML
    private TextField yemekAdiText;
    @FXML
    private TextField fiyatText;
    @FXML
    private ComboBox menuKontrolCombo;
    @FXML
    private Label organizasyonHesaplaLabel;
    @FXML
    private TextArea adisyonTextArea;
    @FXML
    private Label gunSonuLabel;

    @FXML
    private TableView<Menu> menuTable;
    @FXML
    private TableColumn<Menu, String> yemekAdiSutun;
    @FXML
    private TableColumn<Menu, Integer> yemekFiyatSutun;
    @FXML
    private Label toplamLabel;
    @FXML
    private TableView<OrganizasyonSiparis> organizasyonTable;
    @FXML
    private TableColumn<OrganizasyonSiparis, String> oyemekAdiSutun;
    @FXML
    private TableColumn<OrganizasyonSiparis, Integer> oyemekFiyatSutun;
    @FXML
    private TextField organizasyonAdText;
    @FXML
    private TextField kisiSayisi;
    @FXML
    private ComboBox organizasyonCombo;
    @FXML
    private ComboBox adisyonCombo;

    public void mutfakMalzemeEkle() {

        if (!"".equals(malzemeAdText.getText()) && !"".equals(malzemeAdetText.getText())) {
            Mutfak malzeme = new Mutfak(malzemeAdetText.getText(), malzemeAdText.getText());
            malzemeTable.getItems().add(malzeme);
        } else {
            JOptionPane.showMessageDialog(null, "Eksik yerleri doldurunuz !");
        }
    }

    public void mutfakMalzemeAdetGuncelle(CellEditEvent editedCell) {

        Mutfak malzemeSecim = malzemeTable.getSelectionModel().getSelectedItem();
        malzemeSecim.setAdet(editedCell.getNewValue().toString());

    }

    public void mutfakMalzemeAdGuncelle(CellEditEvent editedCell) {

        Mutfak malzemeSecim = malzemeTable.getSelectionModel().getSelectedItem();
        malzemeSecim.setMalzemeAdi(editedCell.getNewValue().toString());

    }

    public void mutfakMalzemeSil() {

        Mutfak malzeme = new Mutfak();

        malzeme = malzemeTable.getSelectionModel().getSelectedItem();

        malzemeTable.getItems().remove(malzeme);

    }
    public void mutfakDegisiklikKaydet() {

        DosyaIslemleri dosya = new DosyaIslemleri();
        ArrayList<Mutfak> malzemeler = new ArrayList<>();

        for (Mutfak malzeme : malzemeTable.getItems()) {
            malzemeler.add(malzeme);
        }
        JOptionPane.showMessageDialog(null, "Değişiklikler kaydedildi !");
        dosya.mutfakMalzemeYaz(malzemeler);
        malzemeAdText.setText("");
        malzemeAdetText.setText("");

    }

    public void organizasyonSiparisHesapla() {

        int toplamTutar = 0;
        int kisiSayisi = Integer.valueOf(this.kisiSayisi.getText().toString());
        ISiparis organizasyonSiparis = new OrganizasyonSiparis();
        OrganizasyonSiparis siparis = new OrganizasyonSiparis();
        toplamTutar = organizasyonSiparis.hesapla(siparis.Donustur(organizasyonTable.getItems()));
        organizasyonHesaplaLabel.setText("" + (kisiSayisi * toplamTutar) + " ₺");
    }
      public void organizasyonSiparisEkle() {

        Menu secilenSiparis;
        secilenSiparis = menuTable.getSelectionModel().getSelectedItem();

        if (!"".equals(kisiSayisi.getText()) && !"".equals(organizasyonAdText.getText())) {
            try {
                Siparis yeniSiparis = new OrganizasyonSiparis(Integer.valueOf(kisiSayisi.getText()), organizasyonAdText.getText(), secilenSiparis.getAdi(), secilenSiparis.getFiyat());
                organizasyonTable.getItems().add((OrganizasyonSiparis) yeniSiparis);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Kişi sayısına geçersiz karakter girdiniz !");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Kisi sayisi ve organizasyon adi giriniz!");
        }

    }

    public void organizasyonOlustur() {

        OrganizasyonSiparis orgSiparis = new OrganizasyonSiparis();
        DosyaIslemleri dosya = new DosyaIslemleri();

        List<OrganizasyonSiparis> list = new ArrayList<>();

        for (Siparis siparisler : organizasyonTable.getItems()) {

            list.add((OrganizasyonSiparis) siparisler);
        }

        if (organizasyonAdText.getText().toString().equals("") || kisiSayisi.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Boş alan bırakmayınız !");

        } else if (organizasyonTable.getItems().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sipariş seçilmemiş !");
        } else {

            dosya.organizasyonSiparisYaz(list);
            organizasyonHesaplaLabel.setText("");
            organizasyonTable.getItems().clear();
            kisiSayisi.setText("");
            organizasyonAdText.setText("");
            JOptionPane.showMessageDialog(null, "Organizasyon siparişleri kaydedildi!");

        }
    }

    public void organizasyonSiparisSil() {
        Siparis secilenSiparis;

        secilenSiparis = organizasyonTable.getSelectionModel().getSelectedItem();

        organizasyonTable.getItems().remove(secilenSiparis);
    }

    

    public void organizasyonMenuCombobox() {

        DosyaIslemleri dosya = new DosyaIslemleri();

        if ("FastFood".equals(organizasyonCombo.getValue().toString())) {

            menuTable.getItems().clear();

            for (Fastfood m : dosya.fastFoodOku()) {

                Menu a = new Menu(m.getAdi(), m.getFiyat());
                menuTable.getItems().add(a);
            }

        } else if ("Ev Yemeği".equals(organizasyonCombo.getValue().toString())) {

            menuTable.getItems().clear();

            for (EvYemekleri m : dosya.evYemekleriOku()) {

                Menu a = new Menu(m.getAdi(), m.getFiyat());
                menuTable.getItems().add(a);
            }

        } else if ("Tatli".equals(organizasyonCombo.getValue().toString())) {

            menuTable.getItems().clear();

            for (Tatli m : dosya.tatliOku()) {

                Menu a = new Menu(m.getAdi(), m.getFiyat());
                menuTable.getItems().add(a);
            }

        } else if ("İcecek".equals(organizasyonCombo.getValue().toString())) {

            menuTable.getItems().clear();

            for (Icecek m : dosya.icecekOku()) {

                Menu a = new Menu(m.getAdi(), m.getFiyat());
                menuTable.getItems().add(a);
            }

        }

    }

    

    public void menuEkle() {

        if (!"".equals(yemekAdiText.getText()) && !"".equals(fiyatText.getText())) {

            try {
                Menu yeniMenu = new Menu(yemekAdiText.getText(), Integer.valueOf(fiyatText.getText()));

                menuKontrolTable.getItems().add(yeniMenu);
                yemekAdiText.setText("");
                fiyatText.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Fiyata geçersiz karakter girdiniz !");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Eksik alan yada geçersiz menu seçimi ! !");
        }

    }

    public void menuAdGuncelle(CellEditEvent editedCell) {

        Menu menuSecim = menuKontrolTable.getSelectionModel().getSelectedItem();
        menuSecim.setAdi(editedCell.getNewValue().toString());

    }

 
    public void menuSil() {

        Menu secimMenu = new Menu();

        secimMenu = menuKontrolTable.getSelectionModel().getSelectedItem();

        menuKontrolTable.getItems().remove(secimMenu);

    }

    Menu menu;

    public void menuKontrolCombobox() {

        DosyaIslemleri dosya = new DosyaIslemleri();

        yemekAdiText.setText("");
        fiyatText.setText("");
        if ("FastFood".equals(menuKontrolCombo.getValue().toString())) {

            menuKontrolTable.getItems().clear();
            Fastfood fast = new Fastfood();

            for (Fastfood m : dosya.fastFoodOku()) {

                Menu a = new Menu(m.getAdi(), m.getFiyat());
                menuKontrolTable.getItems().add(a);
            }

            menu = fast;

        } else if ("Ev Yemeği".equals(menuKontrolCombo.getValue().toString())) {

            menuKontrolTable.getItems().clear();
            EvYemekleri fast = new EvYemekleri();

            for (EvYemekleri m : dosya.evYemekleriOku()) {

                Menu a = new Menu(m.getAdi(), m.getFiyat());
                menuKontrolTable.getItems().add(a);
            }
            menu = fast;

        } else if ("Tatli".equals(menuKontrolCombo.getValue().toString())) {

            menuKontrolTable.getItems().clear();
            Tatli fast = new Tatli();

            for (Tatli m : dosya.tatliOku()) {

                Menu a = new Menu(m.getAdi(), m.getFiyat());
                menuKontrolTable.getItems().add(a);
            }
            menu = fast;

        } else if ("İcecek".equals(menuKontrolCombo.getValue().toString())) {

            menuKontrolTable.getItems().clear();
            Icecek fast = new Icecek();
            for (Icecek m : dosya.icecekOku()) {

                Menu a = new Menu(m.getAdi(), m.getFiyat());
                menuKontrolTable.getItems().add(a);
            }
            menu = fast;
        }

    }

    public void menuDegisiklikKaydet() {

        DosyaIslemleri dosya = new DosyaIslemleri();

        if (menu instanceof Fastfood) {

            ArrayList<Fastfood> yemekler = new ArrayList<>();

            for (Menu menu : menuKontrolTable.getItems()) {

                yemekler.add(new Fastfood(menu.getAdi(), menu.getFiyat()));

            }

            dosya.fastFoodYaz(yemekler);
        }
        if (menu instanceof EvYemekleri) {

            ArrayList<EvYemekleri> yemekler = new ArrayList<>();

            for (Menu yemek : menuKontrolTable.getItems()) {

                yemekler.add(new EvYemekleri(yemek.getAdi(), yemek.getFiyat()));

            }
            dosya.evYemekleriYaz(yemekler);
        }
        if (menu instanceof Icecek) {

            ArrayList<Icecek> ıcecekler = new ArrayList<>();

            for (Menu menu : menuKontrolTable.getItems()) {
                ıcecekler.add(new Icecek(menu.getAdi(), menu.getFiyat()));
            }

            dosya.icecekYaz(ıcecekler);
        }
        if (menu instanceof Tatli) {

            ArrayList<Tatli> tatlilar = new ArrayList<>();

            for (Menu menu : menuKontrolTable.getItems()) {
                tatlilar.add(new Tatli(menu.getAdi(), menu.getFiyat()));
            }

            dosya.tatliYaz(tatlilar);
        }
        JOptionPane.showMessageDialog(null, "Değişiklikler kaydedildi !");
    }

    public void hesapGoster() {
        String a = "";
        int toplam = 0;

        if (adisyonCombo.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Lütfen bir adisyon türü seçiniz.");
        }

        if ("Masa Siparişleri".equals(adisyonCombo.getValue().toString())) {
            ISiparis adisyon1 = new MasaSiparis();
            toplam = adisyon1.tumSiparisHesapla();
            a = adisyon1.siparisGoster();

        } else if ("Paket Siparişleri".equals(adisyonCombo.getValue().toString())) {
            ISiparis adisyon2 = new PaketSiparis();
            toplam = adisyon2.tumSiparisHesapla();
            a = adisyon2.siparisGoster();

        } else if ("Organizasyonlar".equals(adisyonCombo.getValue().toString())) {
            ISiparis adisyon3 = new OrganizasyonSiparis();
            toplam = adisyon3.tumSiparisHesapla();
            a = adisyon3.siparisGoster();
        } else if ("Tüm Siparişler".equals(adisyonCombo.getValue().toString())) {
            ISiparis adisyon4 = new Siparis();
            toplam = adisyon4.tumSiparisHesapla();
            a = adisyon4.siparisGoster();

        }

        gunSonuLabel.setText("" + toplam + " ₺");
        adisyonTextArea.setText(a);
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        adisyonCombo.getItems().addAll("Masa Siparişleri", "Paket Siparişleri", "Organizasyonlar", "Tüm Siparişler");

        menuKontrolCombo.getItems().addAll("FastFood", "Ev Yemeği", "Tatli", "İcecek");
        organizasyonCombo.getItems().addAll("FastFood", "Ev Yemeği", "Tatli", "İcecek");

        DosyaIslemleri malzemeOku = new DosyaIslemleri();

        for (Mutfak malzeme : malzemeOku.mutfakMalzemeOku()) {
            malzemeTable.getItems().add(malzeme);
        }

        malzemeAdSutun.setCellValueFactory(new PropertyValueFactory<Mutfak, String>("malzemeAdi"));
        malzemeAdetSutun.setCellValueFactory(new PropertyValueFactory<Mutfak, String>("adet"));
        malzemeTable.setEditable(true);
        malzemeAdetSutun.setCellFactory(TextFieldTableCell.forTableColumn());
        malzemeAdSutun.setCellFactory(TextFieldTableCell.forTableColumn());
        malzemeTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        kmenuAdSutun.setCellValueFactory(new PropertyValueFactory<Menu, String>("adi"));
        kmenuFiyatSutun.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("fiyat"));
        menuKontrolTable.setEditable(true);
        menuKontrolTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        kmenuAdSutun.setCellFactory(TextFieldTableCell.forTableColumn());

        yemekAdiSutun.setCellValueFactory(new PropertyValueFactory<Menu, String>("adi"));
        yemekFiyatSutun.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("fiyat"));
        menuTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        oyemekAdiSutun.setCellValueFactory(new PropertyValueFactory<OrganizasyonSiparis, String>("siparisAdi"));
        oyemekFiyatSutun.setCellValueFactory(new PropertyValueFactory<OrganizasyonSiparis, Integer>("fiyat"));

    }

}
