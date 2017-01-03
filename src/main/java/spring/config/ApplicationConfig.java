package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import spring.news.parse.Crawler;
import spring.news.parse.HelloWord;

@Configuration
@EnableScheduling
@ComponentScan("spring")
public class ApplicationConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        System.out.println("here");
        taskRegistrar.setTaskScheduler(taskScheduler());
        taskRegistrar.addFixedRateTask(new Runnable() {
            public void run() {
                /*try {
                    parseNews().getNewsList();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }*/
                myTask().hello();
            }
        }, /*5000*/ 86400000);

    }

    @Bean()
    public ThreadPoolTaskScheduler taskScheduler() {
        System.out.println("taskScheduler()");
        ThreadPoolTaskScheduler t = new ThreadPoolTaskScheduler();
        t.setPoolSize(1);
        return t;
    }

    /*@Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        System.out.println("here");
        taskRegistrar.setScheduler(taskScheduler());
        taskRegistrar.addTriggerTask(
                new Runnable() {
                    public void run() {
                        myTask().hello();
                    }
                },
                new Trigger() {
                    @Override public Date nextExecutionTime(TriggerContext triggerContext) {
                        Duration d = Duration.ofHours(12);
                        return new Date(d.getSeconds());
                    }
                }
        );
    }*/

    /*@Bean(destroyMethod="shutdown")
    public Executor taskScheduler() {
        return Executors.newScheduledThreadPool(42);
    }*/

    @Bean
    public HelloWord myTask() {
        return new HelloWord();
    }

    @Bean
    public Crawler parseNews() {
        return new Crawler("aggregate.json");
    }
}
