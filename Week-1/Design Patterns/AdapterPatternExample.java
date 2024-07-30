interface PaymentProcessor
{
    void processPayment();
}

class Paytm implements PaymentProcessor
{
    public void processPayment()
    {
        System.out.println("Payment Processed through Paytm");
    }
}

class Paypal implements PaymentProcessor
{
    public void processPayment()
    {
        System.out.println("Payment Processed through Paypal");
    }
}

class Stripe implements PaymentProcessor
{
    public void processPayment()
    {
        System.out.println("Payment Processed through Stripe");
    }
}

class PaymentAdapter implements PaymentProcessor
{
    PaymentProcessor processor;

    public PaymentAdapter(String gateway)
    {
        if(gateway.equalsIgnoreCase("paytm"))
        {
            processor = new Paytm();
        }
        else if(gateway.equalsIgnoreCase("paypal"))
        {
            processor = new Paypal();
        }
        else if(gateway.equalsIgnoreCase("stripe"))
        {
            processor = new Stripe();
        }
    }

    public void processPayment()
    {
        processor.processPayment();
    }
}
public class AdapterPatternExample
{
    public static void main(String[] args) {
        PaymentProcessor processor_zero = new PaymentAdapter("paytm");
        PaymentProcessor processor_one = new PaymentAdapter("paypal");
        PaymentProcessor processor_two = new PaymentAdapter("stripe");


        processor_zero.processPayment();
        processor_one.processPayment();
        processor_two.processPayment();
    }

}
