import java.sql.Connection;
import java.sql.DriverManager;

public class DBC {

    static Connection conn = null;
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/EMPDatabase";
            String userName = "root";
            String password = "Devansh2005@#";

            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
