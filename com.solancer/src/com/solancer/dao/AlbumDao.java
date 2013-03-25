package com.solancer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.solancer.model.Album;
import com.solancer.util.DbUtil;

public class AlbumDao {
	
	private Connection connection;
	
	public AlbumDao() {
		connection = DbUtil.getConnection();
	}
	
	public void addAlbum(Album album) {
		try {
			String sql = "insert into albums (" +
							"artist_id," +
							"genre_id," +
							"name," +
							"al_release," +
							"info," +
							"image)" +
							" values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, album.getAlArtistId());
			preparedStatement.setInt(2, album.getAlGenreId());
			preparedStatement.setString(3, album.getAlbumName());
			preparedStatement.setDate(4, new java.sql.Date(album.getAlbumRelease().getTime()));
			preparedStatement.setString(5, album.getAlbumInfo());
			preparedStatement.setString(6, album.getAlbumImage());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAlbum(int albumId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from albums where id=?");
			preparedStatement.setInt(1, albumId);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void updateAlbum(Album album) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update albums set artist_id=?,genre_id=?,name=?,al_release=?,info=?," +
							"image=? where id=?");
			preparedStatement.setInt(1, album.getAlArtistId());
			preparedStatement.setInt(2, album.getAlGenreId());
			preparedStatement.setString(3, album.getAlbumName());
			preparedStatement.setDate(4, new Date(album.getAlbumRelease().getTime()));
			preparedStatement.setString(5, album.getAlbumInfo());
			preparedStatement.setString(6, album.getAlbumImage());
			preparedStatement.setInt(7, album.getAlbumId());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Album> getAllAlbums() {
		List<Album> albums = new ArrayList<Album>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from albums");
			while (rs.next()) {
				Album album = new Album();
				album.setAlbumId(rs.getInt("id"));
				album.setAlArtistId(rs.getInt("artist_id"));
				album.setAlGenreId(rs.getInt("genre_id"));
				album.setAlbumName(rs.getString("name"));
				album.setAlbumRelease(rs.getDate("al_release"));
				album.setAlbuminfo(rs.getString("info"));
				album.setAlbumImage(rs.getString("image"));
				albums.add(album);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return albums;
	}
	
	public Album getAlbumById(int albumId) {
		Album album = new Album();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from albums where id=?");
			preparedStatement.setInt(1, albumId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				album.setAlbumId(rs.getInt("id"));
				album.setAlArtistId(rs.getInt("artist_id"));
				album.setAlGenreId(rs.getInt("genre_id"));
				album.setAlbumName(rs.getString("name"));
				album.setAlbumRelease(rs.getDate("al_release"));
				album.setAlbuminfo(rs.getString("info"));
				album.setAlbumImage(rs.getString("image"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return album;
	}
	
	
}
