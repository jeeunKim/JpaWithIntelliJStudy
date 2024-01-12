package springdatademo.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.*;

@NamedEntityGraph(name = "Comment.post", attributeNodes = @NamedAttributeNode("post"))
@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    private int heart;

    private int up;

    private int down;

    private boolean best;

    @CreatedDate
    private Date created;

    @CreatedBy
    @ManyToOne
    private Account createdBy;

    @LastModifiedDate
    private Date updated;

    @LastModifiedBy
    @ManyToOne
    private Account updatedBy;


    @ManyToOne(fetch = FetchType.EAGER) //EAGER가 기본 / LAZY로 변경 가능 (post정보를  뒤늦게 가져옴)
    private Post post;


}

