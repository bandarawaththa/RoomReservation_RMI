package tm;

public class CustomerTM {
    private String nic;
    private String name;
    private int contact;

    public CustomerTM() {}

    public CustomerTM(String nic, String name, int contact) {
        this.nic = nic;
        this.name = name;
        this.contact = contact;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}