package br.com.lasa.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lasa.batch.listener.JobCompletionListener;
import br.com.lasa.batch.step.Processor;
import br.com.lasa.batch.step.Reader;
import br.com.lasa.batch.step.Writer;
import br.com.lasa.mvc.service.IFlatFileService;
import br.com.lasa.mvc.service.IProcessamentoService;

@Configuration
public class BatchConfig {
	
	@Autowired
	private IProcessamentoService processamentoService;

	@Autowired
	private IFlatFileService flatFileService;
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean	
	public Job processJob() {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();
	}

	@Bean
	public Step orderStep1() {
		flatFileService.gerarNovoNomeArquivo();
		return stepBuilderFactory.get("orderStep1").<String, String> chunk(1)
				.reader(new Reader(processamentoService)).processor(new Processor())
				.writer(new Writer(flatFileService)).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}

}