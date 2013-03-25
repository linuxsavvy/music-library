package com.solancer.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.solancer.dao.AlbumDao;
import com.solancer.dao.ArtistDao;
import com.solancer.model.Album;


public class AlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Album.jsp";
    private static String LIST_ALBUM = "/listAlbums.jsp";
    private AlbumDao dao;
    
    public AlbumController() {
		super();
		dao = new AlbumDao();
	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    	String forward="";
		String action = request.getParameter("action");
		
		if ("delete".equalsIgnoreCase(action)) {
			int albumId = Integer.parseInt(request.getParameter("AlbumId"));
			dao.deleteAlbum(albumId);
			forward = LIST_ALBUM;
			request.setAttribute("albums", dao.getAllAlbums());
		} else if ("edit".equalsIgnoreCase(action)) {
			forward = INSERT_OR_EDIT;
			int albumId = Integer.parseInt(request.getParameter("AlbumId"));
			Album album = dao.getAlbumById(albumId);
			ArtistDao artist = new ArtistDao();
			request.setAttribute("artists", artist.getAllArtists());
			request.setAttribute("album", album);
		} else if ("listalbum".equalsIgnoreCase(action)) {
			forward = LIST_ALBUM;
			request.setAttribute("albums", dao.getAllAlbums());
		} else {
			forward = INSERT_OR_EDIT;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);	
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Album album = new Album();
    	album.setAlArtistId(Integer.parseInt(request.getParameter("AlArtistid")));
    	album.setAlGenreId(Integer.parseInt(request.getParameter("AlGenreid")));
    	album.setAlbumName(request.getParameter("AlbumName"));
    	try {
    		Date albumRelease = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("AlbumRelease"));
            album.setAlbumRelease(albumRelease);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    	album.setAlbuminfo(request.getParameter("AlbumInfo"));
    	album.setAlbumImage(request.getParameter("AlbumImage"));
    	String albumid = request.getParameter("AlbumId");
    	if (albumid == null || albumid.isEmpty()) {
			dao.addAlbum(album);
		} else {
			album.setAlbumId(Integer.parseInt(albumid));
			dao.updateAlbum(album);
		}
    	RequestDispatcher view = request.getRequestDispatcher(LIST_ALBUM);
    	request.setAttribute("albums", dao.getAllAlbums());
    	view.forward(request, response);
    }
   
}
