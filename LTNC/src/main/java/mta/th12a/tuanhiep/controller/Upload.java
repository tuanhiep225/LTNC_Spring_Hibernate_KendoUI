package mta.th12a.tuanhiep.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping(value="/upload")
public class Upload {
@RequestMapping(value="/index")
public String Index()
{
	return "upload";
}
@RequestMapping(value = "/upload", method = RequestMethod.POST)
public @ResponseBody String upload(ModelMap mm, HttpServletRequest request, HttpServletResponse response, MultipartFile files) {
    String path = "E:/HOCTAP/HOC VIEN/Nam 4/GITHUB/LTNC/LTNC/src/main/webapp/WEB-INF/resources/images/upload/";
    if (files != null) {
        try {
             FileUtils.forceMkdir(new File(path));
             File upload = new File(path + files.getOriginalFilename());
             files.transferTo(upload);
             mm.put("fileUpload", files.getOriginalFilename());
        } catch (IOException ex) {
             ex.printStackTrace();
        }
    }
    return "";
}
}
