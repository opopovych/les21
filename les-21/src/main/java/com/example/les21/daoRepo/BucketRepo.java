package com.example.les21.daoRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.les21.domain.Bucket;

@Repository
public interface BucketRepo extends CrudRepository<Bucket, Long> {

}
