package springdatademo.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String username;

    @Column
    private String password;


    @OneToMany
    private Set<Study> studies = new HashSet<>();
}
