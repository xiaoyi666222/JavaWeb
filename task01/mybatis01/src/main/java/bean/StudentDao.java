package bean;


import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDao {

    //增
    public void add(Student student) throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            sqlSession.insert("mapper.StudentMapper.add", student);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }


//    public static void main(String[] args) throws Exception {
//
//        StudentDao studentDao = new StudentDao();
//
//        Student student = new Student(2, "Lin", 50000D);
////        Student student =new Student();
////        student.setId();
//        studentDao.add(student);
//
//    }

    //查，根据id
    public Student findById(int id) throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            return sqlSession.selectOne("mapper.StudentMapper.findById",id);
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }
//    public static void main(String[] args) throws Exception {
//        StudentDao studentDao = new StudentDao();
//        Student student = studentDao.findById(1);
//        System.out.println(student.getName());
//
//    }


    public List<Student> findAll() throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            return sqlSession.selectList("mapper.StudentMapper.findAll");
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }
    public static void main(String[] args) throws Exception {
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.findAll();
        System.out.println(students.size());

    }


    //删
    public void delete(int id ) throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            sqlSession.delete("mapper.StudentMapper.delete", id);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }
//    public static void main(String[] args) throws Exception {
//        StudentDao studentDao = new StudentDao();
//        studentDao.delete(2);
//
//    }




    public void update(Student student ) throws Exception {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            sqlSession.update("mapper.StudentMapper.update", student);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    }
//    public static void main(String[] args) throws Exception {
//        StudentDao studentDao = new StudentDao();
//        Student student = studentDao.findById(2);
//        student.setName("Wusong");
//        student.setSal(666666D);
//        studentDao.update(student);
//
//    }




}


