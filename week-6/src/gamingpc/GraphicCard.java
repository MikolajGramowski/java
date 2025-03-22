package gamingpc;

public class GraphicCard
{
    private double maxGHz;
    private int videoMemory;

    public GraphicCard(double maxGHz, int videoMemory)
    {
        this.maxGHz = maxGHz;
        this.videoMemory = videoMemory;
    }

    public double getMaxGHz()
    {
        return maxGHz;
    }

    public int getVideoMemory()
    {
        return videoMemory;
    }

    public int getSlotsRequired()
    {
        return 3;
    }
}
