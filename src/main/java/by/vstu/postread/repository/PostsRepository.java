package by.vstu.postread.repository;

import by.vstu.postread.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    Posts findByUrl(String url);
    List<Posts> findAllByUserUsername(String username);
}