package santarelli.enrico.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import santarelli.enrico.domain.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
