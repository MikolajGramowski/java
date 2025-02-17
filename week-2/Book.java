public class Book {
    private String name;
    private String author;
    private boolean isHardcover;
    private double price;
    private int pages;
    private int readCount;

    // test
    public Book(String name, String author, boolean isHardcover, double price, int pages) {
        this.name = name;
        this.author = author;
        this.isHardcover = isHardcover;
        this.price = price;
        this.pages = pages;
        this.readCount = 0;
    }

    public void incrementReadCount() {
        readCount++;
    }

    public double getReadingTime() {
        return pages / 0.8;
    }

    public String getReadTimeMessage() {
        double readingTime = getReadingTime();
        if (readingTime < 61) {
            return "You can read this";
        } else if (readingTime <= 240) {
            return "Are you sure you want to read this now?";
        } else {
            return "You should not start reading this right now";
        }
    }
}
