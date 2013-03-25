package com.solancer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.solancer.model.Artist;
import com.solancer.util.DbUtil;

public class ArtistDao {
	
	private Connection connection;
	
	public ArtistDao() {
		connection = DbUtil.getConnection();
	}
	
	public void addArtist(Artist artist) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into artists(name) values(?)");
			preparedStatement.setString(1, artist.getArtistName());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteArtist(int artistId) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("delete from artists where id=?");
			preparedStatement.setInt(1, artistId);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateArtist(Artist artist) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("update artists set name=? " +
							"where id=?");
			preparedStatement.setString(1, artist.getArtistName());
			preparedStatement.setInt(2, artist.getArtistid());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Artist> getAllArtists() {
		List<Artist> artists = new ArrayList<Artist>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from artists");
			while (rs.next()) {
				Artist artist = new Artist();
				artist.setArtistid (rs.getInt("id"));
				artist.setAritistName(rs.getString("name"));
				artists.add(artist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artists;
	}
	
	public Artist getArtistById(int artistId) {
		Artist artist = new Artist();
		try {
			PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from artists where id=?");
			preparedStatement.setInt(1, artistId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				artist.setArtistid(rs.getInt("id"));
				artist.setAritistName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artist;
		
	}
	
}
