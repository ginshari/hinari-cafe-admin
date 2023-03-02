package net.hinaricafe.repository;

import net.hinaricafe.model.Coffee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CoffeesRepository extends MongoRepository<Coffee, String> {

    @Query("{}")
    List<Coffee> findAll();

}
