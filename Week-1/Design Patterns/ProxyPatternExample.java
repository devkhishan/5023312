interface Image
{
    void display();
}

class RealImage implements Image
{
    private final String fileName;
    public RealImage(String fileName)
    {
        this.fileName = fileName;
        System.out.println("Loaded File : "+fileName+" from Server to Cache");
    }

    @Override
    public void display()
    {
        System.out.println("Image : "+fileName);
    }
}

class ProxyImage implements Image
{
    private RealImage realImage;
    private final String fileName;

    public ProxyImage(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public synchronized void display()
    {
        if(realImage == null)
        {
            realImage =  new RealImage(fileName);
        }

        realImage.display();
    }
}
public class ProxyPatternExample
{
    public static void main(String[] args)
    {
        Image image_zero = new ProxyImage("image_zero.png");
        Image image_one = new ProxyImage("image_one.jpg");

        image_zero.display();
        image_one.display();

        image_zero.display();
        image_one.display();
    }
}
