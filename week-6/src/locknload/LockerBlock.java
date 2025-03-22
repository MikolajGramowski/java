package locknload;

import java.util.HashSet;

public class LockerBlock
{
    private HashSet<Locker> lockers;

    public LockerBlock(HashSet<Locker> lockers)
    {
        this.lockers = lockers;
    }

    public HashSet<Locker> getLockers()
    {
        return lockers;
    }

    public void setLockers(HashSet<Locker> lockers)
    {
        this.lockers = lockers;
    }

    public HashSet<Locker> getAllAvailableLockers() {
        HashSet<Locker> availableLockers = new HashSet<>();
        for (Locker locker : this.lockers) {
            if (locker.getLaptop() == null) {
                availableLockers.add(locker);
            }
        }
        return availableLockers;
    }


    public Locker getAvailableLocker() {
        for (Locker locker : this.lockers) {
            if (locker.getLaptop() == null) {
                return locker;
            }
        }

        Locker lockerFilter = null;
        for (Locker locker : this.lockers) {
            if (locker.getLaptop() != null) {
                if (lockerFilter == null) {
                    lockerFilter = locker;
                } else {
                    double currentBatteryPercentage = locker.getLaptop().calculateCurrentBatteryPercentage();
                    double existingBatteryPercentage = lockerFilter.getLaptop().calculateCurrentBatteryPercentage();
                    if (currentBatteryPercentage > existingBatteryPercentage) {
                        lockerFilter = locker;
                    } else if (currentBatteryPercentage == existingBatteryPercentage) {
                        if (locker.getLaptop().getCurrentCharge() > lockerFilter.getLaptop().getCurrentCharge()) {
                            lockerFilter = locker;
                        }
                    }
                }
            }
        }
        return lockerFilter;
    }

    public double calculateTotalChargingTime() {
        final int chargerCapacity = 522;
        int totalRemainingMAh = 0;

        for (Locker locker : this.lockers) {
            if (locker.getLaptop() != null) {
                int remainingMAh = locker.getLaptop().getBatteryCapacity() - locker.getLaptop().getCurrentCharge();
                totalRemainingMAh += remainingMAh;
            }
        }

        return (double) totalRemainingMAh / chargerCapacity;
    }



}
