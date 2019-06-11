package com.zrdm.dao;
import java.util.List;
   import org.hibernate.Session;
   import org.hibernate.SessionFactory;
   import org.hibernate.Transaction;
   import org.hibernate.cfg.Configuration;
   import com.zrdm.sql.*;;
   public class UserDao 
  {
      /**
       * 
       * ͨ����̬�������������ļ�
       * 
       * ****/
      static SessionFactory sf = null;
      static
      {
          // 1 ����Configuration������������hibernate�������ļ�
          Configuration cfg = new Configuration();
          // 2���������ļ�
          cfg.configure("hibernate.cfg.xml");
          // 3ͨ��cfg����һ���Ự��������
          sf = cfg.buildSessionFactory();
      }
      public void saveStudent(UserBean stu)
      {
          // TODO Auto-generated method stub
          // ������ݿ�ĻỰ����
          Session session = sf.openSession();
          // ���������
          Transaction tr = session.beginTransaction();
          // �������
          session.save(stu);
          // �ύ����
          tr.commit();
          // �ر���Դ
          session.close();
      }
      public void deleteStudent(UserBean stu)
      {
          // TODO Auto-generated method stub
          // 1
         Session session = sf.openSession();
          // 2
         Transaction tr = session.beginTransaction();
          // 3
          session.delete(stu);
          // 4
          tr.commit();
          // 5
          session.close();
      }
      public void updateStudent(UserBean stu)
      {
          // TODO Auto-generated method stub
          // 1
          Session session = sf.openSession();
          // 2
          Transaction tr = session.beginTransaction();
          // 3
          //session.update(stu);
          /***
           * 
           * �������Ķ����Ψһ��ʶ��null���Ƕ����ݿ���б������
           * 
           * �������Ķ����Ψһ��ʶ����null������и��²��������������
           * 
           * **/
           session.saveOrUpdate(stu);
          // 4
          tr.commit();
          // 5
          session.close();
      }

      /*** ������ѯ ***/
     public List<UserBean> selStudentAll()
      {
          // TODO Auto-generated method stub
         // 1 session
         Session session = sf.openSession();
         // 2(ͨ��hibernate�ṩ�Ĳ�ѯ�����в�ѯ)
         String hql = "from student";
         // 3ִ��hql���
         return session.createQuery(hql).list();
     }
 }