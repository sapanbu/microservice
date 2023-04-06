package com.hackathon.microservice.controller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hackathon.microservice.imp.iStatusDoa;
import com.hackathon.microservice.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DemoController {

	@Autowired
	private iStatusDoa statusDoa;

	@GetMapping(value = "/getStatus")
	public String getStatus() {
		Date date = new Date();
		//statusDoa.saveStaus(new Status(502,date,"locator","success"));
		//statusDoa.getAllStatus().forEach((k,v)-> System.out.println(k +" : "+v));
		List<Status> statusList=new ArrayList<Status>();
		statusList=statusDoa.getAllStatus().values().stream().collect(Collectors.toList());
		Gson gson = new Gson();
		String jsonList = gson.toJson(statusList);
		System.out.println("jsonList: " + jsonList);
		return jsonList;
	}

	@PostMapping(value = "/postStatus", consumes = "application/json")
	public void postStatus(@RequestBody String reqJson) {
      if(reqJson!=null){
		  System.out.println("reqJson: " + reqJson);
		  Status status=new Status();
		  Date date=new Date();
		  System.out.println("date : "+date.toString()) ;
		  String pattern = "MM-dd-yyyy";
		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		  String date1 = simpleDateFormat.format(new Date());
		  System.out.println(date1);
		  reqJson=reqJson.replaceAll("@dates@",date1);
		  Gson gson1 = new Gson();
		  Gson gson = new GsonBuilder().setDateFormat("MM-dd-yyyy").create();
		  status=gson.fromJson(reqJson,Status.class);
		  statusDoa.saveStaus(status);
		  System.out.println("Status Saved!") ;
	  }

	}

}
