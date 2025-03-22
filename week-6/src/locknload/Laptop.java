package locknload;

public class Laptop
{
    private String serialNumber;
    private int currentCharge;
    private int batteryCapacity;

    public Laptop(String serialNumber, int currentCharge, int batteryCapacity)
    {
        if (currentCharge > batteryCapacity)
        {
            throw new IllegalArgumentException("Current charge cannot be greater than battery capacity.");
        }
        if (currentCharge < 0)
        {
            throw new IllegalArgumentException("Current charge cannot be negative.");
        }
        if (batteryCapacity <= 0)
        {
            throw new IllegalArgumentException("Battery capacity must be greater than zero.");
        }
        this.serialNumber = serialNumber;
        this.currentCharge = currentCharge;
        this.batteryCapacity = batteryCapacity;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public int getCurrentCharge()
    {
        return currentCharge;
    }

    public void setCurrentCharge(int currentCharge)
    {
        this.currentCharge = currentCharge;
    }

    public int getBatteryCapacity()
    {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity)
    {
        this.batteryCapacity = batteryCapacity;
    }

    public double calculateCurrentBatteryPercentage()
    {
        return ((double) this.currentCharge / this.batteryCapacity) * 100;
    }
}
