package Sınıflar;


import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Fastfood extends Menu {

    private List<Fastfood> fastFood;

    public Fastfood(String adi, int fiyat) {
        super(adi, fiyat);
    }

    public Fastfood() {
    }

    public List<Fastfood> getFastFood() {
        return fastFood;
    }

    public void setFastFood(List<Fastfood> fastFood) {
        this.fastFood = fastFood;
    }

}
