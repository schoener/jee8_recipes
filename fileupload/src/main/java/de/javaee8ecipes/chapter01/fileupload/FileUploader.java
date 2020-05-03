package de.javaee8ecipes.chapter01.fileupload;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet(name = "fileupload", urlPatterns = "/fileupload")
@MultipartConfig
public class FileUploader extends HttpServlet {
	private static final long serialVersionUID = 573885684193552049L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part filePart = req.getPart("file"); // Retrieves <input type="file" name="file">
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		InputStream fileInput = filePart.getInputStream();
		String fileContent = IOUtils.toString(fileInput, "UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet NumberProcessor</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2> file name:" + fileName + "</h2>");
		out.println("<h2> file content:" + fileContent + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
