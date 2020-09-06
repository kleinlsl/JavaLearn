package edu.xcu.Spring.SpringDI.annotation.service.impl;

import edu.xcu.Spring.SpringDI.annotation.dao.AccountDao;
import edu.xcu.Spring.SpringDI.annotation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 账户的业务层实现类
 *
 * 曾经XML的配置:
 *      <bean id="accountService" class="。。。"
 *          scope="" init-method="" destroy-method="">
 *          <property name="" value="" | ref=""></property>
 *      </bean>
 * 1、用于创建对象的:
 *      他们的作用就和在XMIL配置文件中编写一个<bean>标签实现的功能是一样的
 *
 *      @Component：
 *          作用：把当前类对象存入Spring容器中
 *          属性：
 *              value：用于指定bean中的id，当我们不写的时候，它默认的是类名首字母小写
 *       Controller
 *       Service
 *       Repository
 *       以上三个注解的作用和属性与Component是一摸一样的。
 *       他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层更加清晰。
 *
 * 2、用子注入数据的:
 *      他们的作用就和在xml配置文件中的bean标签中写一个<property>标签的作用是一样的
 *      Autowired:
 *          作用:自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *          出现位置：
 *              可以是变量上，也可以是方法上
 *          细节：
 *              在使用注解注入时，set方法就不是必须的了。
 *      Qualifier:
 *          作用:在按照类中注入的基础之上再按照名称注入。它在给类成员注入时不能单独使用。但是在给方法参数注
 *          属性:
 *              vaLue:用于指定注Abean的id。
 *      Resource
 *          作用:直接按照bean的id注入。它可以独立使用
 *          属性:
 *          name用于指定bear的id。
 *      以上三个注入都只能注入其他bean类型的数据，而基本类型和string类型无法使用上述注解实现。
 *      另外，集合类型的注入只能通过xL来实现。
 *
 *      Value
 *          作用:用于注入基本类型和String类型的数据
 *          属性:
 *          value:用于指定数据的值。它可以使用spring中SpEL(也就是spring的el表达式)
 *                  SpEL的写法:${表达式}
 * 3、用于改变作用范围的:
 *      他们的作用集合在bear标签中使用scope属性实现的功能是一样的
 *
 *      Scope
 *          作用:用于指定bean的作用范围
 *          属性:
 *              vaLue:指定范围的取值。常用取值:singLeton prototypd
 * 4、和生命周期相关：
 *      他们的作用就和在bean标签中使用init-method 和 destroy-method的作用一样
 *      PreDestroy
 *          作用:用于指定销毁方法
 *      PostConstruct
 *          作用:用于指定初始化方法
 */
@Component("accountService")
@Scope("singleton")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @PreDestroy
    public void destory(){
        System.out.println("销毁了");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化了");
    }
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
