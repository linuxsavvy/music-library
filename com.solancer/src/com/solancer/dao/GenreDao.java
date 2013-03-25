package com.solancer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.solancer.model.Genre;
import com.solancer.util.DbUtil;

public class GenreDao {
	
	private Connection connection;
	
	public GenreDao() {
		connection = DbUtil.getConnection();
	}
	
	public void addGenre(Genre genre) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into genres(name) values(?)");
			preparedStatement.setString(1, genre.getGenreName());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteGenre(int genreId) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("delete from genres where id=?");
			preparedStatement.setInt(1, genreId);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateGenre(Genre genre) {
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("update genres set name=? " +
							"where id=?");
			preparedStatement.setString(1, genre.getGenreName());
			preparedStatement.setInt(2, genre.getGenreid());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Genre> getAllGenres() {
		List<Genre> genres = new ArrayList<Genre>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from genres");
			while (rs.next()) {
				Genre genre = new Genre();
				genre.setGenreid (rs.getInt("id"));
				genre.setGenreName(rs.getString("name"));
				genres.add(genre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return genres;
	}
	
	public Genre getGenreById(int GenreId) {
		Genre genre = new Genre();
		try {
			PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from genres where id=?");
			preparedStatement.setInt(1, GenreId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				genre.setGenreid(rs.getInt("id"));
				genre.setGenreName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return genre;
		
	}
}
