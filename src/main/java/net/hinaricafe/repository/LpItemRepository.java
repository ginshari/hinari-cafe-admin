package net.hinaricafe.repository;

import net.hinaricafe.model.LpItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LpItemRepository extends MongoRepository<LpItem, String> {

    @Query("{}")
    List<LpItem> findAll();

}
