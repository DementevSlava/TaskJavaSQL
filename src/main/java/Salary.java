import java.sql.*;

public class Salary {

    public static void main(String[] args) {

        String url = "jdbc:mysql://192.168.250.208/MONEY";
        String user = "slava";
        String password = "123456";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT DEPARTMENT, SUM(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String dep = rs.getObject(1).toString();
                String sum = rs.getObject(2).toString();
                System.out.println(dep + ":" + " " + sum);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
