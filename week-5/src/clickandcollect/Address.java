package clickandcollect;

public class Address {
    private String address;
    private String zipCode;
    private String city;

    public Address(String address, String zipCode, String city) {
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address other = (Address) o;
        return address.equals(other.address) &&
                zipCode.equals(other.zipCode) &&
                city.equals(other.city);
    }

    @Override
    public int hashCode() {
        return address.hashCode() + zipCode.hashCode() + city.hashCode();
    }

    @Override
    public String toString() {
        return address + ", " + zipCode + " " + city;
    }
}
