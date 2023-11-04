package task7;

public class Receiver {
    private  int id;
    private String name;

    public Receiver(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Receiver() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
