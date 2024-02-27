package com.Task.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {
	
	private Logger logger=LoggerFactory.getLogger(PdfService.class);
	public ByteArrayInputStream createPdf(String Tittle, String Content) {
		logger.info("Creating pdf:");
		String tittle=Tittle;
		String content=Content;
		
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		Document document=new Document();
		
		PdfWriter.getInstance(document, out);
		document.open();
		
		Font titleFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
		Paragraph paragraph=new Paragraph(tittle,titleFont);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		
		document.add(paragraph);
		
		Font paraFont=FontFactory.getFont(FontFactory.TIMES_ROMAN,15);
		Paragraph paragraph2=new Paragraph(content,paraFont);
		paragraph2.add(new Chunk("testing text 1"));
		document.add(paragraph2);
		document.close();
		
		return new ByteArrayInputStream(out.toByteArray());
		
	}

}
