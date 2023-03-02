package net.hinaricafe.repository;

import net.hinaricafe.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EventsRepository extends MongoRepository<Event, String> {

    @Query("{}")
    List<Event> findAll();

}
