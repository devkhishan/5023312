public class SingletonPatternExample
{
    public static void main(String[] args)
    {
        Logger log = Logger.getInstance();
        TestZero test_zero = new TestZero();
        test_zero.print();
        TestOne test_one = new TestOne();
        test_one.print();
    }
}

class TestZero
{
    Logger log = Logger.getInstance();
    int offset = 21;
    void print()
    {
        log.variableChange += offset;
        log.print("Test Zero");
    }
}

class TestOne
{
    Logger log = Logger.getInstance();
    void print()
    {
        log.print("Test One");
    }
}

class Logger{
    private static Logger log;
    int variableChange;
    private Logger(){
        variableChange = 0;
        System.out.println("Variable Initialized : "+variableChange);
    }
    public static synchronized Logger getInstance()
    {
        if(log == null)
        {
            log = new Logger();
        }
        return log;
    }

    public void print(String caller)
    {
        System.out.println("Called By "+caller+": "+variableChange);
    }
}
