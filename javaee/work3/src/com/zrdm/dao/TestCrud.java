  package com.zrdm.dao;
  import java.util.List;
  import org.junit.Before;
  import org.junit.Test;
  import com.zrdm.sql.*;;
  public class TestCrud
  {
     // 声明Dao变量
     UserDao dao;
     /***
      * 
      * init方法在所有加@Test注解的方法执行之前，会自动执行。
      * 
      * ***/
     @Before
     public void init()
     {
         dao = new UserDao();
     }
     /**
      * 
      * 测试增加学生的功能
      * 
      * ***/
     @Test
     public void testSaveStudent()
     {
         UserBean stu = new UserBean();
         stu.setUsername("wed");
         stu.setUserid(12);
         dao.saveStudent(stu);
     }
     /***
      * 
      * 
      * 
      * 测试更新功能
      * 
      * ***/
     @Test
     public void testUpdateStudent()
     {
    	 UserBean stu = new UserBean();
         // 如果给定的id在数据库没有对应的记录，抛出异常
         stu.setUserid(12);
         stu.setUsername("web11");
         dao.updateStudent(stu);
     }
     /***
      * 
      * 测试删除
     * 
      * **/
     @Test
     public void testDeleteStudent()
     {
         // 创建了对象，自己封装了id属性的值
        /*
           Student stu = new Student();
          * 
          * stu.setSno(4);
          */
        // 删除之前，先进行查询操作
    	 //UserBean stu = dao.selStudentBySno(3);
    	 UserBean stu = new UserBean();
    	 stu.setUserid(15);
    	 
         dao.deleteStudent(stu);
     }
     /***
      * 
      * 测试多条查询
      * 
      * ***/
     @Test
     public void testSelectStudentAll()
     {
         List<UserBean> list = dao.selStudentAll();
         for (UserBean s : list)
         {
             System.out.println("-----" + s.getUserid() + "\t" + s.getUsername()
                     + "\t" );
         }
     }
 }