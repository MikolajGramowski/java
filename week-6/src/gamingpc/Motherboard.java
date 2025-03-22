package gamingpc;

import java.util.ArrayList;
import java.util.List;

public class Motherboard
{
    private int maxSlots;
    private List<GraphicCard> graphicCards;
    private List<SSD> ssds;
    private List<SoundCard> soundCards;

    public Motherboard(int maxSlots)
    {
        this.maxSlots = maxSlots;
        this.graphicCards = new ArrayList<>();
        this.ssds = new ArrayList<>();
        this.soundCards = new ArrayList<>();
    }

    public int getMaxSlots()
    {
        return maxSlots;
    }

    public List<GraphicCard> getGraphicCards()
    {
        return graphicCards;
    }

    public List<SSD> getSsds()
    {
        return ssds;
    }

    public List<SoundCard> getSoundCards()
    {
        return soundCards;
    }

    public int getUsedSlots()
    {
        int used = 0;
        for (GraphicCard gc : graphicCards)
        {
            used += gc.getSlotsRequired();
        }
        for (SSD ssd : ssds)
        {
            used += ssd.getSlotsRequired();
        }
        for (SoundCard sc : soundCards)
        {
            used += sc.getSlotsRequired();
        }
        return used;
    }

    public int getAvailableSlots()
    {
        return maxSlots - getUsedSlots();
    }

    public void addGraphicCard(GraphicCard gc)
    {
        if (getAvailableSlots() < gc.getSlotsRequired())
        {
            throw new RuntimeException("Not enough slots for graphic card");
        }
        graphicCards.add(gc);
    }

    public void addSSD(SSD ssd)
    {
        if (getAvailableSlots() < ssd.getSlotsRequired())
        {
            throw new RuntimeException("Not enough slots for SSD");
        }
        ssds.add(ssd);
    }

    public void addSoundCard(SoundCard sc)
    {
        if (getAvailableSlots() < sc.getSlotsRequired())
        {
            throw new RuntimeException("Not enough slots for sound card");
        }
        soundCards.add(sc);
    }
}
