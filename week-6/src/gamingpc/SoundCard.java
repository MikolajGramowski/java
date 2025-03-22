package gamingpc;

public class SoundCard
{
    private int channels;

    public SoundCard(int channels)
    {
        this.channels = channels;
    }

    public int getChannels()
    {
        return channels;
    }

    public int getSlotsRequired()
    {
        return 1;
    }
}
