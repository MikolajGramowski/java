package gamingpc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamingPCTest
{
    private GamingPC gamingPC;
    private Motherboard motherboard;

    @BeforeEach
    void setup()
    {
        motherboard = new Motherboard(10);
        motherboard.addGraphicCard(new GraphicCard(1.5, 2048));
        motherboard.addSSD(new SSD(4096));
        motherboard.addSoundCard(new SoundCard(2));
        gamingPC = new GamingPC(motherboard);
    }

    @Test
    void installGame_gameFits_gameInstalled()
    {
        Game game = new Game("TestGame", 500, 1024);
        gamingPC.installGame(game);
        SSD ssd = motherboard.getSsds().get(0);
        assertEquals(4096 - 500, ssd.getFreeSpace());
    }

    @Test
    void installGame_notEnoughVideoMemory_runtimeExceptionThrown()
    {
        Game game = new Game("HeavyGame", 500, 4096);
        assertThrows(RuntimeException.class, () -> gamingPC.installGame(game));
    }

    @Test
    void installGame_notEnoughStorage_runtimeExceptionThrown()
    {
        Game game = new Game("BigGame", 5000, 1024);
        assertThrows(RuntimeException.class, () -> gamingPC.installGame(game));
    }

    @Test
    void hasEnoughSpace_spaceAboveOnePercent_trueReturned()
    {
        assertTrue(gamingPC.hasEnoughSpace());
    }

    @Test
    void hasEnoughSpace_spaceBelowOnePercent_falseReturned()
    {
        Game game = new Game("FillGame", 4056, 1024);
        gamingPC.installGame(game);
        assertFalse(gamingPC.hasEnoughSpace());
    }
}
