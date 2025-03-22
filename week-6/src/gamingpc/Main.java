package gamingpc;

public class Main
{
    public static void main(String[] args)
    {
        Motherboard motherboard = new Motherboard(10);

        try
        {
            motherboard.addGraphicCard(new GraphicCard(1.5, 2048));
        } catch (RuntimeException e)
        {
            System.out.println("Failed to add graphic card: " + e.getMessage());
        }

        try
        {
            motherboard.addSSD(new SSD(4096));
        } catch (RuntimeException e)
        {
            System.out.println("Failed to add SSD: " + e.getMessage());
        }

        try
        {
            motherboard.addSoundCard(new SoundCard(2));
        } catch (RuntimeException e)
        {
            System.out.println("Failed to add sound card: " + e.getMessage());
        }

        GamingPC gamingPC = new GamingPC(motherboard);

        System.out.println("Initial free space on SSD: " + motherboard.getSsds().get(0).getFreeSpace() + " MB");

        Game game = new Game("Awesome Game", 500, 1024);
        try
        {
            gamingPC.installGame(game);
            System.out.println("Game '" + game.getTitle() + "' installed successfully.");
        } catch (RuntimeException e)
        {
            System.out.println("Failed to install game: " + e.getMessage());
        }

        System.out.println(
                "Free space on SSD after installation: " + motherboard.getSsds().get(0).getFreeSpace() + " MB");

        boolean enoughSpace = gamingPC.hasEnoughSpace();
        System.out.println("Is there enough space left? " + enoughSpace);
    }
}
