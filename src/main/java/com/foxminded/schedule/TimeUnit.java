package main.java.com.foxminded.schedule;

import main.java.com.foxminded.dao.Identified;

public class TimeUnit implements Identified<Integer>{
	
	private Integer id;
	private Integer day;
	private Integer time;
	private Integer month;
			
	public TimeUnit() {
	}

	public TimeUnit(Integer day, Integer time, Integer month) {
		this.day = day;
		this.time = time;
		this.month = month;
	}
	
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}	
	
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "TimeUnit" + day + " [time=" + time + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
}
