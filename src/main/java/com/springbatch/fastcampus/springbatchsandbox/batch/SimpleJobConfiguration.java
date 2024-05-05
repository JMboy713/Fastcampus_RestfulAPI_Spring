package com.springbatch.fastcampus.springbatchsandbox.batch;

import com.springbatch.fastcampus.springbatchsandbox.service.UpbitMinuteCandleService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class SimpleJobConfiguration {

    private final UpbitMinuteCandleService upbitMarketService;
    @Bean
    public Job simpleJob1(JobRepository jobRepository, Step simpleStep1) {
        return new JobBuilder("simpleJob",jobRepository)
            .start(simpleStep1)
            .build();
    }

    @Bean
    public Step simpleStep1(JobRepository jobRepository, Tasklet testTasklet, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("simpleStep1",jobRepository)
            .tasklet(testTasklet,platformTransactionManager)
            .build();
    }

    @Bean
    public Tasklet testTasklet(){
        return (contribution, chunkContext) -> {
            upbitMarketService.callUpbit();
            System.out.println(">>>>> this is step 1");
            return RepeatStatus.FINISHED;
        };
    }

}
