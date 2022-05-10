package CevreBirim;
import Observer.IObserver;
import Observer.ISubject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici, ISubject {
    private List<IObserver> observers = new ArrayList<>();
    @Override
    public int sicaklikOku() {
        Random random = new Random(); return random.nextInt(100);
    }
    @Override
    public int sicaklikGonder() {
        System.out.println("Sıcaklık değeri " + sicaklikOku() + " derecedir."); return sicaklikOku();
    }

    @Override
    public void attach(IObserver o) {
        observers.add(o);
    }

    @Override
    public void detach(IObserver o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }


    @Override
    public void notifyMessage() {
            for (int i = 0; i < observers.size(); i++) {
                IObserver observer = (IObserver) observers.get(i);
                observer.guncelleme(sicaklikGonder());
            }
    }

}