package locknload;

public class Locker
{
    private String lockerNumber;
    private Laptop laptop;

    public Locker(String lockerNumber, Laptop laptop)
    {
        this.lockerNumber = lockerNumber;
        this.laptop = laptop;
    }

    public String getLockerNumber()
    {
        return lockerNumber;
    }

    public void setLockerNumber(String lockerNumber)
    {
        this.lockerNumber = lockerNumber;
    }

    public Laptop getLaptop()
    {
        return laptop;
    }

    public void setLaptop(Laptop laptop)
    {
        this.laptop = laptop;
    }
}
