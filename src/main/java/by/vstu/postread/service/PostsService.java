package by.vstu.postread.service;

import by.vstu.postread.entity.Posts;
import by.vstu.postread.repository.PostsRepository;
import by.vstu.postread.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private UserRepository userRepository;

    public String savePost(Posts posts, String username) {
        String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
        String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ALL_LETTERS = LOWER_CASE_LETTERS + UPPER_CASE_LETTERS;
        int length = 10;

        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALL_LETTERS.length());
            char c = ALL_LETTERS.charAt(index);
            sb.append(c);
        }
        posts.setUrl(sb.toString());
        posts.setUser(userRepository.findByUsername(username));
        posts = postsRepository.save(posts);
        return posts.getUrl();
    }

    public String getPost(String url) {
        Posts post = postsRepository.findByUrl(url);
        if (post == null) {
            return "Неверная ссылка";
        }
        return post.getText();
    }

    public List<Posts> getAllPosts(String username) {
        List<Posts> posts = postsRepository.findAllByUserUsername(username);
        return posts;
    }
}
