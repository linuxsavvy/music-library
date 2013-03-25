package com.solancer.model;

import java.util.Date;

public class Album {
	private int albumid;
	private int alArtistid;
	private int alGenreid;
	private String albumName;
	private Date albumRelease;
	private String albumInfo;
	private String albumImage;
	
	public int getAlbumId(){
		return albumid;
	}
	public void setAlbumId(int albumid) {
		this.albumid = albumid;
	}
	public int getAlArtistId() {
		return alArtistid;
	}
	public void setAlArtistId(int alArtistid) {
		this.alArtistid = alArtistid;
	}
	public int getAlGenreId() {
		return alGenreid;
	}
	public void setAlGenreId(int alGenreid) {
		this.alGenreid = alGenreid;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public Date getAlbumRelease() {
		return albumRelease;
	}
	public void setAlbumRelease(Date albumRelease) {
		this.albumRelease = albumRelease;
	}
	public String getAlbumInfo() {
		return albumInfo;
	}
	public void setAlbuminfo(String albumInfo) {
		this.albumInfo = albumInfo;
	}
	public String getAlbumImage() {
		return albumImage;
	}
	public void setAlbumImage(String albumImage) {
		this.albumImage = albumImage;
	}
	@Override
	public String toString() {
		return "Album [albumid=" + albumid + ", alArtistid=" + alArtistid + ", alGenreid=" + alGenreid
				+ ",albumName=" + albumName + ",albumRelease=" + albumRelease + ", albumInfo=" + albumInfo 
				+ ",albumImage=" +albumImage+"]"; 
	}
}
