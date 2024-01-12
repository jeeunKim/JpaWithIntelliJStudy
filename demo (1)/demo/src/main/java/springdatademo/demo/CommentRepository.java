package springdatademo.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    //Spring Data JPA가 메소드명을 분석해서 쿼리를 만들어줌.

    //메소드명으로 만들기 힘든 경우
    //@Query("SELECT c FROM Comment AS C") 로 직접 JPQL문 작성
    //@Query("SELECT * FROM comment AS C", nativeQuery = true) 로 직접 SQL문 작성

    //디폴트는 CREATE_IF_NOT_FOUND 쿼리를 보고 만들고, 없으면 메소드명으로 쿼리 생성
    //main에 @EnableJpaRepositories(queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND) 어노테이션(디폴트)
    List<Comment> findByCommentContainsIgnoreCase(String keyword);
    List<Comment> findByCommentContainsIgnoreCaseOrderByHeartDesc(String keyword);

    Page<Comment> findByHeartGreaterThan(int likeCount, Pageable pageable );

    List<Comment> findByHeartLessThan(int likeCount, Sort sort  );

//    @EntityGraph(value = "Comment.post")
//    Optional<Comment> loadById(Long id);

    List<CommentSummary> findByPost_Id(Long id); //인터페이스 기반의 Projection의 closed 방식
}
