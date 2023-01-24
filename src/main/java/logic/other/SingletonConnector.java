package Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnector {
    private static Connection connection = null;
    private static SingletonConnector myConnector = null;

    private SingletonConnector() throws SQLException{
     //   String db_name = "" ;//String dbPort ="";
        String dbUsername = "root";
        String dbPassword = "password";
        String url = "";
        connection = DriverManager.getConnection(url, dbUsername, dbPassword);
    }
    public static SingletonConnector getInstance() throws SQLException{
        if(myConnector == null){
            myConnector = new SingletonConnector();
        }
        return myConnector;
    }
    public Connection getConnection() {return connection;}
}
