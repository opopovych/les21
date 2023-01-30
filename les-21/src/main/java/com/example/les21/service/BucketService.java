package com.example.les21.service;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.les21.daoRepo.BucketRepo;
import com.example.les21.domain.Bucket;



@Service
public class BucketService {
	
	Logger logger = LoggerFactory.getLogger(BucketService.class);
	
	@Autowired
	private BucketRepo bucketRepo;
	
	public Iterable<Bucket> getAll(){
		logger.info("Get all buckets");
		return bucketRepo.findAll();
	}
	
	public Bucket add(Bucket bucket) {
		logger.info("Create new bucket - "+bucket);
		return bucketRepo.save(bucket);
	}
	
	public void delete(Bucket bucket) {
		logger.info("Was deleted bucket - " + bucket);
		bucketRepo.delete(bucket);
	}
}
