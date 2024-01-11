package springdatademo.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@NamedQuery(name = "Post.findByTitle", query = "select p from Post as p where p.title = ?1") //jpql
public class Post {
    @Id @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;




}
