package com.purplesoft.pojo;

public class SjzbTree {

	private int id;
	private int pid;
	private String name;
	private String uri;
	private String target;
	private String isParent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	public SjzbTree(int id, int pid, String name, String uri, String target, String isParent) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.uri = uri;
		this.target = target;
		this.isParent = isParent;
	}
	public SjzbTree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
