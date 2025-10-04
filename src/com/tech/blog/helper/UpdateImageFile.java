package com.tech.blog.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class UpdateImageFile {

	// Method to delete Image file
	public static boolean deleteFile(String filePath) {
		boolean isDeletedSuccessfully = false;
		
		try {
			File file = new File(filePath);
			isDeletedSuccessfully = file.delete();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return isDeletedSuccessfully;
	}
	
	// Method to save Image file
	public static boolean saveFile(InputStream inputStream, String destinationPath) {
	    boolean isSavedSuccessfully = false;

	    try {
	        // Read all bytes from the input stream
	        byte[] fileData = new byte[inputStream.available()];
	        inputStream.read(fileData);

	        // Write bytes to the destination file
	        FileOutputStream fileOutputStream = new FileOutputStream(destinationPath);
	        fileOutputStream.write(fileData);
	        fileOutputStream.flush();
	        fileOutputStream.close();

	        isSavedSuccessfully = true;

	    } catch (Exception exception) {
	        exception.printStackTrace();
	    }

	    return isSavedSuccessfully;
	}

	
	
}
