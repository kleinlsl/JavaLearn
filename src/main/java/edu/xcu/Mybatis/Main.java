package edu.xcu.Mybatis;

import edu.xcu.Mybatis.bean.User;
import edu.xcu.Mybatis.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @project: JavaThread
 * @description:
 * @author: dell
 * @date: 2020/8/2 - 12:17
 */
public class Main {
    public static void main(String[] args) throws IOException {
    // 1、读取配置文件
        InputStream in= Resources.getResourceAsStream("Mybatis/mybstis-cof.xml");
    // 2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=  sqlSessionFactoryBuilder.build(in);
    // 3、获取SqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();
    // 4、使用SqlSession创建Dao接口的代理对象
        UserDao userDao=sqlSession.getMapper(UserDao.class);
    // 5、使用代理对象执行方法
        List<User> list=userDao.findAll();
        for (User u:list
             ) {
            System.out.println(u);
        }
    // 6、释放资源
        sqlSession.commit();
        sqlSession.close();
    }
}
