package basic.clone;

public class Person implements Cloneable{
    private Address address;

    private String name;

    public int[] ints;

    public Person(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.address = (Address) address.clone();
        return p;
//        return super.clone();
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "address=" + address +
                ", name='" + name + '\'' +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
