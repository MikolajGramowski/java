package gamingpc;

public class SSD
{
    private int capacity;
    private int freeSpace;

    public SSD(int capacity)
    {
        this.capacity = capacity;
        this.freeSpace = capacity;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public int getFreeSpace()
    {
        return freeSpace;
    }

    public int getSlotsRequired()
    {
        return (capacity > 2048) ? 2 : 1;
    }

    public void installGame(Game game)
    {
        if (freeSpace < game.getRequiredSpace())
        {
            throw new RuntimeException("Not enough space on SSD to install the game.");
        }
        freeSpace -= game.getRequiredSpace();
    }
}
