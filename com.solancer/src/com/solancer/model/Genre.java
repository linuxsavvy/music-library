package com.solancer.model;

public class Genre {
	private int genreid;
	private String genreName;
	public int getGenreid() {
		return genreid;
	}
	public void setGenreid(int genreid) { 
		this.genreid = genreid;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genrename) {
		this.genreName = genrename;
	}
	@Override
	public String toString(){
		return "Genre [genreid=" + genreid + ", genreName="+ genreName +"]";
	}
	
}
