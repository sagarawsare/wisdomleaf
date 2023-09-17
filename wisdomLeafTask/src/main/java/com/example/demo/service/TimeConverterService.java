package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class TimeConverterService {
	public String convertTimeToWords(String time) {
		String[] parts = time.split(":");
		int hours = Integer.parseInt(parts[0]);
		System.out.println("hours : "+ hours);
		int minutes = Integer.parseInt(parts[1]);

		String hoursInWords = convertNumberToWords(hours);
		String minutesInWords = convertNumberToWords(minutes);

		return hoursInWords + " " + minutesInWords;
	}

	private String convertNumberToWords(int number) {
		String[] numberWords = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		String[] tenWords = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

		if (number < 20) {
			return numberWords[number];
		} else {
			return tenWords[number / 10] + " " + numberWords[number % 10];
		}
	}
}
