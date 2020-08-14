import mapper.UserMapper;
import po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class UserMapperTestThree {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        //得到spring的容器
        applicationContext = new ClassPathXmlApplicationContext("classpath:springThree/applicationContext.xml");
    }
    @Test

    public void findUserById() throws Exception{
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

//        //增
//        User user1 = new User("XiaoLinzi", "999", "Foshan", "male");
//        userMapper.insertUser(user1);

//        //删
//        userMapper.deleteById(16);

//        //改，根据Id
//        User user2 = new User("Chen333", "3333", "Shenzhen01", "female");
//        user2.setId(14);
//        userMapper.updateById(user2);

//        //查，根据Id
//        User user = userMapper.findUserById(13);
//        System.out.println(user);

//        //查，根据username
//        User user3 = userMapper.findUserByUsername("Wang");
//        System.out.println(user3);

        //查（条件查询：按username）
        List<User> userList = userMapper.findUserListByUsername("lin");
//        System.out.println(userList);
        for(User everyUser:userList){
            System.out.println(everyUser);
        }

//        //查（显示全部）
//        List<User> userAllList = userMapper.findUserAll();
//        for(User everyUser:userAllList){
//            System.out.println(everyUser);
//        }

    }
}
