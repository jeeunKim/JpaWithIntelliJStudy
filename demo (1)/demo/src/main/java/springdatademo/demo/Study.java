package springdatademo.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Study {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Account owner;
}
