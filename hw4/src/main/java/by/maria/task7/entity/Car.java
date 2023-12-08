package by.maria.task7.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    @Column(name = "year")
    private int manufacturedYear;
    @Enumerated(EnumType.STRING)
    private Color color;
    @Embedded
    private MotorInfo motorInfo;

    public Car( String model, int manufacturedYear, Color color, MotorInfo motorInfo) {

        this.model = model;
        this.manufacturedYear = manufacturedYear;
        this.color = color;
        this.motorInfo = motorInfo;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(int manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MotorInfo getMotorInfo() {
        return motorInfo;
    }

    public void setMotorInfo(MotorInfo motorInfo) {
        this.motorInfo = motorInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (manufacturedYear != car.manufacturedYear) return false;
        if (!Objects.equals(model, car.model)) return false;
        if (color != car.color) return false;
        return Objects.equals(motorInfo, car.motorInfo);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + manufacturedYear;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (motorInfo != null ? motorInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturedYear=" + manufacturedYear +
                ", color=" + color +
                ", motorInfo=" + motorInfo +
                '}';
    }
}
