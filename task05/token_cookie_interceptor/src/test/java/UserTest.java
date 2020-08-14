import com.alibaba.fastjson.JSON;
import com.common.entity.User;
import com.common.mapper.UserMapper;
import com.common.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
@Controller
@RequestMapping(value = "/a")
public class UserTest {

    private final static Logger logger = LoggerFactory.getLogger(UserTest.class);
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

//    @Test
//    public void testFindByUser(){
//        User user = userService.findByUsername("abc","yyy");
//        logger.info("findByUser: "+ JSON.toJSONString(user));
//    }

//    @Test
//    public void testFindById(){
//        User user = userService.findById(1);
//        logger.info("findById: "+ JSON.toJSONString(user));
//    }

    @Test
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public void insertUser() throws Exception {

//        User user1 = userMapper.findByUsername(user.getUsername(),user.getPassword());
//        logger.info("findByUser: "+JSON.toJSONString(user1));


    }

}
