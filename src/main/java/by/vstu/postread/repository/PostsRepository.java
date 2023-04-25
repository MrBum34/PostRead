package by.vstu.postread.repository;

import by.vstu.postread.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    Posts findByUrl(String url);
}