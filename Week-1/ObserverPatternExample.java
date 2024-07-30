import java.util.*;
interface Stock
{
    void register(Observer ob);
    void deRegister(Observer ob);
    void _notify(int stockPrice);
}

interface Observer
{
    void update(int stockPrice);
}

class MobileApp implements Observer
{
    private int stockPrice;

    @Override
    public void update(int stockPrice)
    {
        this.setPrice(stockPrice);
    }

    public void setPrice(int stockPrice)
    {
        this.stockPrice = stockPrice;
    }

    public int getPrice()
    {
        return this.stockPrice;
    }
}

class WebApp implements Observer
{
    private int stockPrice;

    @Override
    public void update(int stockPrice)
    {
        this.setPrice(stockPrice);
    }

    public void setPrice(int stockPrice)
    {
        this.stockPrice = stockPrice;
    }

    public int getPrice()
    {
        return this.stockPrice;
    }
}
class StockMarket implements Stock
{
    private int stockPrice;
    private List<Observer> observers = new ArrayList<>();

    public void register(Observer observer)
    {
        observers.add(observer);
    }

    public void deRegister(Observer observer)
    {
        observers.remove(observer);
    }

    public void _notify(int stockPrice)
    {
        this.stockPrice = stockPrice;
        for(Observer ob : observers)
        {
            ob.update(this.stockPrice);
        }
    }
}


public class ObserverPatternExample
{
    public static void main(String[] args)
    {
        StockMarket observable = new StockMarket();
        WebApp observer_zero = new WebApp();
        MobileApp observer_one = new MobileApp();

        observable.register(observer_zero);
        observable.register(observer_one);

        observable._notify(543);
        System.out.println("WebApp Stock Price : "+observer_zero.getPrice());
        System.out.println("MobileApp Stock Price : "+observer_one.getPrice());

        observable.deRegister(observer_one);
        observable._notify(334);
        System.out.println("WebApp Stock Price : "+observer_zero.getPrice());
        System.out.println("MobileApp Stock Price : "+observer_one.getPrice());

    }
}
