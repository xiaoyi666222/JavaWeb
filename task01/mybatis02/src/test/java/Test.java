import bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    SqlSession sqlSession = null;
    @Before
    public void init() throws IOException {
        //mybatis全局配置文件
//        String resource = "E://ideaProjects02//spring_study//src//main//resources//mybatis-configuration.xml";
        String resource = "mybatis-configuration.xml";
        //加载全局配置文件
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resource);
        //创建SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //通过工厂生成sqlSession
        sqlSession = factory.openSession();

//        Reader reader = Resources.getResourceAsReader("mybatis-configuration.xml");
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
////        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        sqlSession = factory.openSession();

    }
    @org.junit.Test
    /**
     *
     * @param registrationTime
     */
    public void testGetUser(){
        /*这个字符串由 userMapper.xml 文件中 两个部分构成
        <mapper namespace="com.yingside.mapper.UserMapper"> 的 namespace 的值
        <select id="getUser" > id 值
        其实就相当于之前Dao层中xxxDaoImpl.getUser()方法
        */
        String stmt = "mapper.UserMapper.getUser";
        //传入字符串以及参数id
        User user = sqlSession.selectOne(stmt,1);
        System.out.println(user);
        //关闭sqlSession
        sqlSession.close();
    }


}
