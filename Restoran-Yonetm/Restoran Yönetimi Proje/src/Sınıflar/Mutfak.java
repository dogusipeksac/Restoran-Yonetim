package Sınıflar;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mutfak {

    private String adet;
    private String malzemeAdi;
    private List<Mutfak> malzemeList;

    public Mutfak() {
    }

    public Mutfak(String adet, String malzemeAdi) {
        this.adet = adet;
        this.malzemeAdi = malzemeAdi;
    }

    public String getMalzemeAdi() {
        return malzemeAdi;
    }

    public void setMalzemeAdi(String malzemeAdi) {
        this.malzemeAdi = malzemeAdi;
    }

    public String getAdet() {
        return adet;
    }

    public void setAdet(String adet) {
        this.adet = adet;
    }

    public List<Mutfak> getMalzemeList() {
        return malzemeList;
    }

    public void setMalzemeList(List<Mutfak> malzemeList) {
        this.malzemeList = malzemeList;
    }

}
