package cat;

class Owner {
    private String name;
    private Cat cat;

    public Owner(String name, Cat cat) {
        this.name = name;
        this.cat = cat;
    }

    public void petCat() {
        if (cat != null) {
            cat.pet();
        } else {
            System.out.println(name + " has no cat to pet.");
        }
    }

    public boolean isCatHappy() {
        return cat != null && cat.isHappy();
    }

    public String callCat() {
        return (cat != null) ? "Come here, " + cat.getName() + "!" : "You don't have a cat!";
    }
}
