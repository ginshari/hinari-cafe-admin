package net.hinaricafe.repository;

import net.hinaricafe.model.Link;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LinksRepository extends MongoRepository<Link, String> {

    @Query("{}")
    List<Link> findAll();

}
