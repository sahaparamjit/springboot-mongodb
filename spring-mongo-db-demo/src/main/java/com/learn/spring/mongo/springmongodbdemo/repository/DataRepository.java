package com.learn.spring.mongo.springmongodbdemo.repository;
import com.learn.spring.mongo.springmongodbdemo.model.Data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends MongoRepository<Data, String> {
    public Data findByUsername(String username);
    
    @Query(value="{'username' : $0}", delete = true)
    public Data deleteByUsername(String username);
}
