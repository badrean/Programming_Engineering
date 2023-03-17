import java.util.Vector;

public class User {

    private String ID;

    private boolean loginSuccessful;

    public Vector  my;
    public Vector  myTask;
    public Vector  myWeb;

    public User(String ID) {
        this.ID = ID;
    }

    public void viewMap() {
    }

    public void viewPage() {
    }

    public boolean login( String ID) {
        return true;
    }

    public boolean logout( String ID) {
        return false;
    }

    public void openPage(Boolean loginSuccessful) {
    }

    public void updateLocation() {
    }

}