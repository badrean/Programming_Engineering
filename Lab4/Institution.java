import java.util.HashMap;
import java.util.Vector;

public class Institution {

    public String name;

    public String address;

    public HashMap neededPapers;

    public String utility;

    public String ID;

    public boolean loginSuccessful;

    public Vector  myWeb;

    public Institution(String name) {
        this.name = name;
    }

    public void viewMap() {
    }

    public void operatingTime() {
    }

    public boolean login() {
        return true;
    }

    public boolean logout() {
        return false;
    }

}
