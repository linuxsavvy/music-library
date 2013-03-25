package com.solancer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.solancer.dao.ArtistDao;
import com.solancer.model.Artist;

public class ArtistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/artist.jsp";
	private static String LIST_ARTIST = "/listArtist.jsp";
	private ArtistDao dao;
	
	public ArtistController() {
		super();
		dao = new ArtistDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String action = request.getParameter("action");
		
		if ("delete".equalsIgnoreCase(action)) {
			int artistId = Integer.parseInt(request.getParameter("artistId"));
			dao.deleteArtist(artistId);
			forward = LIST_ARTIST;
			request.setAttribute("artists", dao.getAllArtists());
		} else if ("edit".equalsIgnoreCase(action)) {
			forward = INSERT_OR_EDIT;
			int artistId = Integer.parseInt(request.getParameter("artistId"));
			Artist artist = dao.getArtistById(artistId);
			request.setAttribute("artist", artist);
		} else if ("listartist".equalsIgnoreCase(action)) {
			forward = LIST_ARTIST;
			request.setAttribute("artists", dao.getAllArtists());
		} else {
			forward = INSERT_OR_EDIT;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);	
	}
	
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Artist artist = new Artist();
		artist.setAritistName(request.getParameter("artistName"));
		String artistId = request.getParameter("artistId");
		if (artistId == null || artistId.isEmpty()) {
			dao.addArtist(artist);
		} 
		else {
			artist.setArtistid(Integer.parseInt(artistId));
			dao.updateArtist(artist);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_ARTIST);
		request.setAttribute("artists", dao.getAllArtists());
		view.forward(request, response);
	}
	
}
