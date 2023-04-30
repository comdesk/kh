package org.zerock.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@RequestMapping("/fileupload")

@Controller("fileUploadController")
public class FileUploadController {
	
//	파일 업로드용 화면 => view-controller로 가능
	@GetMapping("/page")
	public void uploadPage() {
		log.trace("uploadPage() invoked.");
	} //uploadPage
	
	@PostMapping("/doit")
	public void processMultipart(@RequestParam("files") List<MultipartFile> files, String uploader) {
		log.trace("processMultipart({}, {}) invoked.", files, uploader);
		
		files.forEach( f -> {
			log.info("\t+ 1. Name: {}", f.getName());
			log.info("\t+ 2. OriginalFilename: {}", f.getOriginalFilename());
			log.info("\t+ 3. ContentType: {}", f.getContentType());
			log.info("\t+ 4. Size: {}", f.getSize());
			log.info("\t-----------------------------------");
			
			if(!"".equals(f.getOriginalFilename())) {	//첨부파일이 있는 경우
				try {
					f.transferTo(new File("C:/temp/upload/"+f.getOriginalFilename()));
				} catch(IOException e) {
					e.printStackTrace();
				} //try-catch
				
//				try {
//					byte[] bytes = f.getBytes();		//1st. 파일 데이터 얻는 method
////					InputStream is = f.getInputStream();	//2nd. method
//					
//					@Cleanup FileOutputStream fos = new FileOutputStream("C:/temp/upload/"+f.getOriginalFilename());
//					@Cleanup BufferedOutputStream bos = new BufferedOutputStream(fos);
//					
//					bos.write(bytes);
//					bos.flush();
//					
//				} catch(IOException e) {	//파일시스템에 써야하니까
//					e.printStackTrace();
//				}
				
			} //if
		});
	} //processMultipart
	
} //end class















