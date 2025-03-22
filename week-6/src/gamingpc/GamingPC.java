package gamingpc;

import java.util.ArrayList;
import java.util.List;

public class GamingPC
{
    private Motherboard motherboard;
    private List<Game> games;

    public GamingPC(Motherboard motherboard)
    {
        this.motherboard = motherboard;
        this.games = new ArrayList<>();
    }

    public void installGame(Game game)
    {
        int totalVideoMemory = 0;
        for (GraphicCard gc : motherboard.getGraphicCards())
        {
            totalVideoMemory += gc.getVideoMemory();
        }
        if (totalVideoMemory < game.getRequiredVideoMemory())
        {
            throw new RuntimeException("Not enough video memory to install the game.");
        }

        SSD selectedSSD = null;
        for (SSD ssd : motherboard.getSsds())
        {
            if (ssd.getFreeSpace() >= game.getRequiredSpace())
            {
                selectedSSD = ssd;
                break;
            }
        }
        if (selectedSSD == null)
        {
            throw new RuntimeException("Not enough storage space to install the game.");
        }

        selectedSSD.installGame(game);
        games.add(game);
    }

    public boolean hasEnoughSpace()
    {
        int totalCapacity = 0;
        int totalFreeSpace = 0;
        for (SSD ssd : motherboard.getSsds())
        {
            totalCapacity += ssd.getCapacity();
            totalFreeSpace += ssd.getFreeSpace();
        }
        double freePercent = ((double) totalFreeSpace / totalCapacity) * 100;
        return freePercent > 1.0;
    }
}
