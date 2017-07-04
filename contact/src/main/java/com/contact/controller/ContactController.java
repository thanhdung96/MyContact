package com.contact.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.contact.domain.Contact;
import com.contact.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	// @Qualifier("contact2")
	@Qualifier("contact1")
	// @Qualifier("contact3")
	private ContactService contactService;

	@GetMapping("/contact")
	public String index(Model model) {
		model.addAttribute("contacts", contactService.findAll());
		return "list";
	}

	@GetMapping("/contact/create")
	public String create(Model model) {
		model.addAttribute("contact", new Contact());
		return "form";
	}

	@PostMapping("contact/save")
	public String save(@Valid Contact contact, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors().toString());
			return "form";
		}
		contactService.save(contact);
		redirect.addFlashAttribute("success", "Contact saved");
		return "redirect:/contact";
	}

	@GetMapping("contact/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("contact", contactService.findOne(id));
		return "form";
	}

	@GetMapping("contact/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		contactService.delete(id);
		redirect.addFlashAttribute("success", "Contact deleted");
		return "redirect:/contact";
	}

	@GetMapping("contact/search")
	public String search(@RequestParam("q") String q, Model model) {
		if (q.equals(""))
			return "redirect:/contact";

		model.addAttribute("contacts", contactService.search(q));
		return "list";
	}
}
