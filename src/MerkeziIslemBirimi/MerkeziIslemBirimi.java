package MerkeziIslemBirimi;
import Arayuz.Arayuz;
import Arayuz.IArayuz;
import CevreBirim.Eyleyici;
import CevreBirim.IEyleyici;
import CevreBirim.ISicaklikAlgilayici;
import CevreBirim.SicaklikAlgilayici;

public class MerkeziIslemBirimi implements IMerkeziIslemBirimi {
    private static MerkeziIslemBirimi instance = null;
    private MerkeziIslemBirimi() throws IllegalAccessException, InstantiationException {
    }
    public static MerkeziIslemBirimi getInstance() throws IllegalAccessException, InstantiationException {
        if (instance == null) {
            instance = new MerkeziIslemBirimi();
        }
        return instance;
    }
    IArayuz _arayuz = new Arayuz();
    ISicaklikAlgilayici _sicaklikAlgilayici = new SicaklikAlgilayici();
    IEyleyici _eyleyici = new Eyleyici();
    @Override
    public boolean arayuzGirisi() {
        return _arayuz.kullaniciGiris();
    }
    @Override
    public int islemSecimi() {
        return _arayuz.islemSecimi();
    }
    @Override public void islemYap() {
        if (arayuzGirisi()) {
            int islem = 0;
            do {
                islem = islemSecimi();
                switch (islem) {
                    case 1:
                        sicaklikGoster();
                        break;
                    case 2:
                        sogutucuAc();
                        break;
                    case 3:
                        sogutucuKapat();
                        break;
                    case 4:
                        cikis();
                        break;
                    default:
                        System.out.println("Lütfen geçerli bir işlem seçiniz!");
                        break;
                }
            } while (islem != 4);
        } else {
            System.out.println("Arayüze giriş başarısız!");
        }
    }
    @Override
    public void sicaklikGoster() {
        _arayuz.sicaklikGonder(_sicaklikAlgilayici);
    }
    @Override
    public void sogutucuAc() {
        _arayuz.sogutucuAc(_eyleyici);
    }
    @Override
    public void sogutucuKapat() {
        _arayuz.sogutucuKapat(_eyleyici);
    }
    @Override
    public void cikis() {
        _arayuz.Cikis();
    }
}