package br.com.lasa.batch.taskconfig;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.lasa.mvc.service.IVendaService;

@Component
public class ScheduledTasks {
	@Autowired
	private IVendaService vendaService;
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"MM/dd/yyyy HH:mm:ss");
/*
	@Scheduled(fixedRate = 10000)
	public void performTask() {

		System.out.println("Regular task performed at "
				+ dateFormat.format(new Date()));

	}

	@Scheduled(cron = "*\/5 * * * * *")
	public void performTaskUsingCron() {

		System.out.println("Regular task performed using Cron at "
				+ dateFormat.format(new Date()));

	}	
*/

	@Scheduled(initialDelay = 1000, fixedRate = 60000) // um minuto
	public void performDelayedTask() {
		if(vendaService.consolidarVenda()) {
			System.out.println("vendaService.consolidarVenda() OK - "
					+ dateFormat.format(new Date()));
		} else {
			System.out.println("vendaService.consolidarVenda() Fail - "
					+ dateFormat.format(new Date()));
		}
		
	
	}

}