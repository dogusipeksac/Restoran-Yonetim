package Sınıflar;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tatli extends Menu {

    private List<Tatli> tatli;

    public Tatli(String adi, int fiyat) {
        super(adi, fiyat);
    }

    public Tatli() {
    }

    public List<Tatli> getTatli() {
        return tatli;
    }

    public void setTatli(List<Tatli> tatli) {
        this.tatli = tatli;
    }

}
