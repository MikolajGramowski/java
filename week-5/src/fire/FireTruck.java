package fire;

import java.util.ArrayList;
import java.util.List;

public class FireTruck {
    private String id;
    private int maxWaterCapacity;
    private int currentWaterLevel;
    private int capacity;
    private List<Firefighter> assignedFirefighters;

    public FireTruck(String id, int maxWaterCapacity, int currentWaterLevel, int capacity) {
        this.id = id;
        this.maxWaterCapacity = maxWaterCapacity;
        this.currentWaterLevel = currentWaterLevel;
        this.capacity = capacity;
        this.assignedFirefighters = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getMaxWaterCapacity() {
        return maxWaterCapacity;
    }

    public int getCurrentWaterLevel() {
        return currentWaterLevel;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Firefighter> getAssignedFirefighters() {
        return assignedFirefighters;
    }

    public boolean hasEnoughWater(int requiredWater) {
        return currentWaterLevel >= requiredWater;
    }

    public void useWater(int amount) {
        if (amount <= currentWaterLevel) {
            currentWaterLevel -= amount;
        } else {
            currentWaterLevel = 0;
        }
    }

    public void refill() {
        currentWaterLevel = maxWaterCapacity;
    }

    public void assignFirefighters(List<Firefighter> firefighters) {
        assignedFirefighters.addAll(firefighters);
    }

    public void clearAssignments() {
        assignedFirefighters.clear();
    }

    @Override
    public String toString() {
        return "FireTruck " + id + " (Water: " + currentWaterLevel + "/" + maxWaterCapacity + ", Capacity: " + capacity
                + ")";
    }
}
