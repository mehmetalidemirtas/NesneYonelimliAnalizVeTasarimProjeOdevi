package CevreBirim;
import Factory.SogutucuAc;
import Factory.SogutucuFactory;
import Factory.SogutucuKapat;

public class Eyleyici implements IEyleyici {
    SogutucuAc sogutucuAcF = (SogutucuAc) SogutucuFactory.createSogutucu(SogutucuAc.class);
    SogutucuKapat sogutucuKapatF = (SogutucuKapat) SogutucuFactory.createSogutucu(SogutucuKapat.class);
    public Eyleyici() throws IllegalAccessException, InstantiationException {
    }
    boolean sogutucuAcik = false;
    @Override
    public void sogutucuAc() {
        if(sogutucuAcik ==true) {
            System.out.println("Soğutucu zaten açık");
        }
        else {
            sogutucuAcF.sogutucuYazi();
            sogutucuAcik = true;
        }
    }
    @Override public void sogutucuKapat() {
        if(sogutucuAcik ==false) {
            System.out.println("Soğutucu zaten kapalı");
        }
        else{
            sogutucuKapatF.sogutucuYazi();
            sogutucuAcik =false;
        }
    }
}