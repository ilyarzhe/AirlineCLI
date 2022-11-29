public class Passenger {

    private String name;
    private int phoneNumber;
    private int id;

    public Passenger(String name, int phoneNumber, int id){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return String.format("Name: %s, Phone: %s, Id: %s",this.name,this.phoneNumber,this.id);
    }
}
