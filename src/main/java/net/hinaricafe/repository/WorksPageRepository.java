package net.hinaricafe.repository;

import net.hinaricafe.model.WorksPage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface WorksPageRepository extends MongoRepository<WorksPage, String> {

    @Query("{}")
    WorksPage findOne();

}
