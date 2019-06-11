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
       * 通过静态代码块加载配置文件
       * 
       * ****/
      static SessionFactory sf = null;
      static
      {
          // 1 创建Configuration对象，用来加载hibernate的配置文件
          Configuration cfg = new Configuration();
          // 2加载配置文件
          cfg.configure("hibernate.cfg.xml");
          // 3通过cfg构造一个会话工厂对象
          sf = cfg.buildSessionFactory();
      }
      public void saveStudent(UserBean stu)
      {
          // TODO Auto-generated method stub
          // 获得数据库的会话对象
          Session session = sf.openSession();
          // 打开事务操作
          Transaction tr = session.beginTransaction();
          // 添加数据
          session.save(stu);
          // 提交事务
          tr.commit();
          // 关闭资源
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
           * 如果传入的对象的唯一标识是null，那对数据库进行保存操作
           * 
           * 如果传入的对象的唯一标识不是null，会进行更新操作，如果不存在
           * 
           * **/
           session.saveOrUpdate(stu);
          // 4
          tr.commit();
          // 5
          session.close();
      }

      /*** 多条查询 ***/
     public List<UserBean> selStudentAll()
      {
          // TODO Auto-generated method stub
         // 1 session
         Session session = sf.openSession();
         // 2(通过hibernate提供的查询语句进行查询)
         String hql = "from student";
         // 3执行hql语句
         return session.createQuery(hql).list();
     }
 }