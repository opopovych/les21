package com.example.les21.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.les21.daoRepo.BucketRepo;
import com.example.les21.domain.Bucket;

@Service
public class BucketService {
	@Autowired
	private BucketRepo bucketRepo;
	
	public Iterable<Bucket> getAll(){
		return bucketRepo.findAll();
	}
	
	public Bucket add(Bucket bucket) {
		return bucketRepo.save(bucket);
	}
	
	public void delete(Bucket bucket) {
		bucketRepo.delete(bucket);
	}
}
