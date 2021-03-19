package Sınıflar;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Icecek extends Menu {

    private List<Icecek> icecek;

    public Icecek(String adi, int fiyat) {
        super(adi, fiyat);
    }

    public Icecek() {
    }

    public List<Icecek> getIcecek() {
        return icecek;
    }

    public void setIcecek(List<Icecek> icecek) {
        this.icecek = icecek;
    }

}
