package fire;

import java.util.List;

public class Emergency {
    private String description;
    private int priority;
    private int estimatedWaterNeeded;
    private boolean completed;
    private FireTruck assignedTruck;
    private List<Firefighter> assignedFirefighters;

    public Emergency(String description, int priority, int estimatedWaterNeeded) {
        this.description = description;
        this.priority = priority;
        this.estimatedWaterNeeded = estimatedWaterNeeded;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public int getEstimatedWaterNeeded() {
        return estimatedWaterNeeded;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        this.completed = true;
    }

    public void assignTruck(FireTruck truck) {
        this.assignedTruck = truck;
    }

    public FireTruck getAssignedTruck() {
        return assignedTruck;
    }

    public void assignFirefighters(List<Firefighter> firefighters) {
        this.assignedFirefighters = firefighters;
    }

    public List<Firefighter> getAssignedFirefighters() {
        return assignedFirefighters;
    }

    @Override
    public String toString() {
        String status = completed ? "Completed" : "Active";
        return "Emergency: " + description + " [Priority: " + priority +
                ", Estimated Water: " + estimatedWaterNeeded + ", Status: " + status + "]";
    }
}
