package com.purplesoft.pojo;

public class MainMenu {

	private String id;
	private String name;
	private String target;
	private String url;
	/*private int pid;
	private int zid;
	private String pname;
	private String zname;*/
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public MainMenu(String id, String name, String target, String url) {
		super();
		this.id = id;
		this.name = name;
		this.target = target;
		this.url = url;
	}
	public MainMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
}