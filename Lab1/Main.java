import java.util.Vector;
import java.util.logging.SocketHandler;

abstract class Human{
    private int varsta;
    private String nume;
    public String getNume() {
        return nume;
    }
    public int getVarsta() {
        return varsta;
    }
    
    public void setVarsta(int _varsta){
        varsta = _varsta;
    }
    public void setNume(String _nume){
        nume = _nume;
    }
    abstract public void tellWhoYouAre();
}

class Driver extends Human{
    Driver(int varsta, String nume){
        this.setVarsta(varsta);
        this.setNume(nume);
    }
    public void tellWhoYouAre(){
        System.out.println("I'm the Driver" + this.getNume() + "and I'm " + this.getVarsta() + " years old.");
    }
}

class Passager extends Human{
    Passager(int varsta, String nume){
        this.setVarsta(varsta);
        this.setNume(nume);
    }
    public void tellWhoYouAre(){
        System.out.println("I'm the Passager" + this.getNume() + "and I'm " + this.getVarsta() + " years old.");
    }
    public void tellWhoYouAre(String mood){
        System.out.println("I'm the Passager and i feel " + mood);
    }
}
abstract class Car{
    private String culoare;
    private String marca;

    private int nrLocuri;

    public Vector<Human> humans;

    public int getNrLocuri() {
        return nrLocuri;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void addPassager(Passager passager){
        humans.add((Human)passager);
    }

    public void showInfo(){
        System.out.println("Culoare:" + culoare);
        System.out.println("Nr Locuri:" + nrLocuri);
        System.out.println("Marca: " + marca);
        System.out.println("Sofer:" + humans.elementAt(0).getNume());
        System.out.println("Pasageri:");
        for(int i=1; i < humans.size(); i++) {
            System.out.println("    " + humans.elementAt(i).getNume());
        }
        System.out.println("\n");
    }
    abstract public void shoutType();
}

class ElectricCar extends Car{
    ElectricCar(String _culoare, String _marca, int _nrLocuri, Driver driver){
        this.setCuloare(_culoare);
        this.setMarca(_marca);
        this.setNrLocuri(_nrLocuri - 1); //sofer
        humans = new Vector<Human>();
        humans.add(driver);
    }
    public void shoutType(){
        System.out.println("I'm electric");
    }
}

class CombustionCar extends Car{
    CombustionCar(String _culoare, String _marca, int _nrLocuri, Driver driver){
        this.setCuloare(_culoare);
        this.setMarca(_marca);
        this.setNrLocuri(_nrLocuri - 1); //sofer
        humans = new Vector<Human>();
        humans.add(driver);
    }
    public void shoutType(){
        System.out.println("I'm combustions");
    }
}


public class Main {
    public static void main(String[] args) {
        Human passager1 = new Passager(18, "Bogdan");
        Human passager2 = new Passager(18, "Andrei");
        Human passager3 = new Passager(18, "Lavius");
        Human passager4 = new Passager(18, "Achile");
        Human passager5 = new Passager(18, "Riccardo");
        Human passager6 = new Passager(18, "Adriam");
        Human driver = new Driver(34,"Marcel");
        passager1.tellWhoYouAre();
        driver.tellWhoYouAre();
        ((Passager)passager1).tellWhoYouAre("false");

        ElectricCar masinaEl1 = new ElectricCar("rosu", "Audi", 5, (Driver) driver);
        ElectricCar masinaEl2 = new ElectricCar("rosu", "Audi", 5, (Driver) driver);
        CombustionCar masinaCom1 = new CombustionCar("rosu", "BMW", 5, (Driver) driver);
        CombustionCar masinaCom2 = new CombustionCar("rosu", "BMW", 5, (Driver) driver);

        masinaEl1.addPassager((Passager) passager1);
        masinaEl1.addPassager((Passager) passager2);

        masinaEl2.addPassager((Passager) passager3);
        masinaEl2.addPassager((Passager) passager4);

        masinaCom1.addPassager((Passager) passager5);
        masinaCom1.addPassager((Passager) passager6);

        masinaCom2.addPassager((Passager) passager2);
        masinaCom2.addPassager((Passager) passager1);

        System.out.printf("\n");
        masinaEl1.shoutType();
        masinaEl1.showInfo();
        System.out.printf("\n");

        masinaEl2.shoutType();
        masinaEl2.showInfo();
        System.out.printf("\n");

        masinaCom1.shoutType();
        masinaCom1.showInfo();
        System.out.printf("\n");

        masinaCom2.shoutType();
        masinaCom2.showInfo();
        System.out.printf("\n");


        //System.out.println("Hello world!");
    }
}