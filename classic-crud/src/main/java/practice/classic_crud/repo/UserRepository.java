package practice.classic_crud.repo;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.classic_crud.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
