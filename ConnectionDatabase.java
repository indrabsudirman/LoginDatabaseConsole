/**
 * Login Database dengan Console mySQL
 *
 * @author (indrabsudirman - Github)
 * @version (Trail and Learning)
 */

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionDatabase
{
    public static Connection getConnection() {
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/login_console";
        final String USER = "root";
        final String PASS = "";
    
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    
    
    
}
