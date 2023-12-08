package by.maria.task7.entity;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Embeddable
public class MotorInfo {
    private String producer;
    @Enumerated(EnumType.STRING)
    private MotorType type;
    private Double volume;
    private int horsePower;

    public MotorInfo() {
    }

    public MotorInfo(String producer, MotorType type, Double volume, int horsePower) {
        this.producer = producer;
        this.type = type;
        this.volume = volume;
        this.horsePower = horsePower;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public MotorType getType() {
        return type;
    }

    public void setType(MotorType type) {
        this.type = type;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MotorInfo motorInfo = (MotorInfo) o;

        if (horsePower != motorInfo.horsePower) return false;
        if (!Objects.equals(producer, motorInfo.producer)) return false;
        if (type != motorInfo.type) return false;
        return Objects.equals(volume, motorInfo.volume);
    }

    @Override
    public int hashCode() {
        int result = producer != null ? producer.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + horsePower;
        return result;
    }

    @Override
    public String toString() {
        return "MotorInfo{" +
                "producer='" + producer + '\'' +
                ", type=" + type +
                ", volume=" + volume +
                ", horsePower=" + horsePower +
                '}';
    }
}
