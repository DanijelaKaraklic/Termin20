package model;

/**
 * Created by KaraklicDM on 27.10.2017.
 */

public class Biografija {
    private int id;
    private String recenica;
    private Glumac glumac;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecenica() {
        return recenica;
    }

    public void setRecenica(String recenica) {
        this.recenica = recenica;
    }

    public Glumac getGlumac() {
        return glumac;
    }

    public void setGlumac(Glumac glumac) {
        this.glumac = glumac;
    }



    public Biografija() {
    }

    public Biografija(int id, String recenica) {
        this.id = id;
        this.recenica = recenica;
    }



    @Override
    public String toString() {
        return  recenica;
    }
}
