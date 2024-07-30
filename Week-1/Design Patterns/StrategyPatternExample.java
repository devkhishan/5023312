interface PaymentStrategy
{
    void pay();
}

class CreditCardPayment implements PaymentStrategy
{
    @Override
    public void pay()
    {
        System.out.println("Payment done through Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy
{
    @Override
    public void pay()
    {
        System.out.println("Payment done through PayPal");
    }
}

class PaymentContext
{
    private PaymentStrategy paymentStrategy;
    public PaymentContext(PaymentStrategy paymentStrategy)
    {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy)
    {
        this.paymentStrategy = paymentStrategy;
    }

    public void performPay()
    {
        paymentStrategy.pay();
    }

}

public class StrategyPatternExample
{
    public static void main(String[] args)
    {
        PaymentContext context = new PaymentContext(new PayPalPayment());
        context.performPay();

        context.setPaymentStrategy(new CreditCardPayment());
        context.performPay();

    }
}
