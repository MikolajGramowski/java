package fire;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FireDepartment {
    private List<Firefighter> availableFirefighters;
    private List<FireTruck> availableTrucks;
    private List<Emergency> emergencies;

    public FireDepartment() {
        availableFirefighters = new ArrayList<>();
        availableTrucks = new ArrayList<>();
        emergencies = new ArrayList<>();
    }

    public void addFirefighter(Firefighter ff) {
        availableFirefighters.add(ff);
    }

    public void addFireTruck(FireTruck truck) {
        availableTrucks.add(truck);
    }

    public List<Firefighter> getAvailableFirefighters() {
        return availableFirefighters;
    }

    public List<FireTruck> getAvailableTrucks() {
        return availableTrucks;
    }

    public List<Emergency> getEmergencies() {
        return emergencies;
    }

    public void reportEmergency(Emergency emergency) {
        System.out.println("Reporting emergency: " + emergency.getDescription());
        FireTruck assignedTruck = null;
        for (FireTruck truck : availableTrucks) {
            if (truck.hasEnoughWater(emergency.getEstimatedWaterNeeded())) {
                assignedTruck = truck;
                break;
            }
        }
        if (assignedTruck == null) {
            System.out.println("No available fire truck with enough water!");
            return;
        }
        availableTrucks.remove(assignedTruck);
        emergency.assignTruck(assignedTruck);

        List<Firefighter> assignedFirefighters = new ArrayList<>();
        if (emergency.getPriority() == 1) {
            Iterator<Firefighter> it = availableFirefighters.iterator();
            while (it.hasNext() && assignedFirefighters.size() < 5) {
                Firefighter ff = it.next();
                if (ff.getYearsOfExperience() > 10) {
                    assignedFirefighters.add(ff);
                    it.remove();
                }
            }
            if (assignedFirefighters.size() < 5) {
                System.out.println("Not enough experienced firefighters for a priority 1 emergency!");
                availableTrucks.add(assignedTruck);
                return;
            }
        } else {
            int capacity = assignedTruck.getCapacity();
            Iterator<Firefighter> it = availableFirefighters.iterator();
            while (it.hasNext() && assignedFirefighters.size() < capacity) {
                Firefighter ff = it.next();
                assignedFirefighters.add(ff);
                it.remove();
            }
            if (assignedFirefighters.isEmpty()) {
                System.out.println("No available firefighters for the emergency!");
                availableTrucks.add(assignedTruck);
                return;
            }
        }

        assignedTruck.assignFirefighters(assignedFirefighters);
        emergency.assignFirefighters(assignedFirefighters);
        emergencies.add(emergency);
        assignedTruck.useWater(emergency.getEstimatedWaterNeeded());

        System.out.println("Assigned Truck: " + assignedTruck);
        System.out.println("Assigned Firefighters: " + assignedFirefighters);
    }

    public void completeEmergency(Emergency emergency) {
        if (emergency.isCompleted()) {
            System.out.println("Emergency already completed.");
            return;
        }
        emergency.complete();
        FireTruck truck = emergency.getAssignedTruck();
        List<Firefighter> assignedFF = emergency.getAssignedFirefighters();
        truck.clearAssignments();
        availableTrucks.add(truck);
        availableFirefighters.addAll(assignedFF);
        System.out.println("Emergency completed: " + emergency.getDescription());
    }
}
