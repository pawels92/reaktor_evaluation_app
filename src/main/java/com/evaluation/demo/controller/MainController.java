package com.evaluation.demo.controller;

import com.evaluation.demo.model.entity.Contact;
import com.evaluation.demo.service.AutoMailingService;
import com.evaluation.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

<<<<<<< HEAD
        ContactService contactService;
        AutoMailingService autoMailingService;

        @Autowired
        public MainController(ContactService contactService, AutoMailingService autoMailingService) {
            this.contactService = contactService;
            this.autoMailingService = autoMailingService;
        }
=======
>>>>>>> ac373f245d232d0c08d264ce992e199e0d94989a
    @GetMapping("/")
    public String login(){
        return "homepage";
    }

    @GetMapping("/contact")
<<<<<<< HEAD
    public String contact(Model model) {
        //powiazanie obiektu klasy Contact
        //z obiektem contact z szablonu html
        model.addAttribute("contact", new Contact());
        return "contactPage";
=======
    public String kontakt() {
        return "contact";

>>>>>>> ac373f245d232d0c08d264ce992e199e0d94989a
    }

    @PostMapping("/contact")
    public String contact(@ModelAttribute @Valid Contact contact, BindingResult bindingResult, Model model) {
        String info = "";
        if (bindingResult.hasErrors()) {
            info = "w formularzu występują błędy";
            model.addAttribute("info", info);
            return "contactPage";
        }
        //zapis do DB poprzez ContactService
        contactService.createContact(contact);
        //czyszczenie pól po wysłaniu wiadomości
        //auto-email
        autoMailingService.sendSimpleMessage(
                contact.getEmail(),
                "Potwierdzenie wysłania formularza kontaktowego",
                "Dziękujemy za kontakt. Odezwiemy się niezwłocznie"
        );
        contact.setSubject("");
        contact.setMessage("");
        contact.setEmail("");
        return "contactPage";
    }
}


