interface Notifier
{
    String send();
}

class EmailNotifier implements Notifier
{
    private final String message;
    public EmailNotifier(String message)
    {
        this.message = message;
    }

    @Override
    public String send()
    {
        return message;
    }
}

abstract class NotifierDecorator implements Notifier
{
    protected Notifier notifier;
    public NotifierDecorator(Notifier notifier)
    {
        this.notifier = notifier;
    }

    @Override
    public String send()
    {
        return notifier.send();
    }
}

class SMSNotifierDecorator extends NotifierDecorator
{
    public SMSNotifierDecorator(Notifier notifier)
    {
        super(notifier);
    }

    @Override
    public String send()
    {
        return super.send()+": Sent through SMS";
    }
}

class SlackNotifierDecorator extends NotifierDecorator
{
    public SlackNotifierDecorator(Notifier notifier)
    {
        super(notifier);
    }

    @Override
    public String send()
    {
        return super.send()+": Sent through Slack";
    }
}

public class DecoratorPatternExample
{
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier("I am doing good");
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println(notifier.send());
        System.out.println(smsNotifier.send());
        System.out.println(slackNotifier.send());

    }
}
