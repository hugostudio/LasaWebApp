package br.com.lasa.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lasa.mvc.entity.Venda;
import br.com.lasa.mvc.service.IVendaService;

@RestController
@RequestMapping("/endpoint")
public class VendaController {
	@Autowired
	private IVendaService vendaService;
	
	@GetMapping("venda/{id}")
	public ResponseEntity<Venda> getVendaById(@PathVariable("id") Integer id) {
		Venda venda = vendaService.getVendaById(id.longValue());
		return new ResponseEntity<Venda>(venda, HttpStatus.OK);
	}

	@GetMapping("vendas")
	public ResponseEntity<List<Venda>> getAllVendas() {
		List<Venda> list = vendaService.getAllVendas();
		return new ResponseEntity<List<Venda>>(list, HttpStatus.OK);
	}
	
	@GetMapping("venda/next")
	public ResponseEntity<Venda> getNextOldVenda() {
		Venda venda = vendaService.getNextOldVenda();
		return new ResponseEntity<Venda>(venda, HttpStatus.OK);
	}	
	
	@PostMapping("venda")
	public ResponseEntity<Void> addVenda(@RequestBody Venda venda, UriComponentsBuilder builder) {
        boolean flag = vendaService.addVenda(venda);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
         } else {
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/venda/{id}").buildAndExpand(venda.getId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
         }
	}
	
	@PutMapping("venda")
	public ResponseEntity<Venda> updateVenda(@RequestBody Venda venda) {
		vendaService.updateVenda(venda);
		return new ResponseEntity<Venda>(venda, HttpStatus.OK);
	}
	
	@DeleteMapping("venda/{id}")
	public ResponseEntity<Void> deleteVenda(@PathVariable("id") Integer id) {
		vendaService.deleteVenda(id.longValue());
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
