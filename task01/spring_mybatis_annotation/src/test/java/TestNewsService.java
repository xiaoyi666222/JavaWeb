import com.spring.entity.News;
import com.spring.service.NewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContextAnnotation.xml")
public class TestNewsService {

    // @Test
    // public void testFindAll(){
    // ClassPathXmlApplicationContext context = new
    // ClassPathXmlApplicationContext("applicationContext.xml");
    // NewsService newsService = (NewsService)
    // context.getBean("newsServiceImpl");
    // List<News> list = newsService.findAll();
    // list.forEach(System.out::println);
    // }

    //使用springJunit4测试
    @Autowired
    private NewsService newsService;

    @Test
    public void testFindAll() {
        List<News> list = newsService.findAll();
        list.forEach(System.out::println);
    }
}


