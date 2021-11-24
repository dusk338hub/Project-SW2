import java.util.*;
public class Admin extends DataBaseM {
    private String userName;
    private static ArrayList<Driver> pendingDrivers=new ArrayList();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    Admin(String for_userName,String for_password)
    {
        userName = for_userName;
        password = for_password;
    }
    public  void addPendingDriver(Driver driver)
    {
        pendingDrivers.add(driver);
    }
    public  void printPendingDrivers()
    {

        if (pendingDrivers.size()==0)
        {
            System.out.println("there is no pending Drivers");
            return;
        }
        for(int i=0;i<pendingDrivers.size();i++)
        {
            System.out.println( pendingDrivers.get(i).getUserName()+" "+pendingDrivers.get(i).getDrivingLicense());
        }
        System.out.println("enter the number of the driver");
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        x-=1;
        setDriver(pendingDrivers.get(x));
        set(pendingDrivers.get(x));
        pendingDrivers.remove(x);

    }

    public void suspend(String username)
    {
        User forSuspend=getUser(username);
        addSuspended(forSuspend);


    }

}
