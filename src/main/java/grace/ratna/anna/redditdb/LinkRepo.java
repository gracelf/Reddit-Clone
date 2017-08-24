package grace.ratna.anna.redditdb;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface LinkRepo extends CrudRepository<Link, Long> {

    Iterable<Link> findAllByUserName(String partialString);

    Iterable<Link> findAllByOrderByDateDesc();

    Iterable<Link> findAllByUserNameOrderByDateDesc(String partialString);

}



