package com.example.firstdemo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String template = "Hello, your new purchase is on the way %s!";
	
	private final AtomicLong counter = new AtomicLong();
	
	private GreetingComponent gc;
	
	@Autowired
	public GreetingController(GreetingComponent gc) {
		this.gc = gc;
		
	}
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") 
	String name) {
	return new Greeting(counter.incrementAndGet(), String.format(template, 
	name));
	}
	
	// test the greeting component
	@GetMapping("/testgreeting")
	public ResponseEntity<String> getMessage() {
	return ResponseEntity.ok(gc.getMessage());
	}
	
	// add method to handle POST, PU AND DELETE 
	// test the greeting component
		@PostMapping("/testgreeting")
		public ResponseEntity<String> postMessage() {
		return ResponseEntity.ok(gc.postMessage());
		}
		
		// add method to handle POST, PU AND DELETE 
		// test the greeting component
			@PutMapping("/testgreeting")
			public ResponseEntity<String> putMessage() {
			return ResponseEntity.ok(gc.putMessage());
			}
			
			// add method to handle POST, PU AND DELETE 
			// test the greeting component
				@DeleteMapping("/testgreeting")
				public ResponseEntity<String> deleteMessage() {
				return ResponseEntity.ok(gc.deleteMessage());
				}
				
		
	

}
