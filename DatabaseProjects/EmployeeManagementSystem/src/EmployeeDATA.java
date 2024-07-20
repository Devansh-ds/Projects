import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDATA {
    
    public static ArrayList<Employee> readAllEmployess() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        try {
            Connection conn = DBC.connect();
            String query = Query.read;

            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
                list.add(emp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insertData(Employee newEmployee) {
        try {
            Connection conn = DBC.connect();
            String query = Query.insert;

            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, newEmployee.getId());
            pstm.setString(2, newEmployee.getName());
            pstm.setDouble(3, newEmployee.getHourlyPay());
            pstm.setString(4, newEmployee.getJob());

            pstm.executeUpdate();
            conn.close();
            System.out.println();
            System.out.println("----------Data Inserted Sucessfully----------");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateData(int eid, Double epay, String ejob) {
        try {
            Connection conn = DBC.connect();
            String query = Query.update;
    
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setDouble(1, epay);
            pstm.setString(2, ejob);
            pstm.setInt(3, eid);

            pstm.execute();
            conn.close();
            System.out.println();
            System.out.println("----------Data Updated Successfully----------");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteData(int eid) {
        try {
            Connection conn = DBC.connect();
            String query = Query.delete;

            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, eid);

            pstm.execute();
            conn.close();

            System.out.println();
            System.out.println("----------Data deleted Successfully----------");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
