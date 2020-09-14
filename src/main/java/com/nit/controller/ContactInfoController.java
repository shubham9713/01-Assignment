package com.nit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.dto.ContactDTO;
import com.nit.service.ContactService;

@Controller

public class ContactInfoController {
	
	@Autowired
	private ContactService service;

	/*@InitBinder
	public void initBinder(WebDataBinder databinder)
	{
		StringTrimmerEditor ste=new StringTrimmerEditor(true);
		databinder.registerCustomEditor(String.class, ste);
		
	}*/
	
	
	/**
	 * display contact form
	 */
	@GetMapping("/index")
	public String showContactForm(Model model)
	{
 		model.addAttribute("contactDTO", new ContactDTO());
		return "index";
	}
	/**
	 * save contact using Submit button
	 */
	
	@PostMapping("/save")
	public String handleSubmitBtn(@Valid @ModelAttribute ContactDTO contactDTO ,
			RedirectAttributes model)
			
	{
		boolean isSaved=service.saveContact(contactDTO);
	
		
		if(isSaved) 
		{
			if(contactDTO.getCid()!=null)
		{
		model.addFlashAttribute("succmsg", "Contact Updated successfully");
	    }
		else
		{
			model.addFlashAttribute("succmsg", "Contact saved successfully");
		    }
		}
		else
		{
			model.addFlashAttribute("errmsg", "Contact failed to Saved");
		}
		 
		return "redirect:index";
		 }
		//model.addAttribute("contactDTO", new ContactDTO());
		
	
	/**
	 * get all contact hyperlink 
	 */
	@GetMapping("/all")
	public String viewContactHyperLink(Model model)
	{
		List<ContactDTO> list=service.getAllConatct();
		model.addAttribute("list", list);
		return "ContactAll";
	}
}
