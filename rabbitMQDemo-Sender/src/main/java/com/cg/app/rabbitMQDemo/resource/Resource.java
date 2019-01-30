package com.cg.app.rabbitMQDemo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.rabbitMQDemo.sender.Sender;

@RestController
public class Resource {
	@Autowired
	private Sender sender;

	@GetMapping
	public String send() {
		sender.send("Hello-World");
		return "Hello-World!!!";

	}
}