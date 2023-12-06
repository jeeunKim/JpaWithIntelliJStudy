package springdatademo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    void crud(){
        postRepository.findMyPost();
    }

    @Test
    void customeDeleteTest(){
        Post post = new Post();
        post.setTitle("customTest2");

        postRepository.save(post);

        postRepository.findMyPost().forEach(System.out::println);
        postRepository.delete(post);
        postRepository.flush();
    }
}