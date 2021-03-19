
package Sınıflar;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EvYemekleri")
public class EvYemekleri extends Menu {

    private List<EvYemekleri> yemek = null;

    public EvYemekleri(String adi, int fiyat) {
        super(adi, fiyat);
    }

    public EvYemekleri() {
    }

    public List<EvYemekleri> getYemek() {
        return yemek;
    }

    public void setYemek(List<EvYemekleri> yemek) {
        this.yemek = yemek;
    }

}
