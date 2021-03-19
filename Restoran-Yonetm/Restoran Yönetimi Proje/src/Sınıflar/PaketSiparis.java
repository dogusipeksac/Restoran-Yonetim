package Sınıflar;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaketSiparis extends Siparis {

    private String paketBilgisi;
    List<PaketSiparis> paketList;

    public PaketSiparis() {
    }

    public PaketSiparis(String paketBilgisi, String siparisAdi, int fiyat) {
        super(siparisAdi, fiyat);
        this.paketBilgisi = paketBilgisi;
    }

    @Override
    public int hesapla(List<Siparis> paketHesapList) {
        int paketToplamTutar = 0;
        for (Siparis siparisHesap : paketHesapList) {
            paketToplamTutar += siparisHesap.getFiyat();
        }
        return paketToplamTutar;
    }

    public List<Siparis> Donustur(List<PaketSiparis> hesapList) {
        List<Siparis> siparisHesap = new ArrayList<>();
        for (PaketSiparis siparisler : hesapList) {
            siparisHesap.add(siparisler);
        }
        return siparisHesap;
    }

    @Override
    public int tumSiparisHesapla() {
        DosyaIslemleri dosya = new DosyaIslemleri();
        int toplam = 0;
        for (PaketSiparis siparis : dosya.paketSiparisOku()) {
            toplam += siparis.getFiyat();
        }
        return toplam;
    }

    @Override
    public String siparisGoster() {
        DosyaIslemleri dosya = new DosyaIslemleri();
        String a = "";
        for (PaketSiparis siparis : dosya.paketSiparisOku()) {
            a += "Siparis Adi :" + siparis.getSiparisAdi() + "\nSiparis Fiyat: " + siparis.getFiyat() + "\nSiparis Adresi : " + siparis.getPaketBilgisi() + "\n\n";
        }
        return a;
    }

    public String getPaketBilgisi() {
        return paketBilgisi;
    }

    public void setPaketBilgisi(String paketBilgisi) {
        this.paketBilgisi = paketBilgisi;
    }

    public List<PaketSiparis> getPaketList() {
        return paketList;
    }

    public void setPaketList(List<PaketSiparis> paketList) {
        this.paketList = paketList;
    }

}
