package springdatademo.demo;


import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository extends MyRepository<Post, Long>, QuerydslPredicateExecutor<Post> {

}
//
//public interface PostRepository extends MyRepository<Post, Long> {
//}
