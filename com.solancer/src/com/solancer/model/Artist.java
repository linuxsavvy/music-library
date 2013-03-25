package com.solancer.model;

public class Artist {
	
	private int artistid;
	private String artistName;
	public int getArtistid() {
		return artistid;
	}
	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}
	public String getArtistName(){
		return artistName;
	}
	public void setAritistName(String artistname){
		this.artistName = artistname;
	}
	@Override
	public String toString() {
		return "Artist [artistid=" + artistid + ", artistname=" + artistName +"]";
	}
}
