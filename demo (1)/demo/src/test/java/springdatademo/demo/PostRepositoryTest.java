package springdatademo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@Transactional
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    void crud() {

    }

    @Test
    void customeDeleteTest() {
        Post post = new Post();
        post.setTitle("customTest2");
        post.setContent("asd");

        Post newPost = postRepository.save(post);

        //Optional<Post> find = postRepository.findOne(QPost.post.title.contains("custom"));
        assertThat(postRepository.contains(newPost));

    }
}