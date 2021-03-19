/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sınıflar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DosyaIslemleri {

    Tatli tatli = new Tatli();
    Fastfood fastfood = new Fastfood();
    Icecek icecek = new Icecek();
    EvYemekleri evYemekleri = new EvYemekleri();
    Mutfak mutfak = new Mutfak();
    OrganizasyonSiparis organizasyonSiparis = new OrganizasyonSiparis();
    MasaSiparis masaSiparis = new MasaSiparis();
    PaketSiparis paketSiparis = new PaketSiparis();

    public void fastFoodYaz(ArrayList<Fastfood> yeniListe) {

        try {
            JAXBContext jc = JAXBContext.newInstance(Fastfood.class);
            Marshaller ms = jc.createMarshaller();
            ArrayList<Fastfood> fastFoodList = yeniListe;
            fastfood.setFastFood(fastFoodList);
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(fastfood, new File("src\\Xml\\Fastfood.xml"));
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Fastfood> fastFoodOku() {
        List<Fastfood> FastFoodListesi = null;

        try {

            JAXBContext jc = JAXBContext.newInstance(Fastfood.class);
            javax.xml.bind.Unmarshaller ums = jc.createUnmarshaller();
            File xmlFile = new File("src\\Xml\\Fastfood.xml");
            Fastfood list = (Fastfood) ums.unmarshal(xmlFile);
            FastFoodListesi = list.getFastFood();

            for (Fastfood fastfood1 : FastFoodListesi) {
                System.out.println("Adi:" + fastfood1.getAdi());
                System.out.println("Fiyat:" + fastfood1.getFiyat());
                System.out.println();

            }

        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }
        return FastFoodListesi;
    }

    public void tatliYaz(ArrayList<Tatli> yeniListe) {

        try {
            JAXBContext jc = JAXBContext.newInstance(Tatli.class);
            Marshaller ms = jc.createMarshaller();
            ArrayList<Tatli> TatliList = yeniListe;
            tatli.setTatli(TatliList);
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(tatli, new File("src\\Xml\\Tatli.xml"));
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Tatli> tatliOku() {
        List<Tatli> TatliListesi = null;

        try {

            JAXBContext jc = JAXBContext.newInstance(Tatli.class);
            javax.xml.bind.Unmarshaller ums = jc.createUnmarshaller();
            File xmlFile = new File("src\\Xml\\Tatli.xml");
            Tatli list = (Tatli) ums.unmarshal(xmlFile);
            TatliListesi = list.getTatli();
            for (Tatli tatli1 : TatliListesi) {
                System.out.println("Adi:" + tatli1.getAdi());
                System.out.println("Fiyat:" + tatli1.getFiyat());
                System.out.println();
            }
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }
        return TatliListesi;
    }

    public void icecekYaz(ArrayList<Icecek> yeniList) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Icecek.class);
            Marshaller ms = jc.createMarshaller();
            ArrayList<Icecek> icecekList = yeniList;
            icecek.setIcecek(icecekList);
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(icecek, new File("src\\Xml\\Icecek.xml"));
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Icecek> icecekOku() {
        List<Icecek> IcecekListesi = null;

        try {

            JAXBContext jc = JAXBContext.newInstance(Icecek.class);
            javax.xml.bind.Unmarshaller ums = jc.createUnmarshaller();
            File xmlFile = new File("src\\Xml\\Icecek.xml");
            Icecek list = (Icecek) ums.unmarshal(xmlFile);
            IcecekListesi = list.getIcecek();
            for (Icecek icecek1 : IcecekListesi) {
                System.out.println("Adi" + icecek1.getAdi());
                System.out.println("Fiyat" + icecek1.getFiyat());
                System.out.println();

            }
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }
        return IcecekListesi;
    }

    public void evYemekleriYaz(ArrayList<EvYemekleri> liste) {

        try {
            JAXBContext jc = JAXBContext.newInstance(EvYemekleri.class);
            Marshaller ms = jc.createMarshaller();
            ArrayList<EvYemekleri> evYemekleriList = liste;
            evYemekleri.setYemek(evYemekleriList);
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(evYemekleri, new File("src\\Xml\\EvYemekleri.xml"));
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<EvYemekleri> evYemekleriOku() {
        List<EvYemekleri> EvYemekleriListesi = null;

        try {

            JAXBContext jc = JAXBContext.newInstance(EvYemekleri.class);
            javax.xml.bind.Unmarshaller ums = jc.createUnmarshaller();
            File xmlFile = new File("src\\Xml\\EvYemekleri.xml");
            EvYemekleri list = (EvYemekleri) ums.unmarshal(xmlFile);
            EvYemekleriListesi = list.getYemek();
            for (EvYemekleri evYemekleri1 : EvYemekleriListesi) {
                System.out.println("Adi:" + evYemekleri1.getAdi());
                System.out.println("Fiyat:" + evYemekleri1.getFiyat());
                System.out.println();

            }
        } catch (JAXBException ex) {
            System.out.println("top");
        }
        return EvYemekleriListesi;
    }

    public List<Mutfak> mutfakMalzemeOku() {
        List<Mutfak> malzemeListesi = null;

        try {

            JAXBContext jc = JAXBContext.newInstance(Mutfak.class);
            javax.xml.bind.Unmarshaller ums = jc.createUnmarshaller();
            File xmlFile = new File("src\\Xml\\Mutfak.xml");
            Mutfak list = (Mutfak) ums.unmarshal(xmlFile);
            malzemeListesi = list.getMalzemeList();
            for (Mutfak mutfak1 : malzemeListesi) {
                System.out.println("Malzeme Adi:" + mutfak1.getMalzemeAdi());
                System.out.println("Adet:" + mutfak1.getAdet());
                System.out.println();

            }
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }

        return malzemeListesi;
    }

    public void mutfakMalzemeYaz(ArrayList<Mutfak> yeniListe) {

        try {
            JAXBContext jc = JAXBContext.newInstance(Mutfak.class);
            Marshaller ms = jc.createMarshaller();
            ArrayList<Mutfak> fastFoodList = yeniListe;
            mutfak.setMalzemeList(fastFoodList);
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(mutfak, new File("src\\Xml\\Mutfak.xml"));
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<PaketSiparis> paketSiparisOku() {
        List<PaketSiparis> paketListesi = null;

        try {

            JAXBContext jc = JAXBContext.newInstance(PaketSiparis.class);
            javax.xml.bind.Unmarshaller ums = jc.createUnmarshaller();
            File xmlFile = new File("src\\Xml\\PaketSiparis.xml");
            PaketSiparis list = (PaketSiparis) ums.unmarshal(xmlFile);
            paketListesi = list.getPaketList();
            for (PaketSiparis paketSiparis1 : paketListesi) {
                System.out.println("Paket Bilgisi:" + paketSiparis1.getPaketBilgisi());
                System.out.println("Siparis Adi:" + paketSiparis1.getSiparisAdi());
                System.out.println("Fiyat:" + paketSiparis1.getFiyat());
                System.out.println();
            }
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }

        return paketListesi;
    }

    public void paketSiparisYaz(List<PaketSiparis> siparis) {

        List<PaketSiparis> list = paketSiparisOku();
        for (PaketSiparis pakets : siparis) {
            list.add(pakets);
        }

        try {
            JAXBContext jc = JAXBContext.newInstance(PaketSiparis.class);
            Marshaller ms = jc.createMarshaller();
            paketSiparis.setPaketList(list);
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(paketSiparis, new File("src\\Xml\\PaketSiparis.xml"));
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<MasaSiparis> masaSiparisOku() {
        List<MasaSiparis> masaListesi = null;

        try {

            JAXBContext jc = JAXBContext.newInstance(MasaSiparis.class);
            javax.xml.bind.Unmarshaller ums = jc.createUnmarshaller();
            File xmlFile = new File("src\\Xml\\MasaSiparis.xml");
            MasaSiparis list = (MasaSiparis) ums.unmarshal(xmlFile);
            masaListesi = list.getMasaList();
            for (MasaSiparis masaSiparis1 : masaListesi) {
                System.out.println("Masa No:" + masaSiparis1.getMasaNo());
                System.out.println("Siparis Adi:" + masaSiparis1.getSiparisAdi());
                System.out.println("Fiyat:" + masaSiparis1.getFiyat());
                System.out.println();
            }
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }

        return masaListesi;
    }

    public void masaSiparisYaz(List<MasaSiparis> siparis) {

        List<MasaSiparis> masaS = masaSiparisOku();

        
        for (MasaSiparis msp : siparis) {
            masaS.add(msp);
        }

        try {
            JAXBContext jc = JAXBContext.newInstance(MasaSiparis.class);
            Marshaller ms = jc.createMarshaller();
            List<MasaSiparis> masaList = masaS;
            masaSiparis.setMasaList(masaList);
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(masaSiparis, new File("src\\Xml\\MasaSiparis.xml"));
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void organizasyonSiparisYaz(List<OrganizasyonSiparis> siparis) {

        List<OrganizasyonSiparis> orgSiparis = organizasyonSiparisOku();

        for (OrganizasyonSiparis organisayon : siparis) {
            orgSiparis.add(organisayon);
        }

        try {
            JAXBContext jc = JAXBContext.newInstance(OrganizasyonSiparis.class);
            Marshaller ms = jc.createMarshaller();
            organizasyonSiparis.setOrgList(orgSiparis);
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(organizasyonSiparis, new File("src\\Xml\\OrganizasyonSiparis.xml"));

        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<OrganizasyonSiparis> organizasyonSiparisOku() {
        List<OrganizasyonSiparis> organizasyonListesi = null;

        try {

            JAXBContext jc = JAXBContext.newInstance(OrganizasyonSiparis.class);
            javax.xml.bind.Unmarshaller ums = jc.createUnmarshaller();
            File xmlFile = new File("src\\Xml\\OrganizasyonSiparis.xml");
            OrganizasyonSiparis list = (OrganizasyonSiparis) ums.unmarshal(xmlFile);
            organizasyonListesi = list.getOrgList();
            for (OrganizasyonSiparis organizasyonSiparis1 : organizasyonListesi) {
                System.out.println("Organizasyon Adi:" + organizasyonSiparis1.getOrganizasyonAdi());
                System.out.println("Siparis Adi:" + organizasyonSiparis1.getSiparisAdi());
                System.out.println("Kişi Sayisi:" + organizasyonSiparis1.getKisiSayisi());
                System.out.println("Fiyat:" + organizasyonSiparis1.getFiyat());
                System.out.println();
            }
        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }

        return organizasyonListesi;
    }
}
