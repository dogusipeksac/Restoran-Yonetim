package Sınıflar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MasaSiparis extends Siparis {

    private String masaNo;
    private List<MasaSiparis> masaList = null;

    public MasaSiparis() {
    }

    public MasaSiparis(String masaNo, String siparisAdi, int fiyat) {
        super(siparisAdi, fiyat);
        this.masaNo = masaNo;
    }

    @Override
    public int hesapla(List<Siparis> hesapList) {
        int toplamTutar = 0;
        for (Siparis siparisHesap : hesapList) {
            toplamTutar += siparisHesap.getFiyat();
        }
        return toplamTutar;
    }

    public List<Siparis> donustur(List<MasaSiparis> hesapList) {
        List<Siparis> siparisHesap = new ArrayList<>();
        for (MasaSiparis siparisler : hesapList) {
            siparisHesap.add(siparisler);
        }
        return siparisHesap;
    }

    @Override
    public String siparisGoster() {
        DosyaIslemleri dosya = new DosyaIslemleri();
        String a = "";
        for (MasaSiparis masa : dosya.masaSiparisOku()) {

            a += "Siparis Adi :" + masa.getSiparisAdi() + "\nSiparis Fiyat :" + masa.getFiyat() + "\nMasa No:" + masa.getMasaNo() + "\n\n";
        }
        return a;
    }

    @Override
    public int tumSiparisHesapla() {
        int toplam = 0;
        DosyaIslemleri dosya = new DosyaIslemleri();
        for (MasaSiparis masa : dosya.masaSiparisOku()){
            toplam += masa.getFiyat();
        }
        return toplam;
    }

    public String getMasaNo() {
        return masaNo;
    }

    public void setMasaNo(String masaNo) {
        this.masaNo = masaNo;
    }

    public List<MasaSiparis> getMasaList() {
        return masaList;
    }

    public void setMasaList(List<MasaSiparis> masaList) {
        this.masaList = masaList;
    }

}
