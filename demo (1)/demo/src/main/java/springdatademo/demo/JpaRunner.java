package springdatademo.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Component
@AllArgsConstructor
public class JpaRunner implements ApplicationRunner {

    private final PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Post post3 = new Post();
//        post3.setTitle("hi");
//
//
//        postRepository.save(post3);
//
//        postRepository.findAll().forEach(p ->
//                log.info("post = {}", p)
//        );
//
//        Optional<Post> postById = postRepository.findById((long)321);
//
//        System.out.println(postById.isEmpty());
//        System.out.println(postById);
    }


}
