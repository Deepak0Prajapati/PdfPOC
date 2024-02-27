package com.Task.controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Task.MODEL.Student;
import com.Task.repository.StudentRepo;
import com.Task.service.PdfService;

@Controller
public class PDFController {
	
	@Autowired
	private StudentRepo  repo;
	
	@Autowired
	private PdfService pdfService;
	
	@GetMapping("/openpdf/{id}")
	public ResponseEntity<InputStreamResource> createpdf(@PathVariable int id) {
		
		Optional<Student> byId = repo.findById(id);
		Student student=byId.get();
		String tittle=student.getName()+ student.getDepartment();
		
		
		
		
		ByteArrayInputStream pdf=pdfService.createPdf(tittle, student.getMessage());
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("content-disposition", "inline;file=test.pdf");
		return ResponseEntity
				.ok().headers(httpHeaders)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));
		
	}
	
	@GetMapping("/register")
	public String about() {
		System.out.println("testingg");
		return "index";
	}
	@GetMapping("/ok")
	public String test() {
		System.out.println("testingg");
		return "test";
	}
	
	
	
	@PostMapping("/process")
	public String about(@ModelAttribute Student student) {
		Student save = repo.save(student);
		
		
		
		return "success";
	}
	
	
	@GetMapping("/get")
	public String getReport(Model m) {
		System.out.println("testingg");
		List<Student> all = repo.findAll();
		m.addAttribute("students",all);
		return "options";
	}

}
