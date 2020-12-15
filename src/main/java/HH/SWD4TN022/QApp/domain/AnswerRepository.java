package HH.SWD4TN022.QApp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> , JpaRepository<Answer, Long> {

}

