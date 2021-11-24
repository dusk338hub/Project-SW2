import java.util.ArrayList;

public class Ride {
    private Customer pending_customer;
    private Area area;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public void setOffers(ArrayList<Offer> offers) {
        this.offers = offers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private double rate = 0;
    private Driver driver;
    private ArrayList<Offer>offers=new ArrayList();
    private String status="";
public void addOffer(Offer offer)
{
    offers.add(offer);
}
    public void print() {
        System.out.println(pending_customer.getUserName() + "\n" +
                area.getSource() + " " + area.getDestination()+ "\n "+
                rate);
    }
    public void printMakingOffer()
    {
        System.out.println(pending_customer.getUserName()+" "+area.getSource()+ " "+area.getDestination());
    }
    public void printOffers()
    {
        if (offers.size()==0)
        {
            System.out.println("NO offers yet");
            return;
        }
        for(int i=0;i<offers.size();i++)
        {
            System.out.println(offers.get(i).getDriver().getUserName()+" "+offers.get(i).getPrice()+ " "+
                    offers.get(i).getDriver().getAvgRate());
        }
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Customer getPending_customer() {
        return pending_customer;
    }

    public void setPending_customer(Customer pending_customer) {
        this.pending_customer = pending_customer;
    }

    public String getSource() {
        return area.getSource();
    }







    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
