package ru.epam.salynskii.core.biritch;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.epam.salynskii.core.biritch.db.entities.NewsMeta;
import ru.epam.salynskii.core.biritch.db.service.Service;

/**
 * Created by Alimantu on 07/09/16.
 */
public class Main {
    public static void main(String[] args) {
//        Crawler crawler = new Crawler("aggregate.json");
//        crawler.getNewsList();

        System.out.println("load context");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        NewsMeta newsMeta = new NewsMeta("Some title", "some url", "this is tag");
//        ArrayList<Object> tmp = (ArrayList<Object>) context.getBean("newsMetaService");
        Service service = (Service) context.getBean("newsMetaService");
        service.persist(newsMeta);
//        News news = new News(0L, 0L);
//        NewsService newsService = (NewsService) context.getBean("newsService");
//        newsService.persist(news);
//        System.out.println("Updated news_id:" + newsService.findById(0L).getNews_id());
//        news.setNews_id(2L);
//        newsService.update(news);
//        System.out.println("Updated age :" + newsService.findById(0L).getNews_id());
//        newsService.delete(news);
        context.close();
//        EmployeeService emService = (EmployeeService) context.getBean("employeeService");
//        emService.persistEmployee(em);
//        System.out.println("Updated age :" + emService.findEmployeeById("123").getAge());
//        em.setAge(32);
//        emService.updateEmployee(em);
//        System.out.println("Updated age :" + emService.findEmployeeById("123").getAge());
//        emService.deleteEmployee(em);
//        context.close();

    }
}
