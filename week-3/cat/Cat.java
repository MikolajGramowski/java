package cat;

class Cat {
    private String name;
    private double happiness;

    public Cat(String name) {
        this.name = name;
        this.happiness = 0.0;
    }

    public void pet() {
        if (happiness < 5.0) {
            happiness = Math.min(happiness + 0.3, 5.0);
        }
    }

    public boolean isHappy() {
        return happiness > 3.5;
    }

    public String getName() {
        return name;
    }
}
