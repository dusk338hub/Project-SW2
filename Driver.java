import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends User {
    private String drivingLicense;
    private String nationalId;
    private boolean isVerified = false;
    private ArrayList<String> favoriteAreas = new ArrayList();
    private ArrayList<Ride> rides = new ArrayList();
    private double avgRate;
    private int numberOfRides;
    private int costForToday;
    private boolean isSuspend = false;

    public boolean isSuspend() {
        return isSuspend;
    }

    public void setSuspend(boolean suspend) {
        isSuspend = suspend;
    }
    public boolean matchFavArea(String source)
    {
        for(int i=0;i<favoriteAreas.size();i++)
        {
            if(  favoriteAreas.get(i).equals(source))
                return true;

        }
        return false;
    }

    public void makeOffer() {
DataBaseM forOffer=new DataBaseM();
ArrayList<Ride>temp=new ArrayList();
temp= Data.getPendingRides();

        ArrayList<Ride>temp2=new ArrayList();

        for(int i=0;i<temp.size();i++)
        {
            if(matchFavArea(temp.get(i).getSource()))
            {
                temp2.add(temp.get(i));
            }
        }
if (temp2.size() ==0)
{
    System.out.println("no rides ");
    return;
}
        for(int i=0;i<temp2.size();i++)
        {
            temp2.get(i).printMakingOffer();
        }
        System.out.println("do you want make offer (yes / no)");
        Scanner sc=new Scanner(System.in);
String choose=sc.next();
if (choose.equals("yes"))
{
    System.out.println("enter the number of the ride");
    int x=sc.nextInt();
    x-=1;
    System.out.println("enter your price");
    int price=sc.nextInt();
    Offer offer=new Offer(price,this);
    temp2.get(x).addOffer(offer);

}
Data.setPendingRides(temp2);
    }

    public void makeAvgRate() {
        double for_rate = 0;
        for (int i = 0; i < rides.size(); i++) {
            for_rate += rides.get(i).getRate();
        }
        for_rate = for_rate / rides.size();
        avgRate = for_rate;
    }
    public void makeAvgRate2(double rate) {
        double for_rate = rate;
        for (int i = 0; i < rides.size(); i++) {
            for_rate += rides.get(i).getRate();
        }
        for_rate = for_rate /( rides.size()+1);
        avgRate = for_rate;
    }

    public void addArea(String source) {


        favoriteAreas.add(source);
    }

    public void addRide(Ride ride) {


        rides.add(ride);
    }

    public void listAllRides() {
        for (int i = 0; i < rides.size(); i++) {
            rides.get(i).print();
        }
    }

    public Ride checkForRequests() {
        return null;
    }


    public Driver(String drivingLicense, String nationalId, boolean isVerified, ArrayList<String> favoriteAreas, ArrayList<Ride> rides, double avgRate, int numberOfRides, int costForToday) {
        this.drivingLicense = drivingLicense;
        this.nationalId = nationalId;
        this.isVerified = isVerified;
        this.favoriteAreas = favoriteAreas;
        this.rides = rides;
        this.avgRate = avgRate;
        this.numberOfRides = numberOfRides;
        this.costForToday = costForToday;
    }

    public Driver(String userName, String mobileNumber, String passWord, String email, boolean isSuspend, String drivingLicense, String nationalId, boolean isVerified, ArrayList<String> favoriteAreas, ArrayList<Ride> rides, double avgRate, int numberOfRides, int costForToday) {
        super(userName, mobileNumber, passWord, email, isSuspend);
        this.drivingLicense = drivingLicense;
        this.nationalId = nationalId;
        this.isVerified = isVerified;
        this.favoriteAreas = favoriteAreas;
        this.rides = rides;
        this.avgRate = avgRate;
        this.numberOfRides = numberOfRides;
        this.costForToday = costForToday;
    }

    public Driver() {

    }

    public void showFAV() {
        for (int i = 0; i < favoriteAreas.size(); i++)
            System.out.println(favoriteAreas.get(i));
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public ArrayList<String> getFavoriteAreas() {
        return favoriteAreas;
    }

    public void setFavoriteAreas(ArrayList<String> favoriteAreas) {
        this.favoriteAreas = favoriteAreas;
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public void setRides(ArrayList<Ride> rides) {
        this.rides = rides;
    }

    public double getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(double avgRate) {
        this.avgRate = avgRate;
    }

    public int getNumberOfRides() {
        return numberOfRides;
    }

    public void setNumberOfRides(int numberOfRides) {
        this.numberOfRides = numberOfRides;
    }

    public int getCostForToday() {
        return costForToday;
    }

    public void setCostForToday(int costForToday) {
        this.costForToday = costForToday;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "drivingLicense='" + drivingLicense + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", isVerified=" + isVerified +
                ", favoriteAreas=" + favoriteAreas +
                ", rides=" + rides +
                ", avgRate=" + avgRate +
                ", numberOfRides=" + numberOfRides +
                ", costForToday=" + costForToday +
                '}';
    }
}
