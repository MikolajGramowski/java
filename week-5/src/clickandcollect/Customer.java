package clickandcollect;

public class Customer {
    private String name;
    private Address address;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer other = (Customer) o;
        return name.equals(other.name) &&
                address.equals(other.address);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + address.hashCode();
    }

    @Override
    public String toString() {
        return "Customer: " + name + ", " + address.toString();
    }
}
