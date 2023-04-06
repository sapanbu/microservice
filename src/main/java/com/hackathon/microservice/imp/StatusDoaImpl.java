package com.hackathon.microservice.imp;
import java.util.Map;
import javax.annotation.Resource;

import com.hackathon.microservice.model.Status;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

@Repository
public class StatusDoaImpl implements iStatusDoa {

	private final String hashReference= "Status";

	@Resource(name="redisTemplate")
	private HashOperations<String, Integer, Status> hashOperations;

	@Override
	public void saveStaus(Status status) {
		//creates one record in Redis DB if record with that Id is not present
		hashOperations.putIfAbsent(hashReference, status.getStatusId(), status);
	}

	@Override
	public void saveAllStaus(Map<Integer, Status> map) {
		hashOperations.putAll(hashReference, map);
	}


	@Override
	public Map<Integer, Status> getAllStatus() {
		return hashOperations.entries(hashReference);
	}

}