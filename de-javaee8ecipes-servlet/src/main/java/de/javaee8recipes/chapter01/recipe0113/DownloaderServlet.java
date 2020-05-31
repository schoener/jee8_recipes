package de.javaee8recipes.chapter01.recipe0113;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "downloader", urlPatterns = "/downloader")
public class DownloaderServlet extends HttpServlet {
	private static final long serialVersionUID = -7747286670639633952L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/csv;");
		resp.setHeader("Content-disposition", "attachment; filename=yourcustomfilename.csv");
		ServletOutputStream out = resp.getOutputStream();
		String outputString = "1;2;3;4";
		out.write(outputString.getBytes());
		out.flush();
		out.close();
	}
}
