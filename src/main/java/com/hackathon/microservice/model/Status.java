package com.hackathon.microservice.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status implements Serializable{

	private static final long serialVersionUID = -7817224776021728682L;

	private Integer statusId;
	private Date date;
	private String appName;
	private String buildStatus;
}