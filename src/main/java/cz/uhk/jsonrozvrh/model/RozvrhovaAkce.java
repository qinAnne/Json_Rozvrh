package cz.uhk.jsonrozvrh.model;

public class RozvrhovaAkce {
    private String nazev;
    private String predmet;
    //private Ucitel ucitel;
    private String typAkceZkr;
    private String den;
    private Datum hodinaSkutOd;
    private Datum hodinaSkutDo;
    private String vsichniUciteleJmenaTituly;
    private String vsichniUcitelePrijmeni;

    public String getNazev() {
        return nazev;
    }

    public String getPredmet() {
        return predmet;
    }

//    public Ucitel getUcitel() {
//        return ucitel;
//    }

    public String getTypAkceZkr() {
        return typAkceZkr;
    }

    public String getDen() {
        return den;
    }

    public Datum getHodinaSkutOd() {
        return hodinaSkutOd;
    }

    public Datum getHodinaSkutDo() {
        return hodinaSkutDo;
    }

    public String getVsichniUciteleJmenaTituly() {
        return vsichniUciteleJmenaTituly;
    }

    public String getVsichniUcitelePrijmeni() {
        return vsichniUcitelePrijmeni;
    }
}

