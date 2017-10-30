package provider;

import java.util.ArrayList;
import java.util.List;

import model.Film;

/**
 * Created by KaraklicDM on 27.10.2017.
 */

public class FilmProvider {
    public static List<Film> getFilmovi(){
        List<Film> filmovi = new ArrayList<>();
        filmovi.add(new Film(0,"Hamlet",125));
        filmovi.add(new Film(1,"Gataka",150));

        filmovi.add(new Film(2,"Radovan 3",180));
        filmovi.add(new Film(3,"Sesta brzina",180));

        filmovi.add(new Film(4,"Praznik u Rimu",120));
        filmovi.add(new Film(5,"Dorucak kod Tifanija",120));

        return filmovi;
    }

    public static List<String> getFilmoviNames(){
        List<String> nazivi = new ArrayList<>();
        nazivi.add("Hamlet");
        nazivi.add("Gataka");
        nazivi.add("Radovan 3");
        nazivi.add("Sesta brzina");
        nazivi.add("Praznik u Rimu");
        nazivi.add("Dorucak kod Tifanija");
        return nazivi;
    }

    public static Film getFilmById(int id){
        switch(id){
            case 0: return new Film(0,"Hamlet",125);
            case 1: return new Film(1,"Gataka",150);
            case 2: return new Film(2,"Radovan 3",180);
            case 3: return new Film(3,"Sesta brzina",180);
            case 4: return new Film(4,"Praznik u Rimu",120);
            case 5: return new Film(5,"Dorucak kod Tifanija",120);

        }
        return null;
    }
}
