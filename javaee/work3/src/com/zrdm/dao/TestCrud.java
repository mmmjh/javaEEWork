  package com.zrdm.dao;
  import java.util.List;
  import org.junit.Before;
  import org.junit.Test;
  import com.zrdm.sql.*;;
  public class TestCrud
  {
     // ����Dao����
     UserDao dao;
     /***
      * 
      * init���������м�@Testע��ķ���ִ��֮ǰ�����Զ�ִ�С�
      * 
      * ***/
     @Before
     public void init()
     {
         dao = new UserDao();
     }
     /**
      * 
      * ��������ѧ���Ĺ���
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
      * ���Ը��¹���
      * 
      * ***/
     @Test
     public void testUpdateStudent()
     {
    	 UserBean stu = new UserBean();
         // ���������id�����ݿ�û�ж�Ӧ�ļ�¼���׳��쳣
         stu.setUserid(12);
         stu.setUsername("web11");
         dao.updateStudent(stu);
     }
     /***
      * 
      * ����ɾ��
     * 
      * **/
     @Test
     public void testDeleteStudent()
     {
         // �����˶����Լ���װ��id���Ե�ֵ
        /*
           Student stu = new Student();
          * 
          * stu.setSno(4);
          */
        // ɾ��֮ǰ���Ƚ��в�ѯ����
    	 //UserBean stu = dao.selStudentBySno(3);
    	 UserBean stu = new UserBean();
    	 stu.setUserid(15);
    	 
         dao.deleteStudent(stu);
     }
     /***
      * 
      * ���Զ�����ѯ
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