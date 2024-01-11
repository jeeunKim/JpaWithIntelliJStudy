package springdatademo.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    void crud() {

    }

    @Test
    void crudTest() {
        Post post = new Post();
        post.setTitle("customTest2");
        post.setContent("asd");

        Post newPost = postRepository.save(post);

        List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

    }

    @PersistenceContext
    private EntityManager em;

    @Test
    void save() {
        Post post = new Post();
        post.setId(2L);
        post.setTitle("customTest2");
        post.setContent("asd"); //insert쿼리 발생 persist
        Post savedPost = postRepository.save(post);

        assertThat(em.contains(post)).isTrue();
        assertThat(em.contains(savedPost)).isTrue();
        assertThat(savedPost == post);

        Post postUpdate = new Post();
        postUpdate.setId(post.getId());
        postUpdate.setTitle("customTest3");
        postUpdate.setContent("asd"); //update 쿼리 발생 merge
        Post updatedPost = postRepository.save(postUpdate);

        assertThat(em.contains(updatedPost)).isTrue();
        assertThat(em.contains(postUpdate)).isFalse();
        assertThat(updatedPost == postUpdate);

        List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

    }

    @Test
    void findByTitleStartsWith() {
        savePost();

        List<Post> all = postRepository.findByTitleStartsWith("Spring");
        assertThat(all.size()).isEqualTo(1);

    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("Spring");
        return postRepository.save(post);
    }

    @Test
    void findByTitle() {
        savePost();

        List<Post> all = postRepository.findByTitle("Spring");
        assertThat(all.size()).isEqualTo(1);

    }

    @Test
    void findByTitle2() {
        savePost();

        List<Post> all = postRepository.findByTitle2("Spring");
        assertThat(all.size()).isEqualTo(1);

    }

    @Test
    void findByTitle3() {
        savePost();

        List<Post> all = postRepository.findByTitle3("Spring");
        assertThat(all.size()).isEqualTo(1);

    }
    @Test
    void findByTitle4() {
        savePost();

        List<Post> all = postRepository.findByTitle4("Spring", Sort.by("title"));
        assertThat(all.size()).isEqualTo(1);

    }

    @Test
    void findByTitle4_1() {
        savePost();

        List<Post> all = postRepository.findByTitle4("Spring", JpaSort.unsafe("LENGTH(title)"));
        assertThat(all.size()).isEqualTo(1);

    }
    @Test
    void findByTitle5() {
        savePost();

        List<Post> all = postRepository.findByTitle5("Spring", JpaSort.unsafe("LENGTH(title)"));
        assertThat(all.size()).isEqualTo(1);

    }

    @Test
    void updateTitle(){
        Post spring = savePost();

        int update = postRepository.updateTitle("hibernate", spring.getId());

        Optional<Post> posts = postRepository.findById(spring.getId());
        Post post = posts.get();
        assertThat(post.getTitle()).isEqualTo("hibernate");
    }
}