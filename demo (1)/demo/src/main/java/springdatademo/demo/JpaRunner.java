package springdatademo.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Component
@AllArgsConstructor
public class JpaRunner implements ApplicationRunner {

    private final PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Post post3 = new Post();
        post3.setTitle("hi");

        Comment comment = new Comment();
        comment.setComment("nice 2 meet you");

        postRepository.save(post3);

        postRepository.findAll().forEach(p ->
                log.info("post = {}", p)
        );



    }

    private static void addStudy(Study study, Account account) {
        study.setOwner(account);
        account.getStudies().add(study);
    }
}
