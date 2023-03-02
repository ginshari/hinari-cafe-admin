package net.hinaricafe.repository;

import net.hinaricafe.model.CoffeesPage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CoffeesPageRepository extends MongoRepository<CoffeesPage, String> {

    @Query("{}")
    CoffeesPage findOne();

}
