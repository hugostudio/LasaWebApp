package br.com.lasa.batch.step;

import java.util.Iterator;
import java.util.List;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import br.com.lasa.mvc.entity.Processamento;
import br.com.lasa.mvc.service.IProcessamentoService;


public class Reader implements ItemReader<String> {
/*	
	private String[] messages = { "javainuse.com",
			"Welcome to Spring Batch Example",
			"We use H2 Database for this example" };

	private int count = 0;
	*/
	private IProcessamentoService processamentoService;
	private List<Processamento> processamentos;
	private Iterator<Processamento> itrt;
	
	public Reader(IProcessamentoService processamentoService) {
		super();
		this.processamentoService = processamentoService;
	}
	
	@Override
	public String read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		if(processamentos==null) {
			processamentos = processamentoService.getNextLote();
			itrt = processamentos.iterator();
		}
		
		if (itrt.hasNext()) {
			return itrt.next().toString();
		} else {
			processamentos = processamentoService.getNextLote();
			itrt = processamentos.iterator();
		}
		return null;
	}

}