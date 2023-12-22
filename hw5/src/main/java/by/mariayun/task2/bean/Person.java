package by.mariayun.task2.bean;



public class Person {
    private Integer age;
    private String name;
    private String surname;
    private IAddress address;

    private Person() {
    }

    public static Person getInstance() {
        System.out.println("Factory method working");
        return new Person();
    }

    public void personInit() {
        System.out.println("Initialization of Person");
    }

    public void personDestroy() {
        System.out.println("Destroy of person");
    }

//    public Integer getAge() {
//        return age;
//    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public IAddress getAddress() {
        return address;
    }

    public void setAddress(IAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                '}';
    }
}
