
package sparepartsnew.db;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import sparepartsnew.util.DbUtil;

public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private final Connection connection;
    
    public DatabaseConnection() throws SQLException, IOException {
        DbUtil util = new DbUtil();        
        connection = DriverManager.getConnection(util.getURL(), util.getUser(), util.getPassword());
        System.out.println("Connection to DB successfull");
        }
    public static DatabaseConnection getInstance() throws SQLException, IOException {
        if (instance==null) {
            instance=new DatabaseConnection();
        }
        return instance;        
    }
    public Connection getConnection() throws SQLException {
        return connection;
    }
    
    public void closeConnection() throws SQLException {
        if (connection !=null && !connection.isClosed()) connection.close();
    }
    public void confirmTransaction() throws SQLException {
        try {
            connection.commit();
            System.out.println("Transaction completed successfully");
        } catch (SQLException ex) {
            System.err.println("Error: Transaction not performed successfully");
            ex.printStackTrace();
            throw new SQLException("There has been an error during transaction!\n" + ex.getMessage());
        }
    }
    
    public void cancelTransation () throws SQLException {
        try {
            connection.rollback();
            System.out.println("Transaction has been cancelled successfully");
        } catch (SQLException ex) {
            System.err.println("Error: Transaction hasn't been cancelled");
            ex.printStackTrace();
            throw new SQLException("There has been an error during canceling transaction!\n" + ex.getMessage());
        }
    }
       
}
