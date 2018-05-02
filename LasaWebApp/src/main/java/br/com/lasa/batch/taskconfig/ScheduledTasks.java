package br.com.lasa.batch.taskconfig;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import br.com.lasa.mvc.service.IProcessamentoService;
import br.com.lasa.mvc.service.IVendaService;

@Component
public class ScheduledTasks {
	@Autowired
	private IVendaService vendaService;

	@Autowired
	private IProcessamentoService processamentoService;
	  	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	@Scheduled(initialDelay = 10000 /* 10 segundos */, fixedRate = 60000 /* 60 segundos */)
	public void performDelayedTask() {
		if(vendaService.processarVenda()) {
			System.out.println("vendaService.consolidarVenda() OK - " + dateFormat.format(new Date()));
		} else {
			System.out.println("vendaService.consolidarVenda() Sem registros - " + dateFormat.format(new Date()));
		}
	
	}
	
	@Scheduled(initialDelay = 70000 /* 70 segundos */, fixedRate = 60000 /* 60 segundos */) 
    public void performPocesseJob() throws Exception { 
		if(processamentoService.exportarProcessamentoVenda()) {
			System.out.println("processamentoService.exportarProcessamentoVenda() OK - " + dateFormat.format(new Date()));
		} else {
			System.out.println("processamentoService.exportarProcessamentoVenda() Sem registros - " + dateFormat.format(new Date()));
		}
    }
   
}