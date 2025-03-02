package cat;

public class CatApp {
    public static void main(String[] args) {
        Cat myCat = new Cat("Whiskers");
        Owner owner = new Owner("Alice", myCat);

        System.out.println(owner.callCat());
        owner.petCat();
        owner.petCat();
        owner.petCat();
        owner.petCat();
        owner.petCat();
        owner.petCat();
        System.out.println("Is the cat happy? " + owner.isCatHappy());

        Owner ownerWithoutCat = new Owner("Bob", null);
        System.out.println(ownerWithoutCat.callCat());
        ownerWithoutCat.petCat();
    }
}