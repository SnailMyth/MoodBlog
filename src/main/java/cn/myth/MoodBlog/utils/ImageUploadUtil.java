package cn.myth.MoodBlog.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class ImageUploadUtil {
    // ͼƬ����
    private static List<String> fileTypes = new ArrayList<String>();

    static {
        fileTypes.add(".jpg");
        fileTypes.add(".jpeg");
        fileTypes.add(".bmp");
        fileTypes.add(".gif");
        fileTypes.add(".png");
    }
    
    public static String upload(HttpServletRequest req) {
		
    	CommonsMultipartResolver resolver = new CommonsMultipartResolver(req.getServletContext());
    	String fileName = null;
    	if (resolver.isMultipart(req)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) req;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					String origName = file.getOriginalFilename();
					if (origName.trim() != "") {
						String suffix = origName.substring(origName.lastIndexOf(".")).toLowerCase();
						if (!fileTypes.contains(suffix)) {
                            continue;
                        }
						
						fileName = DateFormat.FORMAT_ROUNDNAME.format(new Date())+suffix;
						File uploadFile = new File(FileUtils.ROOT_IMAGE+ fileName);
						try {
							file.transferTo(uploadFile);
						} catch (IllegalStateException | IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
    	return fileName;
    }   
    
}
