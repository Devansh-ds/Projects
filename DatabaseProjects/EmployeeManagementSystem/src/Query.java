public class Query {
    public static String read = "Select * from emp_m";
    public static String insert = "Insert into emp_m values (?,?,?,?)";
    public static String update = "Update emp_m set hourlyPay = ? , job = ? where id = ?";
    public static String delete = "Delete from emp_m where ID = ?";
}
