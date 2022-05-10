package Arayuz;
import CevreBirim.IEyleyici;
import Observer.IObserver;
import Database.UserManager;
import java.util.Scanner;
import CevreBirim.ISicaklikAlgilayici;

public class Arayuz implements IArayuz, IObserver {
    Scanner input = new Scanner(System.in);
    @Override
    public boolean kullaniciGiris() {
        int error = 0;
        do {
            System.out.println("KULLANICI GİRİŞ ARAYÜZÜ");
            UserManager user = new UserManager();
            System.out.println("Oturum açmak için lütfen kullanıcı adınızı ve parolanızı giriniz");
            System.out.print("Kullanıcı Adınız: ");
            user.SetKullaniciAdi(input.next());
            System.out.print("Parolanız: ");
            user.SetParola(input.next());
            boolean result = user.kullaniciDogrula(user.getKullaniciAdi(), user.getParola());
            if (result) {
                return true;
            }
            error++;
        }while (error != 3);
        return false;
    }
    @Override
    public int islemSecimi() {
        System.out.println("");
        System.out.println("İŞLEM MENÜSÜ");
        System.out.println("1.Sıcaklık Göster");
        System.out.println("2.Soğutucuyu Aç");
        System.out.println("3.Soğutucuyu Kapat");
        System.out.println("4.Çıkış");
        System.out.println("");
        System.out.println("Yapmak istediğiniz işlemi seçiniz: ");
        int choice = input.nextInt();
        System.out.println("Seçtiğiniz İşlem Numarası...: " + choice);
        return choice;
    }
    @Override
    public void sicaklikGonder(ISicaklikAlgilayici sicaklikAlgilayici) {
        sicaklikAlgilayici.sicaklikGonder();
    }
    @Override public void sogutucuAc(IEyleyici eyleyici) {
        eyleyici.sogutucuAc();
    }
    @Override
    public void sogutucuKapat(IEyleyici eyleyici) {
        eyleyici.sogutucuKapat();
    }
    @Override
    public void Cikis() {
        System.out.println("Oturumunuz başarıyla sonlandırıldı.");
    }
    @Override
    public void guncelleme(int sicaklik) { //IObserver sınıfından guncelleme metodu
        System.out.println("Sıcaklık güncellendi.");
    }
}