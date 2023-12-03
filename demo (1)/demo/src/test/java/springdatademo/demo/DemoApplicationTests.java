package springdatademo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.assertj.core.api.Assertions.*;
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	PostRepository postRepository;
	@Test
	void optionalTest() {
		Optional<Post> postById = postRepository.findById((long)321);

		assertThat(postById.isEmpty());
	}

}
