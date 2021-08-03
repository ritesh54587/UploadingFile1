package com.sangamone;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

@GetMapping("/index")
public String Home() {
	return "uploader";
}

@PostMapping("/upload")
public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file){
	  String filename = file.getOriginalFilename();
	  try {
		file.transferTo(new File("F:\\upload\\" + filename));
	} catch (Exception e) {
	
   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	  return ResponseEntity.ok("File upload succesfully");
	  
	  
}
}
