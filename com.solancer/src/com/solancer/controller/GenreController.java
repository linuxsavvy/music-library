package com.solancer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.solancer.dao.GenreDao;
import com.solancer.model.Genre;

public class GenreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/genre.jsp";
	private static String LIST_GENRE = "/listGenre.jsp";
	private GenreDao dao;
	
	public GenreController() {
		super();
		dao = new GenreDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String action = request.getParameter("action");
		
		if ("delete".equalsIgnoreCase(action)) {
			int genreId = Integer.parseInt(request.getParameter("genreId"));
			dao.deleteGenre(genreId);
			forward = LIST_GENRE;
			request.setAttribute("genres", dao.getAllGenres());
		} else if ("edit".equalsIgnoreCase(action)) {
			forward = INSERT_OR_EDIT;
			int genreId = Integer.parseInt(request.getParameter("genreId"));
			Genre genre = dao.getGenreById(genreId);
			request.setAttribute("genre", genre);
		} else if ("listgenre".equalsIgnoreCase(action)) {
			forward = LIST_GENRE;
			request.setAttribute("genres", dao.getAllGenres());
		} else {
			forward = INSERT_OR_EDIT;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);	
	}
	
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Genre genre = new Genre();
		genre.setGenreName(request.getParameter("genreName"));
		String genreId = request.getParameter("genreId");
		if (genreId == null || genreId.isEmpty()) {
			dao.addGenre(genre);
		} 
		else {
			genre.setGenreid(Integer.parseInt(genreId));
			dao.updateGenre(genre);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_GENRE);
		request.setAttribute("genres", dao.getAllGenres());
		view.forward(request, response);
	}
	
}
