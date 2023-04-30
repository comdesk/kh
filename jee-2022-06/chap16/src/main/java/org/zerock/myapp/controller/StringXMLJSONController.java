package org.zerock.myapp.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.SampleDTO;
import org.zerock.myapp.domain.Ticket;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@AllArgsConstructor //생성자를 통한 자동 주입
@Log4j2

@RequestMapping("/sample")
@RestController("sampleController")
public class StringXMLJSONController {

	private DataSource dataSource;
	
	@GetMapping(
		path="/getString", 
		//이 핸들러 메소드가 반환하는 데이터의 Content Type 지정하는 속성
		produces= {
//		MediaType.TEXT_PLAIN_VALUE						//한글 깨짐
//		MediaType.TEXT_PLAIN_VALUE + "; charset=UTF-8"	//한글 안깨짐
		"text/plain; charset=utf8"						//한글 안깨짐
	})
	public String getString() {
		log.trace("getString() invoked.");
		
		return "안녕하세요";
	}
	
	
//	@GetMapping("/getSample")	//produces 속성으로 Content Type을 기재 안하면 => 기본 컨텐츠타입은 XML 변환
	@GetMapping(
			path="/getSample77", 
			//XML, JSON 타입을 모두 지정하면, 순서와 상관없이 무조건 xml로 변환(***)
			produces= {MediaType.APPLICATION_JSON_VALUE,	//JSON으로 변환(한글 안꺠짐)
					   MediaType.APPLICATION_XML_VALUE} 
//			produces=MediaType.APPLICATION_XML_VALUE	   //xml로 변환 요청(한글 안꺠짐)
			)	
	
	public SampleDTO getSample() {
		log.trace("getSample() invoked.");
		
		SampleDTO dto = new SampleDTO();
		dto.setMno(100);
		dto.setFirstName("요셉");
		dto.setLastName("김");
		
		log.info("\t+ dto: {}", dto);
		
		return dto;
	} //getSample
	
	@GetMapping(path="/getSampleByJSON", produces="application/json")
	public SampleDTO getSampleByJSON() {
		log.trace("getSample() invoked.");
		
		SampleDTO dto = new SampleDTO();
		dto.setMno(100);
		dto.setFirstName("요셉");
		dto.setLastName("김");
		
		log.info("\t+ dto: {}", dto);
		
		return dto;
	} //getSampleByJSON
	
	@GetMapping(path="/getSampleByXML", produces="application/xml")
	public SampleDTO getSampleByXML() {
		log.trace("getSample() invoked.");
		
		SampleDTO dto = new SampleDTO();
		dto.setMno(100);
		dto.setFirstName("요셉");
		dto.setLastName("김");
		
		log.info("\t+ dto: {}", dto);
		
		return dto;
	} //getSampleByXML
	
	@GetMapping(path="/getSampleList", produces="application/json")
	public List<SampleDTO> getSampleList() {
		log.trace("getSampleList() invoked.");
		
		List<SampleDTO> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			SampleDTO dto = new SampleDTO();
			dto.setMno(i);
			dto.setFirstName("FIRST_NAME_"+i);
			dto.setLastName("LAST_NAME_"+i);
			
			list.add(dto);
		} //for
		
		log.info("\t+ list: {}", list);
		
		return list;
	} //getSampleList
	
	@GetMapping(path="/getSampleMap", produces="application/json")
	public Map<String, SampleDTO> getSampleMap() {
		log.trace("getSampleMap() invoked.");
		
		Map<String, SampleDTO> map = new Hashtable<>();
		
		for(int i=0; i<10; i++) {
			SampleDTO dto = new SampleDTO();
			dto.setMno(i);
			dto.setFirstName("FIRST_NAME_"+i);
			dto.setLastName("LAST_NAME_"+i);
			
			map.put("SAMPLE_" + i, dto);
		} //for
		
		log.info("\t+ map: {}", map);
		
		return map;
	} //getSampleMap
	
	@GetMapping(path="/getSampleSet", produces="application/json")
	public Set<SampleDTO> getSampleSet() {
		log.trace("getSampleSet() invoked.");
		
		Set<SampleDTO> set = new HashSet<>();
		
		for(int i=0; i<10; i++) {
			SampleDTO dto = new SampleDTO();
			dto.setMno(i);
			dto.setFirstName("FIRST_NAME_"+i);
			dto.setLastName("LAST_NAME_"+i);
			
			set.add(dto);
		} //for
		
		log.info("\t+ set: {}", set);
		
		return set;
	} //getSampleSet
	
	@GetMapping(path="/getSampleArray", produces="application/json")
	public SampleDTO[] getSampleArray() {
		log.trace("getSampleArray() invoked.");
		
		SampleDTO[] arr = { null, null, null, null, null};
		
		for(int i=0; i<5; i++) {
			SampleDTO dto = new SampleDTO();
			dto.setMno(i);
			dto.setFirstName("FIRST_NAME_"+i);
			dto.setLastName("LAST_NAME_"+i);
			
			arr[i] = dto;
		} //for
		
		log.info("\t+ arr: {}", arr);
		
		return arr;
	} //getSampleArray
	
	@GetMapping(path="/getSampleTicket", produces="application/json")
	public Ticket getSampleTicket() {
		log.trace("getSampleTicket() invoked.");
		
		Ticket ticket = new Ticket();
		ticket.setTno(1000);
		ticket.setGrade("A");
		
		SampleDTO dto = new SampleDTO();
		dto.setMno(3);
		dto.setFirstName("Yoseph");
		dto.setLastName("Kim");
//		ticket.setOwner(dto);
		
		log.info("\t+ ticket: {}", ticket);
		
		return ticket;
	} //getSampleTicket
} //end class














