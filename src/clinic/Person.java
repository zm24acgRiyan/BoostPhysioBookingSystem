package clinic;

public abstract class Person {
    protected String id;
    protected String name;
    protected String address;
    protected String phone;

    public Person(String id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
}