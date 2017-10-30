package model;

/**
 * Created by KaraklicDM on 27.10.2017.
 */

public class Film {

    private int id;
    private String nazivFilma;
    private float duzinaFilma;
    private String zanrFilma;
    private Glumac glumac;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivFilma() {
        return nazivFilma;
    }

    public void setNazivFilma(String nazivFilma) {
        this.nazivFilma = nazivFilma;
    }

    public float getDuzinaFilma() {
        return duzinaFilma;
    }

    public void setDuzinaFilma(float duzinaFilma) {
        this.duzinaFilma = duzinaFilma;
    }

    public String getZanrFilma() {
        return zanrFilma;
    }

    public void setZanrFilma(String zanrFilma) {
        this.zanrFilma = zanrFilma;
    }

    public Glumac getGlumac() {
        return glumac;
    }

    public void setGlumac(Glumac glumac) {
        this.glumac = glumac;
    }




    public Film() {
    }

    public Film(int id, String nazivFilma, float duzinaFilma) {
        this.id = id;
        this.nazivFilma = nazivFilma;
        this.duzinaFilma = duzinaFilma;
    }

    @Override
    public String toString() {
        return  nazivFilma;
    }
}
