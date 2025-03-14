package fire;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FireDepartment department = new FireDepartment();

        department.addFirefighter(new Firefighter("Alice", LocalDate.of(2000, 1, 15)));
        department.addFirefighter(new Firefighter("Bob", LocalDate.of(2015, 6, 1)));
        department.addFirefighter(new Firefighter("Charlie", LocalDate.of(1995, 3, 20)));
        department.addFirefighter(new Firefighter("Diana", LocalDate.of(2010, 11, 10)));
        department.addFirefighter(new Firefighter("Edward", LocalDate.of(2005, 7, 25)));
        department.addFirefighter(new Firefighter("Fiona", LocalDate.of(2012, 9, 30)));
        department.addFirefighter(new Firefighter("George", LocalDate.of(1998, 5, 5)));

        department.addFireTruck(new FireTruck("FT1", 1000, 800, 5));
        department.addFireTruck(new FireTruck("FT2", 1200, 1200, 4));

        Emergency emergency1 = new Emergency("Warehouse Fire", 1, 300);
        Emergency emergency2 = new Emergency("House Fire", 3, 200);

        department.reportEmergency(emergency1);
        department.reportEmergency(emergency2);

        department.completeEmergency(emergency1);

        Emergency emergency3 = new Emergency("Forest Fire", 1, 500);
        department.reportEmergency(emergency3);
    }
}
