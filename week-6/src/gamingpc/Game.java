package gamingpc;

public class Game
{
    private String title;
    private int requiredSpace;
    private int requiredVideoMemory;

    public Game(String title, int requiredSpace, int requiredVideoMemory)
    {
        this.title = title;
        this.requiredSpace = requiredSpace;
        this.requiredVideoMemory = requiredVideoMemory;
    }

    public String getTitle()
    {
        return title;
    }

    public int getRequiredSpace()
    {
        return requiredSpace;
    }

    public int getRequiredVideoMemory()
    {
        return requiredVideoMemory;
    }
}
