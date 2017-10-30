package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by KaraklicDM on 27.10.2017.
 */

public class Glumac {
    private int id;
    private String slika;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private Date datumSmrti;
    private ArrayList<Biografija> biografijaLinije;
    private float ocena;
    private ArrayList<Film>filmovi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Date getDatumSmrti() {
        return datumSmrti;
    }

    public void setDatumSmrti(Date datumSmrti) {
        this.datumSmrti = datumSmrti;
    }

    public ArrayList<Biografija> getBiografijaLinije() {
        return biografijaLinije;
    }

    public void setBiografijaLinije(ArrayList<Biografija> biografijaLinije) {
        this.biografijaLinije = biografijaLinije;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public ArrayList<Film> getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(ArrayList<Film> filmovi) {
        this.filmovi = filmovi;
    }



    public Glumac() {
    }

    public Glumac(int id, String slika, String ime, String prezime, Date datumRodjenja, Date datumSmrti, ArrayList<Biografija> biografijaLinije, float ocena, ArrayList<Film> filmovi) {
        this.id = id;
        this.slika = slika;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.datumSmrti = datumSmrti;
        this.biografijaLinije = biografijaLinije;
        this.ocena = ocena;
        this.filmovi = filmovi;
    }


    @Override
    public String toString() {
        return "Glumac{" +
                "id=" + id +
                ", slika='" + slika + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", datumSmrti=" + datumSmrti +
                ", ocena=" + ocena +
                '}';
    }
}

