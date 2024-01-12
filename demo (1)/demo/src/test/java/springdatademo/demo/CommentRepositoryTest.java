package springdatademo.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@Transactional
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;
    @Test
    void findByCommentContainsTests(){

        createComment(100,"spring data jpa");

        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCase("SPRING DATA JPA");
        assertThat(comments.size()).isEqualTo(1);

    }

    @Test
    void findByCommentContainsIgnoreCaseOrderByHeartDesc(){
        createComment(80, "spring");
        createComment(30, "spring data");
        createComment(200, "spring jpa");

        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCaseOrderByHeartDesc("SPRING");
        assertThat(comments.size()).isEqualTo(3);
        assertThat(comments).first().hasFieldOrPropertyWithValue("heart", 200);

    }



    @Test
    void findByHeartGreaterThanTests(){

        createComment(80, "spring");
        createComment(30, "spring data");
        createComment(200, "spring jpa");
        PageRequest pageRequest = PageRequest.of(0,10, Sort.Direction.DESC, "heart");

        Page<Comment> commentsPage = commentRepository.findByHeartGreaterThan(50, pageRequest); // 페이지 크기를 조절하세요.
        assertThat(commentsPage.getNumberOfElements()).isEqualTo(2);

    }

    private void createComment(int heart, String c) {
        Comment comment = new Comment();
        comment.setComment(c);
        commentRepository.save(comment);
    }

    @Test
    void getComment(){
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setComment("comment");
        comment.setPost(savedPost);
        commentRepository.save(comment);


    }

    @Test
    void getCc(){
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setPost(savedPost);
        comment.setUp(10);
        comment.setDown(1);
        commentRepository.save(comment);

        commentRepository.findByPost_Id(savedPost.getId()).forEach(c ->{
                System.out.println("===========");
                System.out.println(c.getVotes());
        });
    }


}