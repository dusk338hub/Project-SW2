import java.util.ArrayList;

import java.util.Scanner;

public class DataBaseM extends Data implements DealWithData {

    public Ride getRideCustomer(Customer customer)
    {
        ArrayList<Ride> tempR = new ArrayList();
        tempR = getPendingRides();
        for(int i=0;i<tempR.size();i++)
        {
            if (tempR.get(i).getPending_customer().getUserName().equals(customer.getUserName()))
            {
                return tempR.get(i);
            }
        }
        return null;
    }
    public void deleteRide(Customer customer)
    {
        ArrayList<Ride> tempR = new ArrayList();
        tempR = getPendingRides();
        for(int i=0;i<tempR.size();i++)
        {
            if (tempR.get(i).getPending_customer().getUserName().equals(customer.getUserName()))
            {
               tempR.remove(i);
               break;
            }
        }
        setPendingRides(tempR);

    }
public void  addPendingRide(Ride ride)
{
    ArrayList<Ride> tempR = new ArrayList();
   tempR = getPendingRides();
   tempR.add(ride );
   setPendingRides(tempR);
}
    public void setDriver(Driver driver) {
        ArrayList<Driver> drivers = new ArrayList();
        drivers = getDrivers();
        drivers.add((Driver) driver);
        setDrivers(drivers);
    }

    public void setCustomer(Customer customer) {
        ArrayList<Customer> customers = new ArrayList();
        customers = getCustomers();
        customers.add((Customer) customer);
        setCustomers(customers);
    }

    public boolean isSuspended(String username) {
        User user=getUser(username);
        ArrayList<User> Users = new ArrayList();
        Users = getSuspendedUsers();
        for (int i = 0; i < Users.size(); i++) {
            if (Users.get(i).getUserName().equals(user.getUserName()) &&
                    Users.get(i).getPassWord().equals(user.getPassWord())) {
                return true;
            }

        }
        return false;
    }
    public void addSuspended(User user)
    {
        ArrayList<User> Users = new ArrayList();
        Users = getSuspendedUsers();
        Users.add(user);
        setSuspendedUsers(Users);
    }

    @Override
    public void update(User user) {
        ArrayList<User> Users = new ArrayList();
        Users = getUsers();
        for (int i = 0; i < Users.size(); i++) {
            if (Users.get(i).getUserName().equals(user.getUserName()) &&
                    Users.get(i).getPassWord().equals(user.getPassWord())) {
                Users.remove(i);
                Users.add(user);
                setUsers(Users);
                break;
            }

        }

        if (user instanceof Driver) {
            ArrayList<Driver> Drivers = new ArrayList();
            Drivers = getDrivers();


            for (int i = 0; i < Drivers.size(); i++) {
                if (Drivers.get(i).getUserName().equals(user.getUserName())) {
                    Drivers.remove(i);
                    Drivers.add(((Driver) user));
                    setDrivers(Drivers);
                    break;

                }

            }
        } else {
            ArrayList<Customer> Customers = new ArrayList();
            Customers = getCustomers();

            for (int i = 0; i < Customers.size(); i++) {
                if (Customers.get(i).getUserName().equals(user.getUserName())) {
                    Customers.remove(i);
                    Customers.add((Customer) user);
                    setCustomers(Customers);
                    break;
                }

            }
        }


    }

    @Override
    public void set(User user) {
        ArrayList<User> Users = new ArrayList();
        Users = getUsers();
        Users.add(user);
        setUsers(Users);


    }

    @Override
    public void delete(User user) {
        ArrayList<User> Users = new ArrayList();
        Users = getUsers();
        for (int i = 0; i < Users.size(); i++) {
            if (Users.get(i).getUserName().equals(user.getUserName()) &&
                    Users.get(i).getPassWord().equals(user.getPassWord())) {
                Users.remove(i);

                setUsers(Users);
                break;
            }

        }

        if (user instanceof Driver) {
            ArrayList<Driver> Drivers = new ArrayList();
            Drivers = getDrivers();


            for (int i = 0; i < Drivers.size(); i++) {
                if (Drivers.get(i).getUserName().equals(user.getUserName())) {
                    Drivers.remove(i);

                    setDrivers(Drivers);
                    break;

                }

            }
        } else {
            ArrayList<Customer> Customers = new ArrayList();
            Customers = getCustomers();

            for (int i = 0; i < Customers.size(); i++) {
                if (Customers.get(i).getUserName().equals(user.getUserName())) {
                    Customers.remove(i);

                    setCustomers(Customers);
                    break;
                }

            }
        }
    }

    @Override
    public User get(User user) {
        return null;
    }

    public boolean logIn(String userName_Temp, String passWord) {
        ArrayList<User> Users = new ArrayList();
        Users = getUsers();
        for (int i = 0; i < Users.size(); i++) {
            if (Users.get(i).getUserName().equals(userName_Temp) &&
                    Users.get(i).getPassWord().equals(passWord)) return true;

        }
        return false;
    }

    public void signUp_Customer() {
        Customer customer = new Customer();
        Scanner input = new Scanner(System.in);
        System.out.println("enter the username");
        String username = input.nextLine();
        customer.setUserName(username);
        System.out.println("enter the password");
        String password = input.nextLine();
        customer.setPassWord(password);
        System.out.println("enter the mobilPhone");
        String mobilPhone = input.nextLine();
        customer.setMobileNumber(mobilPhone);
        System.out.println("enter the email");
        String email = input.nextLine();
        customer.setEmail(mobilPhone);
        setCustomer((Customer) customer);
        set(customer);

    }

    public Driver signUp_Driver() {
        Driver driver = new Driver();
        Scanner input = new Scanner(System.in);
        System.out.println("enter the username");
        String username = input.nextLine();
        driver.setUserName(username);
        System.out.println("enter the password");
        String password = input.nextLine();
        driver.setPassWord(password);
        System.out.println("enter the mobilPhone");
        String mobilPhone = input.nextLine();
        driver.setMobileNumber(mobilPhone);
        System.out.println("enter the drivingLicense");
        String drivingLicense = input.nextLine();
        driver.setDrivingLicense(drivingLicense);
        System.out.println("enter the nationalId");
        String nationalId = input.nextLine();
        driver.setDrivingLicense(nationalId);
        System.out.println("enter min cost  ");
        int cost_for_day = input.nextInt();
        driver.setCostForToday(cost_for_day);
        return driver;

    }

    public User getUser(String userName) {
        ArrayList<User> Users = new ArrayList();
        Users = getUsers();

        for (int i = 0; i < Users.size(); i++) {
            if (Users.get(i).getUserName().equals(userName))
                return Users.get(i);

        }
        return null;
    }

    public Driver getDriver(String userName) {
        ArrayList<Driver> Drivers = new ArrayList();
        Drivers = getDrivers();


        for (int i = 0; i < Drivers.size(); i++) {
            if (Drivers.get(i).getUserName().equals(userName))
                return Drivers.get(i);

        }
        return null;
    }

    public Customer getCustomer(String userName) {
        ArrayList<Customer> Customers = new ArrayList();
        Customers = getCustomers();

        for (int i = 0; i < Customers.size(); i++) {
            if (Customers.get(i).getUserName().equals(userName))
                return Customers.get(i);

        }
        return null;
    }

    public void getDUsers2() {
        ArrayList<Driver> Drivers = new ArrayList();
        Drivers = getDrivers();
        for (int i = 0; i < Drivers.size(); i++) {
            Drivers.get(i).showFAV();
        }
    }

}
