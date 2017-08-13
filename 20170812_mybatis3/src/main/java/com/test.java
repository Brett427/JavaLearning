package com;
import com.pojo.Clazz;
import com.pojo.Person;
import com.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by brett on 2017/8/12.
 */
public class test {
    public static void main (String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqls = sqlSessionFactory.openSession();
        PersonMapper pm = sqls.getMapper(PersonMapper.class);
        Person p = pm.selectPersonById(1);
        System.out.println(p.getCard().getCode());
//        Person person = new Person();
//        person = sqls.selectOne("com.PersonMapper.selectPersonById", 1);
//        System.out.println(person.getCard().getCode());
//        Clazz clazz = (Clazz) sqls.selectOne("ClazzMapper.selectClazzById",1);
//        List<Student> students = clazz.getStudents();
//        for(Student stu:students){
//            System.out.println(stu.toString());
//        }
        sqls.commit();
        sqls.close();




    }
}
