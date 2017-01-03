package spring.news.parse;

import java.util.Date;

public class HelloWord {

    //@Scheduled(fixedDelay=10000)
    //@Scheduled(cron="0 0 0/12 * *  ?") // каждые 12 часов
    public void hello(){

        System.out.println("Hello, word! " + new Date());
    }
}
