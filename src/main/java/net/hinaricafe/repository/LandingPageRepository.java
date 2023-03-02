package net.hinaricafe.repository;

import net.hinaricafe.model.LandingPage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface LandingPageRepository extends MongoRepository<LandingPage, String> {

    @Query("{}")
    LandingPage findOne();

}
