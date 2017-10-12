package com.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.entity.Client;
import com.webapp.service.IClientService;

@Controller
@RequestMapping("/clients")
@CrossOrigin(origins = {"http://localhost:4200"})

public class ClientController {

	@Autowired
	private IClientService clientService;
	
	@GetMapping("/all-clients")
	public ResponseEntity<List<Client>> getAllClient() {
		List<Client> listeClient = clientService.getAllClient();
		
		return new ResponseEntity<List<Client>>(listeClient, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id_client}")
	public ResponseEntity<Client> getClientId(@PathVariable("id_client") final Integer idClient) {
		Client monClient = clientService.getClientById(idClient);
		
		return new ResponseEntity<Client>(monClient, HttpStatus.OK);
		
	}
	
	@GetMapping("/telephone/{telephone}")
	public ResponseEntity<Client> getClientByTelephone(@PathVariable("telephone") final String numTelephone) {
		Client monClient = clientService.getClientByNumeroTelephone(numTelephone);
		
		return new ResponseEntity<Client>(monClient, HttpStatus.OK);
	}
	
	@GetMapping("/client/{client}")
	public ResponseEntity<Client> getClientByClient(@PathVariable("client") final String nomClient) {
		Client monClient = clientService.getClientByClient(nomClient);
		
		return new ResponseEntity<Client>(monClient, HttpStatus.OK);
	}
	
	@GetMapping("/adresse/{addresse}")
	public ResponseEntity<Client> getClientByAdresse(@PathVariable("addresse") final String adresseClient) {
		Client monClient = clientService.getClientByAdresse(adresseClient);
		
		return new ResponseEntity<Client>(monClient, HttpStatus.OK);
	}
	
	@GetMapping("/update-client/{id_client}/{client}/{telephone}/{contact}/{addresse}/{description}/{code_utilisateur}")
	public ResponseEntity<Client> update(@PathVariable("id_client") final Integer idClient, @PathVariable("client") final String leClient,
			@PathVariable("telephone") final String telephoneClient, @PathVariable("contact") final String leContact, @PathVariable("addresse") final String adresseClient,
			@PathVariable("description") final String descriptionClient, @PathVariable("code_utilisateur") final Integer codeUtilisateur) {
		
		
		Client modifierClient = new Client();
		modifierClient.setIdClient(idClient);
		modifierClient.setClient(leClient);
		modifierClient.setTelephone(telephoneClient);
		modifierClient.setContact(leContact);
		modifierClient.setAdresse(adresseClient);
		modifierClient.setDescription(descriptionClient);
		modifierClient.setCodeUtilisateur(codeUtilisateur);
		
		Client client = clientService.doUpdate(modifierClient);
		
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
	@GetMapping("/add-client/{id_client}/{client}/{telephone}/{contact}/{addresse}/{description}/{code_utilisateur}")
	public ResponseEntity<Client> add(@PathVariable("id_client") final Integer idClient, @PathVariable("client") final String leClient,
			@PathVariable("telephone") final String telephoneClient, @PathVariable("contact") final String leContact, @PathVariable("addresse") final String adresseClient,
			@PathVariable("description") final String descriptionClient, @PathVariable("code_utilisateur") final Integer codeUtilisateur) {
		
		
		Client nouveauClient = new Client();
		nouveauClient.setIdClient(idClient);
		nouveauClient.setClient(leClient);
		nouveauClient.setTelephone(telephoneClient);
		nouveauClient.setContact(leContact);
		nouveauClient.setAdresse(adresseClient);
		nouveauClient.setDescription(descriptionClient);
		nouveauClient.setCodeUtilisateur(codeUtilisateur);
		
		Client client = clientService.doAdd(nouveauClient);
		
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
}
