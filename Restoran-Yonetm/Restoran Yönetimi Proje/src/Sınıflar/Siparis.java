package Sınıflar;

import java.util.List;

public class Siparis implements ISiparis {

    private String siparisAdi;
    private int fiyat;

    public Siparis() {
    }

    public Siparis(String siparisAdi, int fiyat) {
        this.siparisAdi = siparisAdi;
        this.fiyat = fiyat;
    }

    public String getSiparisAdi() {
        return siparisAdi;
    }

    public void setSiparisAdi(String siparisAdi) {
        this.siparisAdi = siparisAdi;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public int hesapla(List<Siparis> hesapList) {

        int toplamTutar = 0;

        for (Siparis siparisHesap : hesapList) {
            toplamTutar += siparisHesap.getFiyat();
        }
        return toplamTutar;
    }

    @Override
    public String siparisGoster() {
        DosyaIslemleri dosya = new DosyaIslemleri();
        String a1 = "";
        String a2 = "";
        String a3 = "";
        for (OrganizasyonSiparis siparis : dosya.organizasyonSiparisOku()) {
            a1 += "Organizasyon Adi: " + siparis.getOrganizasyonAdi() + "\nSiparis Adi: " + siparis.getSiparisAdi() + "\nOrganizasyon Kisi Sayisi : " + siparis.getKisiSayisi() + "\nOrganizasyon Tutar: " + (siparis.getFiyat() * siparis.getKisiSayisi()) + "\n\n";
        }

        for (MasaSiparis masa : dosya.masaSiparisOku()) {
            a2 += "Siparis Adi :" + masa.getSiparisAdi() + "\nSiparis Fiyat :" + masa.getFiyat() + "\nMasa No:" + masa.getMasaNo() + "\n\n";
        }
        for (PaketSiparis siparis : dosya.paketSiparisOku()) {
            a3 += "Siparis Adi :" + siparis.getSiparisAdi() + "\nSiparis Fiyat: " + siparis.getFiyat() + "\nSiparis Adresi : " + siparis.getPaketBilgisi() + "\n\n";
        }

        return a1 + a2 + a3;
    }

    @Override
    public int tumSiparisHesapla() {
        DosyaIslemleri dosya = new DosyaIslemleri();
        int toplam1 = 0;
        int toplam2 = 0;
        int toplam3 = 0;
        for (PaketSiparis siparis : dosya.paketSiparisOku()) {
            toplam1 += siparis.getFiyat();
        }
        for (MasaSiparis masa : dosya.masaSiparisOku()) {

            toplam2 += masa.getFiyat();
        }
        for (OrganizasyonSiparis siparis : dosya.organizasyonSiparisOku()) {
            toplam3 += siparis.getFiyat() * siparis.getKisiSayisi();
        }
        return toplam1 + toplam2 + toplam3;
    }

}
