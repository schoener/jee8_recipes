# Simple File Uploader Implementation
This is a simple html servlet file upload implementation. The uploaded file will be read and printed on the page. 
# Form description
* The form which will be used looks like this:

```
<form method="POST" action="fileupload" enctype="multipart/form-data"> 
 <label for="file">Enter file path: </label> 
 <input type="file" name="file" id="file" /> <br /> 
 <input type="submit" value="Upload" name="upload" id="upload"/> 
</form>.
```

# Servlet description
The servlet reads the content sent to it `req.getPart("file")` (since Servlet 3.0) converts to a String `org.apache.commons.io.IOUtils.toString` and writes the output on the page.  
