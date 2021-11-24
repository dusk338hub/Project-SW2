import java.util.*;

public class main {
    public static void main(String[] args) {
        Data dataBase = new Data();
        DataBaseM controller = new DataBaseM();

        Admin theAdmin = new Admin("admin", "0000");
        while (true) {
            Scanner input = new Scanner(System.in);
            // sign
            System.out.println("do you want to sign in or up   ");
            String ans_sign = input.nextLine();
            Driver driver = new Driver();
            Customer customer = new Customer();
            String status = "";
            if (ans_sign.equals("in")) {
                System.out.println("enter the username");
                String username = input.nextLine();
                System.out.println("enter the password");
                String password = input.nextLine();
                if (controller.isSuspended(username))
                {
                    System.out.println("you are suspended");
                    continue;
                }
                if (controller.logIn(username, password)) {
                    if (controller.getDriver(username) != null) {
                        driver = controller.getDriver(username);
                        status = "Driver";

                    } else if (controller.getCustomer(username) != null) {
                        customer = controller.getCustomer(username);
                        status = "Customer";

                    }


                } else if (username.equals(theAdmin.getUserName()) && password.equals(theAdmin.getPassword())) {
                    status = "Admin";

                } else {
                    System.out.println("Wrong password or username please try again ");
                }

            } else if (ans_sign.equals("up")) {
                System.out.println("do want to be driver or customer");
                String ans_DriverOrCustomer = input.nextLine();
                if (ans_DriverOrCustomer.equals("driver")) {
                    driver = controller.signUp_Driver();
                    theAdmin.addPendingDriver(driver);
                    continue;


                } else {
                    controller.signUp_Customer();
                    continue;
                }
            } else if (ans_sign.equals("exit")) {
                break;
            }
            if (status.equals("Customer")) {
                int choose_Customer = 0;
                while (choose_Customer != 4) {
                    System.out.println("1- request a ride");
                    System.out.println("2- check offers");
                    System.out.println("3- check offers");
                    System.out.println("4- sign out");
                    choose_Customer = input.nextInt();
                    if (choose_Customer == 1) {
                        System.out.println("enter the source");
                        String source = input.next();

                        System.out.println("enter the destination");
                        String destination = input.next();
                        customer.requestRide(source, destination);
                    }
                    else if (choose_Customer==2)
                    {
                        customer.checkOffers();
                    }
                    else if(choose_Customer==3)
                    {
                        customer.giveDriverARate();
                    }


                }

            } else if (status.equals("Driver")) {
                int choose_Driver = 0;
                while (choose_Driver != 6) {
                    System.out.println("1- Add Area");
                    System.out.println("2- change the cost of today");
                    System.out.println("3- list all rides");
                    System.out.println("4- make offer");
                    System.out.println("5- show average rate ");
                    System.out.println("6- sign out");
                    choose_Driver = input.nextInt();
                    if (choose_Driver == 1) {
                        System.out.println("enter the Area");
                        String source = input.next();
                        driver.addArea(source);
                    }
                    if (choose_Driver == 2) {
                        System.out.println("enter the cost");
                        int cost = input.nextInt();
                        driver.setCostForToday(cost);
                    }
                    if (choose_Driver == 3) {
                        driver.listAllRides();
                    }
                    if (choose_Driver==4)
                    {
                        driver.makeOffer();
                    }
                    if (choose_Driver==5)
                    {
                        System.out.println(driver.getAvgRate());
                    }
                }


            } else if (status.equals("Admin")) {
                int choose_Admin = 0;
                while (choose_Admin != 3) {
                    System.out.println("1- verify");
                    System.out.println("2- suspend");
                    System.out.println("3- sign out");
                    choose_Admin = input.nextInt();
                    if (choose_Admin == 1) {
                        theAdmin.printPendingDrivers();
                    }
                    if (choose_Admin == 2) {
                        System.out.println("enter the username");
                        String username_temp = input.next();
                        theAdmin.suspend(username_temp);
                        System.out.println("DONE");

                    }
                }
            }
        }


    }
}
