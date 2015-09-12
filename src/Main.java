import Controller.*;
import Viewer.*;
import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main 
{
    public static void main(String[] args) 
    {
        Model m = new Model();
        Viewer v = new Viewer(m);
        Controller c = new Controller(m,v);
    }
}
