package provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Biografija;
import model.Film;
import model.Glumac;

/**
 * Created by KaraklicDM on 27.10.2017.
 */

public class GlumacProvider {






    public static List<Glumac> getGlumac() {



        ArrayList<Biografija> biografijaItan = new ArrayList<>();
        ArrayList<Biografija> biografijaZoran = new ArrayList<>();
        ArrayList<Biografija> biografijaOdri = new ArrayList<>();


        biografijaItan.add(new Biografija(0,"Rodjen je u Ostinu."));
        biografijaItan.add(new Biografija(1,"Americki je glumac i reditelj."));
        biografijaItan.add(new Biografija(2,"Imao je 4 nominacije za Oskara za film \"Drustvo mrtvih pesnika\"."));


        biografijaZoran.add(new Biografija(3,"Rodjen je u Zajecaru."));
        biografijaZoran.add(new Biografija(4,"Studirao je engleski, pravo i arhitekturu."));
        biografijaZoran.add(new Biografija(5,"Zavrsio je FDU."));


        biografijaOdri.add(new Biografija(6,"Rodjen je u Briselu."));
        biografijaOdri.add(new Biografija(7,"Bila je balerina, a bavila se i modelingom."));
        biografijaOdri.add(new Biografija(8,"Za film \"Praznik u Rimu\" je osvojila Oskara."));



        ArrayList<Film> filmoviItan = new ArrayList<>();
        ArrayList<Film> filmoviZoran = new ArrayList<>();
        ArrayList<Film> filmoviOdri = new ArrayList<>();

        filmoviItan.add(new Film(0,"Hamlet",125));
        filmoviItan.add(new Film(1,"Gataka",150));

        filmoviZoran.add(new Film(2,"Radovan 3",180));
        filmoviZoran.add(new Film(3,"Sesta brzina",180));

        filmoviOdri.add(new Film(4,"Praznik u Rimu",120));
        filmoviOdri.add(new Film(5,"Dorucak kod Tifanija",120));



        List<Glumac> glumci = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        try {
            Date datumItanrodj = sdf.parse("12.04.1966.");
            Date datumItanSmrt = null;

            Date datumZoranrodj = sdf.parse("01.05.1930.");
            Date datumZoranSmrt = sdf.parse("01.05.1985.");

            Date datumOdrirodj = sdf.parse("12.06.1925.");
            Date datumOdriSmrt = sdf.parse("01.05.1975.");

            glumci.add(new Glumac(0,"ethan_hawke.jpeg","Itan", "Houk", datumItanrodj,datumItanSmrt,biografijaItan,4.5f,filmoviItan));
            glumci.add(new Glumac(1,"zoran_radmilovic.jpeg","Zoran", "Radmilovic",datumZoranrodj,datumZoranSmrt,biografijaZoran,5.0f,filmoviZoran));
            glumci.add(new Glumac(3,"audrey_hepburn.jpeg","Odri", "Hepbern", datumOdrirodj,datumOdriSmrt,biografijaOdri,4.9f,filmoviOdri));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    return glumci;
    }


    public static List<String> getGlumacImena(){
        List<String> imena = new ArrayList<>();
        imena.add("Itan");
        imena.add("Zoran");
        imena.add("Odri");

        return imena;

    }

    public static List<String> getGlumacPrezimena(){
        List<String> prezimena = new ArrayList<>();
        prezimena.add("Houk");
        prezimena.add("Radmilovic");
        prezimena.add("Hepbern");

        return prezimena;

    }

    public static Glumac getGlumacById(int id){

        ArrayList<Biografija> biografijaItan = new ArrayList<>();
        ArrayList<Biografija> biografijaZoran = new ArrayList<>();
        ArrayList<Biografija> biografijaOdri = new ArrayList<>();


        biografijaItan.add(new Biografija(0,"Rodjen je u Ostinu."));
        biografijaItan.add(new Biografija(1,"Americki je glumac i reditelj."));
        biografijaItan.add(new Biografija(2,"Imao je 4 nominacije za Oskara za film \"Drustvo mrtvih pesnika\"."));


        biografijaZoran.add(new Biografija(3,"Rodjen je u Zajecaru."));
        biografijaZoran.add(new Biografija(4,"Studirao je engleski, pravo i arhitekturu."));
        biografijaZoran.add(new Biografija(5,"Zavrsio je FDU."));


        biografijaOdri.add(new Biografija(6,"Rodjen je u Briselu."));
        biografijaOdri.add(new Biografija(7,"Bila je balerina, a bavila se i modelingom."));
        biografijaOdri.add(new Biografija(8,"Za film \"Praznik u Rimu\" je osvojila Oskara."));



        ArrayList<Film> filmoviItan = new ArrayList<>();
        ArrayList<Film> filmoviZoran = new ArrayList<>();
        ArrayList<Film> filmoviOdri = new ArrayList<>();

        filmoviItan.add(new Film(0,"Hamlet",125));
        filmoviItan.add(new Film(1,"Gataka",150));

        filmoviZoran.add(new Film(2,"Radovan 3",180));
        filmoviZoran.add(new Film(3,"Sesta brzina",180));

        filmoviOdri.add(new Film(4,"Praznik u Rimu",120));
        filmoviOdri.add(new Film(5,"Dorucak kod Tifanija",120));



        Date datumItanrodj = null;
        Date datumItanSmrt = null;
        Date datumZoranrodj = null;
        Date datumZoranSmrt = null;
        Date datumOdrirodj = null;
        Date datumOdriSmrt = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        try {
            datumItanrodj = sdf.parse("12.04.1966.");
            datumItanSmrt = null;

            datumZoranrodj = sdf.parse("01.05.1930.");
            datumZoranSmrt = sdf.parse("01.05.1985.");

            datumOdrirodj = sdf.parse("12.06.1925.");
            datumOdriSmrt = sdf.parse("01.05.1975.");



        } catch (ParseException e) {
            e.printStackTrace();
        }

        switch(id){
            case 0: return new Glumac(0,"ethan_hawke.jpeg","Itan", "Houk", datumItanrodj,datumItanSmrt,biografijaItan,4.5f,filmoviItan);
            case 1: return new Glumac(1,"zoran_radmilovic.jpeg","Zoran", "Radmilovic",datumZoranrodj,datumZoranSmrt,biografijaZoran,5.0f,filmoviZoran);
            case 2: return new Glumac(3,"audrey_hepburn.jpeg","Odri", "Hepbern", datumOdrirodj,datumOdriSmrt,biografijaOdri,4.9f,filmoviOdri);
        }
        return null;
    }



}
//sdf.format(datum);
