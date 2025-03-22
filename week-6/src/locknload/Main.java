package locknload;

import java.util.HashSet;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Lock & Load Laptop Locker System Demo");
        System.out.println("====================================\n");

        Laptop laptop1 = new Laptop("LP-001", 2500, 5000);
        Laptop laptop2 = new Laptop("LP-002", 4500, 5000);
        Laptop laptop3 = new Laptop("LP-003", 1200, 4000);
        Laptop laptop4 = new Laptop("LP-004", 3800, 4000);

        Locker locker1 = new Locker("L-101", laptop1);
        Locker locker2 = new Locker("L-102", laptop2);
        Locker locker3 = new Locker("L-103", laptop3);
        Locker locker4 = new Locker("L-104", null);
        Locker locker5 = new Locker("L-105", null);

        HashSet<Locker> lockers = new HashSet<>();
        lockers.add(locker1);
        lockers.add(locker2);
        lockers.add(locker3);
        lockers.add(locker4);
        lockers.add(locker5);

        LockerBlock lockerBlock = new LockerBlock(lockers);

        System.out.println("Current Locker Status:");
        for (Locker locker : lockers)
        {
            if (locker.getLaptop() != null)
            {
                Laptop laptop = locker.getLaptop();
                System.out.printf("Locker %s: Laptop %s (Battery: %.1f%%, Charge: %d/%d mAh)\n",
                        locker.getLockerNumber(),
                        laptop.getSerialNumber(),
                        laptop.calculateCurrentBatteryPercentage(),
                        laptop.getCurrentCharge(),
                        laptop.getBatteryCapacity());
            } else
            {
                System.out.printf("Locker %s: Empty\n", locker.getLockerNumber());
            }
        }

        HashSet<Locker> availableLockers = lockerBlock.getAllAvailableLockers();
        System.out.println("\nAvailable Lockers (" + availableLockers.size() + "):");
        for (Locker locker : availableLockers)
        {
            System.out.println("- " + locker.getLockerNumber());
        }

        Locker availableLocker = lockerBlock.getAvailableLocker();
        System.out.println("\nRecommended Available Locker: " + availableLocker.getLockerNumber());

        double chargingTime = lockerBlock.calculateTotalChargingTime();
        System.out.printf("\nTotal charging time required: %.2f hours\n", chargingTime);

        Laptop laptop5 = new Laptop("LP-005", 500, 5000);
        System.out.println("\nAdding new laptop " + laptop5.getSerialNumber() +
                " to locker " + availableLocker.getLockerNumber());
        availableLocker.setLaptop(laptop5);

        chargingTime = lockerBlock.calculateTotalChargingTime();
        System.out.printf("New total charging time required: %.2f hours\n", chargingTime);

        availableLockers = lockerBlock.getAllAvailableLockers();
        System.out.println("\nRemaining available lockers: " + availableLockers.size());

        if (availableLockers.size() > 0)
        {
            Locker lastLocker = availableLockers.iterator().next();
            lastLocker.setLaptop(new Laptop("LP-006", 3000, 6000));
            System.out.println("\nFilled last available locker.");

            Locker highestChargedLocker = lockerBlock.getAvailableLocker();
            System.out.println("When no empty lockers, getAvailableLocker() returns locker " +
                    highestChargedLocker.getLockerNumber() + " with highest charge.");

            Laptop highestLaptop = highestChargedLocker.getLaptop();
            System.out.printf("This laptop has %.1f%% battery (Charge: %d/%d mAh)\n",
                    highestLaptop.calculateCurrentBatteryPercentage(),
                    highestLaptop.getCurrentCharge(),
                    highestLaptop.getBatteryCapacity());
        }
    }
}
