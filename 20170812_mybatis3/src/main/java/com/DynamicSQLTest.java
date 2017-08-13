package com;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class DynamicSQLTest {

	public static void main(String[] args) throws Exception {
		// 读取mybatis-config.xml文件
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 初始化mybatis，创建SqlSessionFactory类的实例
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// 创建Session实例
		SqlSession session = sqlSessionFactory.openSession();
		DynamicSQLTest t = new DynamicSQLTest();
		t.testSelectEmployeeByIdLike(session);

		// 提交事务
		session.commit();
		// 关闭Session
		session.close();
	}
	
	// 测试<select id="selectEmployeeByIdLike" ...>
	public void testSelectEmployeeByIdLike(SqlSession session){
		// 获得EmployeeMapper接口的代理对象
		EmployeeMapper em = session.getMapper(EmployeeMapper.class);
		// 创建一个HashMap存储参数
		HashMap<String, Object> params = new HashMap<String, Object>();
		// 设置id属性
		//params.put("id", 1);
		// 调用EmployeeMapper接口的selectEmployeeByIdLike方法
		List<Employee> list = em.selectEmployeeByIdLike(params);
		// 查看返回结果
		for(Employee e:list)
        {
            System.out.println(e.toString());
        }
	}
	

	
	
	

}
