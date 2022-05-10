package DependencyInversion;

public class BasariliBaglanti implements IBaglantiMesaji{
    @Override
    public void baglantiMesaj() {
        System.out.println("Veritabanına başarılı bir şekilde bağlantı kuruldu...");
    }
}
