package br.com.bankslife.backend.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/email"})
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@CrossOrigin
	@PostMapping
	public String sendMail(@RequestBody EmailDto emailDto) {
		
		emailService.send(emailDto.getEmailTo(), emailDto.getSubject(), emailDto.getText());
		
		return "Mensagem Enviada com Sucesso";
	}
}
