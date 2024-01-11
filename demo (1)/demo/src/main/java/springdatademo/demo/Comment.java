package springdatademo.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    private int heart;

    @ManyToOne(fetch = FetchType.EAGER) //EAGER가 기본 / LAZY로 변경 가능 (post정보를  뒤늦게 가져옴)
    private Post post;


}

