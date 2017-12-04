package br.com.cea.transporte.batch.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cea.transporte.batch.processor.IntegrationProcessor;
import br.com.cea.transporte.batch.reader.IntegrationItemReader;

@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step loadIntegrationStep(  @Qualifier("integrationItemReader") ItemReader<Object> reader
									, @Qualifier("integrationProcessor") ItemProcessor<Object, Object> processor) {

		CompositeItemProcessor<Object, Object> compositeProcessor = new CompositeItemProcessor<>();
		List<ItemProcessor<Object, Object>> itemProcessors = new ArrayList<>();
		itemProcessors.add(processor);
		compositeProcessor.setDelegates(itemProcessors);

		return stepBuilderFactory.get("loadIntegrationStep")
								 .<Object, Object>chunk(10).reader(reader)
								 .processor(compositeProcessor)
								 .build();
	}

	@Bean
	public Job job(@Qualifier("loadIntegrationStep") Step loadIntegrationStep) throws Exception {
		return jobBuilderFactory.get("job")
								.incrementer(new RunIdIncrementer())
								.start(loadIntegrationStep)
								.build();
	}

	@Bean
	public ItemReader<Object> integrationItemReader() {
		return new IntegrationItemReader();
	}

	@Bean
	public ItemProcessor<Object, Object> integrationProcessor() {
		return new IntegrationProcessor();
	}

	// @Bean
	// public ItemWriter<Object> citasWriter() {
	// return new integrationWriter();
	// }

}
