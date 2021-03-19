package Sınıflar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Menu {

    private String adi;
    private int fiyat;

    public Menu(String adi, int fiyat) {
        this.adi = adi;
        this.fiyat = fiyat;
    }

    public Menu() {
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

}
