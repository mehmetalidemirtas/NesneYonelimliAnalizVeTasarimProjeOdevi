package DependencyInversion;

public class MesajGoster {
    private  IBaglantiMesaji mesaj;
    public MesajGoster(IBaglantiMesaji mesaj){
        this.mesaj=mesaj;
    }

    public void mesajGoster(){
        mesaj.baglantiMesaj();
    }
}
