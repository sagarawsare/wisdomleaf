package com.example.demo.controller;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TimeConverterService;

import io.swagger.annotations.Api;
@RequestMapping("/api")
@Api(value = "Time Conversion API", description = "Operations for time conversion")
@RestController
public class TimeConverterController {
	
	@Autowired
	private TimeConverterService timeConverterService;

	@GetMapping("/convert")
	public ResponseEntity<String> convertTimeToWords(@RequestParam("time") String time) {
		try {
			String words = timeConverterService.convertTimeToWords(time);
			return ResponseEntity.ok("It's " + words);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid time input");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
		}
	}

	@GetMapping("/currunttime")
	public ResponseEntity<String> convertTimeToWords() {
		try {
			LocalTime time = LocalTime.now();
			String timm = time.getHour() + ":" + time.getMinute();
			System.out.println("Currnt time :" + timm);
			String words = timeConverterService.convertTimeToWords(timm);
			return ResponseEntity.ok("It's " + words);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid time input");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
		}
	}

	@GetMapping("/time")
	public ResponseEntity<String> handleTimeInput(@RequestParam("time") String time) {
		try {
			if (time.equals("12:00")) {
				return ResponseEntity.ok("It's Midday");
			} else if (time.equals("00:00")) {
				return ResponseEntity.ok("It's Midnight");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid time input");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
		}
	}

	@GetMapping("/midday")
	public ResponseEntity<String> getMidday() {
		return ResponseEntity.ok("It's Midday");
	}

	@GetMapping("/midnight")
	public ResponseEntity<String> getMidnight() {
		return ResponseEntity.ok("It's Midnight");
	}
}
