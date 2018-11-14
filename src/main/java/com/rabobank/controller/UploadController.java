package com.rabobank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rabobank.domain.Record;
import com.rabobank.service.CSVValidatorService;
import com.rabobank.service.XMLValidatorService;

import java.io.IOException;
import java.util.List;

/**
 * Controller class for handling file upload
 * 
 * @author ksvijaynkl
 *
 */
@Controller
public class UploadController {

	@Autowired
	CSVValidatorService csvValidatorService;

	@Autowired
	XMLValidatorService xmlValidatorService;

	@GetMapping("/")
	public String index() {
		return "upload";
	}

	/**
	 * Rest method to handle incoming files
	 * 
	 * @param file
	 * @param redirectAttributes
	 * @return String
	 */
	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}

		try {

			List<Record> transctionrecordList = null;

			if (file.getOriginalFilename().endsWith(".csv")) {
				transctionrecordList = csvValidatorService.validateCSVFile(file);
			} else if (file.getOriginalFilename().endsWith(".xml")) {
				transctionrecordList = xmlValidatorService.validateCSVFile(file);
			}
			redirectAttributes.addFlashAttribute("transactionList", transctionrecordList);

		} catch (IOException e) {
			throw new MultipartException(e.getMessage());
		}

		return "redirect:/status";
	}

	/**
	 * Method for mapping next page for file upload status
	 * 
	 * @return String
	 */
	@GetMapping("/status")
	public String uploadStatus() {
		return "status";
	}

}