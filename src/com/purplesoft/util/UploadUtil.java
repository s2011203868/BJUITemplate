package com.purplesoft.util;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtil {

	public static HashMap<String,FileItem> getFileItem(HttpServletRequest request){
		
		HashMap<String,FileItem> map = new HashMap<String, FileItem>();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(1024*1024*100);
		try {
			List list = upload.parseRequest(request);
			for(int i = 0 ; i<list.size() ; i++){
				FileItem item = (FileItem) list.get(i);
				String fileName = item.getFieldName();
				map.put(fileName, item);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
		
	}
}
