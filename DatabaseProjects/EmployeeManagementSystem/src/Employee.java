public class Employee {
    private int id;
    private String name;
    private Double hourlyPay;
    private String job;

    Employee(int id, String name, Double hourlyPay, String job) {
        this.id = id;
        this.name = name;
        this.hourlyPay = hourlyPay;
        this.job = job;
    }
    public int getId() {
        return id;
    }
    public Double getHourlyPay() {
        return hourlyPay;
    }
    public String getName() {
        return name;
    }
    public String getJob() {
        return job;
    }
    public String toString() {
        return  "[ ID : " + getId() + " | NAME : " + getName() + " | Hourly Pay : " + getHourlyPay() + " | Job : " + getJob() + " ]";
    }

}
