package provider;

import java.util.ArrayList;
import java.util.List;

import model.Biografija;

/**
 * Created by KaraklicDM on 27.10.2017.
 */

public class BiografijaProvider {

    public static Biografija getBiografijaById(int id){
        switch (id) {
            case 0:
                return new Biografija(0, "Rodjen je u Ostinu.");
            case 1:
                return new Biografija(1,"Americki je glumac i reditelj.");
            case 2:
                return new Biografija(2,"Imao je 4 nominacije za Oskara za film \"Drustvo mrtvih pesnika\".");
            case 3:
                return new Biografija(3,"Rodjen je u Zajecaru.");
            case 4:
                return new Biografija(4,"Studirao je engleski, pravo i arhitekturu.");
            case 5:
                return new Biografija(5,"Zavrsio je FDU.");
            case 6:
                return new Biografija(6,"Rodjen je u Briselu.");
            case 7:
                return new Biografija(7,"Bila je balerina, a bavila se i modelingom.");
            case 8:
                return new Biografija(8,"Za film \"Praznik u Rimu\" je osvojila Oskara.");
        }
        return null;
    }

    public static List<String> getBiographyByActorId(int id){
        List<String> list = new ArrayList<>();
        switch (id){
            case 0: {
                list.add(new Biografija(0, "Rodjen je u Ostinu.").toString());
                list.add(new Biografija(1, "Americki je glumac i reditelj.").toString());
                list.add(new Biografija(2, "Imao je 4 nominacije za Oskara za film \"Drustvo mrtvih pesnika\".").toString());
                return list;
            }
            case 1: {
                list.add(new Biografija(3, "Rodjen je u Zajecaru.").toString());
                list.add(new Biografija(4, "Studirao je engleski, pravo i arhitekturu.").toString());
                list.add(new Biografija(5, "Zavrsio je FDU.").toString());
                return list;
            }
            case 2: {
                list.add(new Biografija(6, "Rodjen je u Briselu.").toString());
                list.add(new Biografija(7, "Bila je balerina, a bavila se i modelingom.").toString());
                list.add(new Biografija(8, "Za film \"Praznik u Rimu\" je osvojila Oskara.").toString());
                return list;
            }
        }
        return null;
    }

}
