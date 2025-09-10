package practice.classic_crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.classic_crud.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthorId(Long id);
    Optional<Post> findById(Long id);
}
