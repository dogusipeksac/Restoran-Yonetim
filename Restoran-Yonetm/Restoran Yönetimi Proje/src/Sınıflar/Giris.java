
package Sınıflar;


public class Giris {

    private final String garsonKullaniciAdi = "garson";
    private final String garsonSifre = "12345";

    private final String yoneticiKullaniciAdi = "yonetici";
    private final String yoneticiSifre = "12345";

    public Giris() {
    }

    public Boolean garsonGirisKontrol(String garsonKullaniciAdi, String garsonSifre) {

        return this.garsonKullaniciAdi.equals(garsonKullaniciAdi) && this.garsonSifre.equals(garsonSifre);
    }

    public Boolean yoneticiGirisKontrol(String yoneticiKullaniciAdi, String yoneticiSifre) {

        return this.yoneticiKullaniciAdi.equals(yoneticiKullaniciAdi) && this.yoneticiSifre.equals(yoneticiSifre);
    }

    public String getGarsonKullaniciAdi() {
        return garsonKullaniciAdi;
    }

    public String getGarsonSifre() {
        return garsonSifre;
    }

    public String getYoneticiKullaniciAdi() {
        return yoneticiKullaniciAdi;
    }

    public String getYoneticiSifre() {
        return yoneticiSifre;
    }

}
