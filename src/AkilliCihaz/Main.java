package AkilliCihaz;

import Factory.ISogutucu;
import MerkeziIslemBirimi.IMerkeziIslemBirimi;
import MerkeziIslemBirimi.MerkeziIslemBirimi;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        IMerkeziIslemBirimi merkeziIslemBirimi = MerkeziIslemBirimi.getInstance();
        merkeziIslemBirimi.islemYap();
    }
}
