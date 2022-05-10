package DependencyInversion;

public class BasarisizBaglanti implements IBaglantiMesaji{
    @Override
    public void baglantiMesaj() {
        System.out.println("Veritabanına bağlantı başarısız!!!");
    }
}
