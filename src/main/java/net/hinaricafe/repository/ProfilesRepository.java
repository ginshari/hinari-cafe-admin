package net.hinaricafe.repository;

import net.hinaricafe.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProfilesRepository extends MongoRepository<Profile, String> {

    @Query("{}")
    List<Profile> findAll();

}
