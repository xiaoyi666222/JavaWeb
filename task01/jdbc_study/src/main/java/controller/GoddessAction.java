package controller;

import dao.GoddessDao;
import model.Goddess;

import java.util.*;

public class GoddessAction {

    public static void main(String[] args) throws Exception {
        GoddessDao gd=new GoddessDao();
        //查询所有女神
//        List<Goddess> gs=gd.query();
//        for (Goddess goddess : gs) {
//            System.out.println(goddess.getUserName()+","+goddess.getAge());
//        }

        Goddess g1=new Goddess();
        g1.setUserName("小夏");
        g1.setAge(22);
        g1.setSex(1);
        g1.setBirthday(new Date());
        g1.setEmail("xiaoxia@qq.com");
        g1.setMobile("123456789");
        g1.setCreateUser("admin");
        g1.setUpdateUser("admin");
        g1.setIsDel(1);
        //添加女神
//        gd.addGoddess(g1);

        //删除
//        gd.delGoddess(7);

        //改，更新
//        Goddess g2=new Goddess();
//        g2.setId(6);
//        g2.setUserName("小夏");
//        g2.setSex(1);
//        g2.setAge(18);
//        g2.setBirthday(new Date());
//        g2.setIsDel(0);
//        g2.setMobile("666666333");
//        g2.setCreateUser("Wu");//updateGoddes()方法未定义
//        g2.setUpdateUser("Wu");
//
//        gd.updateGoddess(g2);

        //查询单个女神（根据id）
        /*Goddess g2 = gd.get(1);
        System.out.println(g2.toString());*/

        //查询单个女神（根据姓名等信息）
//        List<Goddess> list = gd.get("小溪", "139");
//        //遍历结果集
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i).toString());
//        }

        //查询进一步完善的
        //查询单个女神(根据姓名等信息去查询)----->使用Map存储条件信息
        List<Map<String, Object>> params=new ArrayList<Map<String,Object>>();
        Map<String, Object> param=new HashMap<String, Object>();
        param.put("name", "user_name");
//        param.put("rela", "=");
//        param.put("value", "'小溪'");//注意加上单引号，因为这个变量是字符串的形式
        param.put("rela", "like");
        param.put("value", "'%小溪%'");//注意加上单引号，因为这个变量是字符串的形式
        params.add(param);
        param=new HashMap<String, Object>();
        param.put("name", "mobile");
        param.put("rela", "like");
        param.put("value", "'%139%'");
        params.add(param);
        List<Goddess> list1 = gd.get(params);
        //遍历结果集
        for(int i=0;i<list1.size();i++){
            System.out.println(list1.get(i).toString());
        }

    }

}