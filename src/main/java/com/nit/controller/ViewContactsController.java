package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nit.dto.ContactDTO;
import com.nit.service.ContactService;

@Controller

public class ViewContactsController {

	@Autowired
	private ContactService service;
	/**
	 * Add contact hyperlink
	 */
	@GetMapping("/add")
	public String addContactHyperlink(Model model)
	{
		model.addAttribute("contactDTO", new ContactDTO());
		return "index";
	}
	/**
	 * Edit contact
	 */
	@GetMapping("/edit")
	public String editContactById(@RequestParam Integer cid,Model model)
	{
		ContactDTO contactDTO=service.getContactById(cid);
		model.addAttribute("contactDTO", contactDTO);
		return "index";
	}
	/**
	 * delete  contact
	 */
	@GetMapping("/delete")
	public String deleteConatct(@RequestParam Integer cid,RedirectAttributes model)
	{
		service.deleteContact(cid);
		model.addFlashAttribute("succmsg", "contact deleted successfully");
		return "redirect:all";
	}
}
