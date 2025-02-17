import java.util.List;

public class Photo {
    private int length;
    private int width;
    private String description;
    private List<String> people;
    private double dpi;

    public Photo(int length, int width, String description, List<String> people, double dpi) {
        this.length = length;
        this.width = width;
        this.description = description;
        this.people = people;
        this.dpi = dpi;
    }

    public boolean canBePrinted() {
        return dpi >= 150.0 && length >= 585 && width >= 878;
    }

    public boolean isGroupPhoto() {
        return people != null && people.size() > 2;
    }
}
