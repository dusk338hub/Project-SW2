import java.util.ArrayList;

public class Data {
    private static ArrayList<User> Users=new ArrayList();
    private static ArrayList<Driver> Drivers=new ArrayList();
    private static ArrayList<Customer> Customers=new ArrayList();
    private static ArrayList<User> SuspendedUsers=new ArrayList();
    private static ArrayList<Ride>pendingRides=new ArrayList();

    public static ArrayList<User> getSuspendedUsers() {
        return SuspendedUsers;
    }

    public static ArrayList<Ride> getPendingRides() {
        return pendingRides;
    }

    public static void setPendingRides(ArrayList<Ride> pendingRides) {
        Data.pendingRides = pendingRides;
    }

    public static void setSuspendedUsers(ArrayList<User> suspendedUsers) {
        SuspendedUsers = suspendedUsers;
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public static void setUsers(ArrayList<User> users) {
        Users = users;
    }

    public static void setDrivers(ArrayList<Driver> drivers) {
        Drivers = drivers;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        Customers = customers;
    }

    public static ArrayList<Driver> getDrivers() {
        return Drivers;
    }

    public static ArrayList<Customer> getCustomers() {
        return Customers;
    }
}
