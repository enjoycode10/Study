可能遇到的问题：
* 配置文件没有注册
* 绑定接口错误(namespace中的包名要和mapper接口的包名一致)
* 方法名不对
* 返回类型不对
* maven到处资源出错

如果实体类或数据库表的字段参数很多，可以考虑使用Map:
* 只有一个基本类型参数，直接在sql中取出（可以不定义参数类型）
* map传递参数，直接在sql中取出key即可
* 对象传递参数，直接在sql中取出对象的属性即可
* 多个参数用**map或者注解**

### mybatis执行流程
    1. resources获取加载全局配置文件
    2. 实例化SqlSessionFactoryBuilder构造器
    3. 解析配置文件流XMLConfigBuilder
    4. Configuration配置所有参数
    5. SqlSessionFactory实例化
    6. transaction管理器
    7. 创建executor执行器
    8. 实现crud(结合step6)
    9. 执行成功，关闭SqlSession
    
### 注解开发
    1. mybatis-config.xml 中绑定接口class类型
    2. sqlSessionFactory.openSession(true); 开启自动化事务管理
    3. 基本类型的入参要加@Param，引用类型不用
    4. #{}当成字符串来解析，可以防SQL注入，如role_id = "roleid" 
       ${}直接显示在sql中，无法防止SQL注入，如role_id = reoleid
       
### 多表查询
    关联 - association 【多对一】
    集合 - collection 【一对多】
    javaType：用来指定实体类中属性的类型
    ofType：用来指定映射到List或者集合中的pojo类型，泛型中的约束类型
    
    Mysql引擎，innoDB底层原理，索引，索引优化