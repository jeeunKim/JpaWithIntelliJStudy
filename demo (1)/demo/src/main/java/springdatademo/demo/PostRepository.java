package springdatademo.demo;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {


    List<Post> findByTitleStartsWith(String title);

    List<Post> findByTitle(String title); //NamedQuery

    @Query("select p from Post as p where p.title = ?1")
    List<Post> findByTitle2(String title);


    @Query(value = "SELECT * FROM Post p WHERE p.title = :title", nativeQuery = true)
    List<Post> findByTitle3(String title);

    @Query(value = "SELECT p FROM Post p WHERE p.title = ?1")
    List<Post> findByTitle4(String title, Sort sort);


    @Query(value = "SELECT p FROM Post p WHERE p.title = :title")
    List<Post> findByTitle5(@Param("title") String keyword, Sort sort);


    @Modifying(clearAutomatically = true)
    @Query("UPDATE Post p set p.title =?1 where p.id = ?2")
    int updateTitle(String title, Long id);
}
