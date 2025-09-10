package practice.classic_crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.classic_crud.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
