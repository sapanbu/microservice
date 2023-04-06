package com.hackathon.microservice.imp;

import com.hackathon.microservice.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public interface  iStatusDoa{
	void saveStaus(Status status);

	void saveAllStaus(Map<Integer, Status> map);

	Map<Integer, Status> getAllStatus();
}