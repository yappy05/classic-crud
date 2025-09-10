package practice.classic_crud.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import practice.classic_crud.model.Tag;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String name);
}
