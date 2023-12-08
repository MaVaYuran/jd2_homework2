package by.maria.task8.mapped.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
@MappedSuperclass
public class BaseClass <T extends Serializable>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;
}
