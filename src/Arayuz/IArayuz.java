package Arayuz;
import CevreBirim.IEyleyici;
import CevreBirim.ISicaklikAlgilayici;

public interface IArayuz {
    public boolean kullaniciGiris();
    public int islemSecimi();
    public void sicaklikGonder(ISicaklikAlgilayici sicaklikAlgilayici);
    public void sogutucuAc(IEyleyici eyleyici);
    public void sogutucuKapat(IEyleyici eyleyici);
    public void Cikis();
}