package com.CalandarProject.v1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayDataController {

	// Create
	@PostMapping("/dayData")
	public DayData createDayData(@RequestBody DayData newDayData) {
		DayDatabase.addDayData(newDayData);
		return newDayData;
	}
	
	// retrieve
	@GetMapping("/dayData")
	public Object retrieveDayData(@RequestParam(value = "dayNum", required = false) String dayNum) {
		if(dayNum != null) {
		 	return DayDatabase.getDayData(dayNum);	
		}
		return DayDatabase.getAllDayData();
	}
	
	@GetMapping("/userDayData")
	public List<DayData> retrieveUserDayData(@RequestParam(value = "userID", required = true) String userId) {
		return DayDatabase.getDayDataByUser(userId);
	}
	
	// update
	@PutMapping("/dayData")
	public DayData updateDayData( @RequestParam(value = "dayNum", required = true ) String dayNum,
									@RequestBody DayData dayData) {
		return DayDatabase.updateDayData(dayNum, dayData);
	}
	
}
