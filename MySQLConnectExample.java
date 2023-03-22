import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnectExample {
    public static void main(String[] args) {
        Connection conn1 = null;
        String url1 = "jdbc:mysql://localhost:3306/Fantasy_game";
        String user = "marcos";
        String password = "Killingball0!";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load the JDBC driver
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 == null) {
                System.out.println("Connection failed");
            } else {
                System.out.println("Connection successful");
                Statement stmt = conn1.createStatement();
                // using the stmt.executeUpdate() method to execute a SQL statement delete everything on id 11
                //stmt.executeUpdate("DELETE FROM Monsters WHERE id = 11");
                //stmt.executeUpdate("INSERT INTO Monsters VALUES (11, 'Gman', 9999, 9999, 9999)");
                ResultSet rs = stmt.executeQuery("SELECT id, hp, def, atk, name FROM Monsters");
                System.out.println("ID | hp | def | atk | name");
                System.out.println("---|----|-----|-----|-----");
                while (rs.next()) {
                    int id = rs.getInt(1);
                    int hp = rs.getInt(2);
                    int def = rs.getInt(3);
                    int atk = rs.getInt(4);
                    String name = rs.getString(5);
                    if (id>=10){
                        System.out.printf("|%d|%-4d|%-4d |%-4d |%s\n", id, hp, def, atk, name);}
                        else{
                            System.out.printf("|%d |%-4d|%-4d |%-4d |%s\n", id, hp, def, atk, name);
                        }
                    }
                }
            }           
         catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}
    