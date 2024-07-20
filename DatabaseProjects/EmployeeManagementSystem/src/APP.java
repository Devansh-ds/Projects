import java.util.ArrayList;
import java.util.Scanner;

class App {
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to Employee Management database!");
            System.out.println("What do you want to do today?");
            System.out.println("\t1)Read \n\t2)Insert \n\t3)Update \n\t4)Delete \n\t5)Exit");
            System.out.print("Your Choice : ");
            Scanner sc = new Scanner(System.in);

            int choice = sc.nextInt();

            switch (choice) {
                case 1 : 
                    ArrayList<Employee> list = EmployeeDATA.readAllEmployess();
                    for (Employee emp : list) {
                        System.out.println(emp);
                    }
                    System.out.println();
                    System.out.println("----------Data readed successfully----------");
                    System.out.println();
                    break;
                case 2 : 
                    System.out.println("Input employee id, name, hourlyPay and job");
                    Scanner semp = new Scanner(System.in);
                    try {
                        int sid = Integer.parseInt(semp.nextLine());
                        String sname = semp.nextLine();
                        Double spay = Double.parseDouble(semp.nextLine());
                        String sjob = semp.nextLine();

                        Employee newEmployee = new Employee(sid, sname, spay, sjob);
                        EmployeeDATA.insertData(newEmployee);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3 :
                    System.out.println("Enter ID of the employee and their new pay and job.");
                    Scanner sup = new Scanner(System.in);
                    try {
                        System.out.print("ID : ");
                        int eid = Integer.parseInt(sup.nextLine());

                        System.out.print("New Hourly Pay : ");
                        Double epay = Double.parseDouble(sup.nextLine());

                        System.err.print("New/Same Job : ");
                        String ejob = sup.nextLine();
                        EmployeeDATA.updateData(eid, epay, ejob);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 4 :
                    System.out.println("Enter ID of the employee you want to remove the data.");
                    Scanner sdel = new Scanner(System.in);
                    try {
                        int eid = Integer.parseInt(sdel.nextLine());
                        EmployeeDATA.deleteData(eid);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 5 :
                    System.out.println();
                    System.out.println("----------EXITED----------");
                    System.out.println();
                    exit = true;
            }

        }
    }
}
