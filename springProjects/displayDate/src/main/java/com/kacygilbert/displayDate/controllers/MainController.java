package com.kacygilbert.displayDate.controllers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {
	GregorianCalendar gcalendar = new GregorianCalendar();
	int hour = gcalendar.get(Calendar.HOUR);
	int minute = gcalendar.get(Calendar.MINUTE);
	int amPM = gcalendar.get(Calendar.AM_PM);
	String amPMStr = "";

	int weekDay = gcalendar.get(Calendar.DAY_OF_WEEK);
	String weekDayStr = "";
	int date = gcalendar.get(Calendar.DATE);
	int month = gcalendar.get(Calendar.MONTH);
	String monthStr = "";
	int year = gcalendar.get(Calendar.YEAR);

	
	@RequestMapping("/")
	public String index(Model model) {

		
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		// -- Get the Weekday
		switch(this.weekDay) {
		case 1:
			this.weekDayStr = "Sunday";
			break;
		case 2:
			this.weekDayStr = "Monday";
			break;
		case 3:
			this.weekDayStr = "Tuesday";
			break;
		case 4:
			this.weekDayStr = "Wednesday";
			break;
		case 5:
			this.weekDayStr = "Thursday";
			break;
		case 6:
			this.weekDayStr = "Friday";
			break;
		case 7:
			this.weekDayStr = "Saturday";
			break;
		}
		
		// -- Get the Month
		switch(this.month) {
		case 0:
			this.monthStr = "January";
			break;			
		case 1:
			this.monthStr = "Feburary";
			break;	
		case 2:
			this.monthStr = "March";
			break;	
		case 3:
			this.monthStr = "April";
			break;	
		case 4:
			this.monthStr = "May";
			break;	
		case 5:
			this.monthStr = "June";
			break;	
		case 6:
			this.monthStr = "July";
			break;	
		case 7:
			this.monthStr = "August";
			break;	
		case 8:
			this.monthStr = "September";
			break;	
		case 9:
			this.monthStr = "October";
			break;	
		case 10: 
			this.monthStr = "November";
			break;	
		case 11:
			this.monthStr = "December";
			break;		
		}
		
	
		model.addAttribute("day", weekDayStr);
		model.addAttribute("date", date);
		model.addAttribute("month", monthStr);
		model.addAttribute("year", year);
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		
		if(amPM == 0) {
			this.amPMStr = "AM";
		} else {
			this.amPMStr = "PM";
		}
		
		model.addAttribute("hour", hour);
		model.addAttribute("minute", minute);
		model.addAttribute("amPM", amPMStr);
		
		return "time.jsp";
	}
	//JSTL tags can do even heavier lifting
	@RequestMapping("/dojos")
	public String dojos(Model model) {
		ArrayList<String> dojos = new ArrayList<String>();
		dojos.add("Burbank");
		dojos.add("Chicagor");
		dojos.add("Bellevue");
		model.addAttribute("dojosFromMyController", dojos);
		return "dojos.jsp";
	}

}
