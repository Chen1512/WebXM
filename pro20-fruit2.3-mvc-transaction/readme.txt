review:
1. Servlet生命周期中的初始化方法： init() ， init(config)
   public void init(ServletConfig config) throws ServletException {
        this.config = config ;
        init();
   }
   因此，如果我们需要在初始化时执行一些自定义的操作，那么我们可以重写无参的init方法。
   我们可以通过getConfig()获取ServletConfig对象
   可以通过config.getInitParameter()获取初始化参数

2. 通过ServletContext获取配置的上下文参数

3. MVC ： V：view 视图 ； C：Controller 控制器  ； M：Model 模型
   模型有很多种类：数据访问模型（dao）；业务逻辑模型（BO）；值对象模型（POJO）；数据传输对象（DTO）

4. IOC
    IOC - 控制反转 / DI - 依赖注入
    控制反转：
    1) 之前在Servlet中，我们创建service对象 ， FruitService fruitService = new FruitServiceImpl();
       这句话如果出现在servlet中的某个方法内部，那么这个fruitService的作用域（生命周期）应该就是这个方法级别；
       如果这句话出现在servlet的类中，也就是说fruitService是一个成员变量，那么这个fruitService的作用域（生命周期）应该就是这个servlet实例级别
    2) 之后我们在applicationContext.xml中定义了这个fruitService。然后通过解析XML，产生fruitService实例，存放在beanMap中，这个beanMap在一个BeanFactory中
       因此，我们转移（改变）了之前的service实例、dao实例等等他们的生命周期。控制权从程序员转移到BeanFactory。这个现象我们称之为控制反转

    依赖注入：
    1) 之前我们在控制层出现代码：FruitService fruitService = new FruitServiceImpl()；
       那么，控制层和service层存在耦合。
    2) 之后，我们将代码修改成FruitService fruitService = null ;
       然后，在配置文件中配置:
       <bean id="fruit" class="FruitController">
            <property name="fruitService" ref="fruitService"/>
       </bean>

今日内容：
    1. 过滤器Filter
注释配置：
@WebFilter()
文件配置：
<filter-mapping>
    <filter-name>TargetChain03Filter</filter-name>
    <url-pattern>/Target05Servlet</url-pattern>
</filter-mapping>
<filter-mapping>
    <filter-name>TargetChain02Filter</filter-name>
    <url-pattern>/Target05Servlet</url-pattern>
</filter-mapping>
<filter-mapping>
    <filter-name>TargetChain01Filter</filter-name>
    <url-pattern>/Target05Servlet</url-pattern>
</filter-mapping>

    2. 事务管理(TransactionManager、ThreadLocal、OpenSessionInViewFilter)
    3. 监听器(Listener , ContextLoaderListener)

1. 过滤器Filter
1) Filter也属于Servlet规范
2) 














