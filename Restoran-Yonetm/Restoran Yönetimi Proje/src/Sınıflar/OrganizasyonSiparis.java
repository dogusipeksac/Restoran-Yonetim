package Sınıflar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrganizasyonSiparis extends Siparis {

    private int kisiSayisi;
    private String organizasyonAdi;
    private List<OrganizasyonSiparis> orgList = null;

    public OrganizasyonSiparis() {

    }

    public OrganizasyonSiparis(int kisiSayisi, String organizasyonAdi, String siparisAdi, int fiyat) {
        super(siparisAdi, fiyat);
        this.kisiSayisi = kisiSayisi;
        this.organizasyonAdi = organizasyonAdi;
    }

    @Override
    public int hesapla(List<Siparis> hesapList) {
        int toplamTutar = 0;
        for (Siparis siparisHesap : hesapList) {
            toplamTutar += siparisHesap.getFiyat();
        }
        return toplamTutar;
    }

    public List<Siparis> Donustur(List<OrganizasyonSiparis> hesapList) {
        List<Siparis> siparisHesap = new ArrayList<>();
        for (OrganizasyonSiparis siparisler : hesapList) {
            siparisHesap.add(siparisler);
        }
        return siparisHesap;
    }

    @Override
    public int tumSiparisHesapla() {
        int toplam = 0;
        DosyaIslemleri dosya = new DosyaIslemleri();
        for (OrganizasyonSiparis siparis : dosya.organizasyonSiparisOku()) {
            toplam += siparis.getFiyat() * siparis.getKisiSayisi();
        }
        return toplam;
    }

    @Override
    public String siparisGoster() {
        DosyaIslemleri dosya = new DosyaIslemleri();
        String a = "";
        for (OrganizasyonSiparis siparis : dosya.organizasyonSiparisOku()) {
            a += "Organizasyon Adi: " + siparis.getOrganizasyonAdi() + "\nSiparis Adi: " + siparis.getSiparisAdi() + "\nOrganizasyon Kisi Sayisi : " + siparis.getKisiSayisi() + "\nOrganizasyon Tutar: " + (siparis.getFiyat() * siparis.getKisiSayisi()) + "\n\n";
        }
        return a;
    }

    public int getKisiSayisi() {
        return kisiSayisi;
    }

    public void setKisiSayisi(int kisiSayisi) {
        this.kisiSayisi = kisiSayisi;
    }

    public String getOrganizasyonAdi() {
        return organizasyonAdi;
    }

    public void setOrganizasyonAdi(String organizasyonAdi) {
        this.organizasyonAdi = organizasyonAdi;
    }

    public List<OrganizasyonSiparis> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<OrganizasyonSiparis> orgList) {
        this.orgList = orgList;
    }

}
