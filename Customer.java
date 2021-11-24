import java.util.*;

public class Customer extends User {

    private ArrayList<Ride> rides;
    private Ride ride;
    private boolean isSuspend = false;
    public boolean isSuspend() {
        return isSuspend;
    }
    public void setSuspend(boolean suspend) {
        isSuspend = suspend;
    }

    public void giveDriverARate()
    {
        DataBaseM forMakingOffer=new DataBaseM();
        ArrayList<Driver>temp= Data.getDrivers();
        for(int i=0;i<temp.size();i++)
        {
            System.out.println(temp.get(i).getUserName());
        }
        System.out.println("do you want to rate any driver ( yes / no ) ");
        Scanner sc=new Scanner(System.in);
        String choose= sc.next();
        if (choose.equals("yes"))
        {
            System.out.println("enter the number of the driver");
            int x=sc.nextInt();
            x-=1;
            System.out.println("please enter the rate of the driver from 1 to 5 ");
            double rate=sc.nextDouble();
           temp.get(x).makeAvgRate2(rate);
        }
    }

    public void requestRide(String source, String destination) {
        Area area = new Area(source, destination);
        Ride ride=new Ride();
        ride.setArea(area);
        ride.setPending_customer(this);
        DataBaseM forMakingOffer=new DataBaseM();
        forMakingOffer.addPendingRide(ride);
    }
    public void checkOffers()
    {
        DataBaseM forMakingOffer=new DataBaseM();
        Ride ride=new Ride();
        ride= forMakingOffer.getRideCustomer(this);
        if (ride == null)
        {
            System.out.println("there is no offers ");
            return ;
        }
        ArrayList<Offer>offers=ride.getOffers();
        if (ride.getOffers().size()==0)
        {
            System.out.println("there is no offers ");
        }
        else
        {
            for(int i=0;i<offers.size();i++)
            {
                System.out.println(offers.get(i).getDriver().getUserName()+" "+offers.get(i).getPrice()
                +" "+offers.get(i).getDriver().getAvgRate());
            }
            System.out.println("do you want to accept any offer ( yes / no ) ");
            Scanner sc=new Scanner(System.in);
            String choose= sc.next();
            if (choose.equals("yes"))
            {
                System.out.println("enter the number of the offer");
                int x=sc.nextInt();
                x-=1;
                System.out.println("enjoy");
                System.out.println("please enter the rate of the ride from 1 to 5 ");
                double rate=sc.nextDouble();
                ride.setRate(rate);
                ride.setDriver(offers.get(x).getDriver());
                offers.get(x).getDriver().addRide(ride);
                offers.get(x).getDriver().makeAvgRate();
                forMakingOffer.deleteRide(this);

            }
            else
            {
                System.out.println("Done");
            }


        }
    }

    public void setRate(Ride ratedDriver, int rate) {
        ratedDriver.setRate(rate);

    }

    @Override
    public String toString() {
        return "Customer{" +
                "rides=" + rides +
                ", ride=" + ride +
                '}';
    }
}
