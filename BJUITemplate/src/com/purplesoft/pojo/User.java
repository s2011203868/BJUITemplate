package com.purplesoft.pojo;

public class User {

	private int id;
	private String username;
	private int age;
	private int sex;
	private String birthday;
	private int city;
	private double salary;
	private String starttime;
	private String endtime;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User(int id, String username, int age, int sex, String birthday, int city, double salary, String starttime,
			String endtime, String description) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.city = city;
		this.salary = salary;
		this.starttime = starttime;
		this.endtime = endtime;
		this.description = description;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
