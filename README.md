## SpringCloud商城项目

```
项目介绍：模拟一般商城的基本功能，实现了商城的基本模块开发，如：商家模块，订单模块，支付模块，频道页模块，商品模块，商品详情页模块，用户模块等。


    核心框架：SpringBoot SpringCloud 
    持久层框架：Mybatis Mybatis_PageHelper
    数据库连接池：Alibaba Druid
    安全：JWT进行用户身份的判定
    第三方技术：redis，solr，rabbitmq，fastfds
    
```      

```
|
|---zhangyangadmin-------------------简单后台管理模块
|---zhangyangcloudserver----------------Eureka注册中心
|---zhangyangcommon------------------商品公共信息抽取模块
|---zhangyangorder------------------订单模块
|---zhangyangpayserv-----------------支付模块（微信支付）
|---zhangyangpindaoindex-------------------频道页模块
|---zhangyangproduct------------------商品模块
|---zhangyangproductproducttype---------------商品类型模块
|---zhangyangquartservice-------------------quart定时任务模块
|---zhangyangredisserver------------------redis缓存模块
|---zhangyangshopuser-------------------用户模块
|---zhangyangmerchat-----------------------商家模块
|---zhangyangrobbinserver--------------------负载均衡模块
|---zhangyangmsgqueueserv----------------------mq消息队列模块

```

### 模块内容介绍：  
用户模块：  
对用户表的中的用户及用户个人信息进行的增删改查的操作   
商品类别模块：  
主要包含商品类别的多级类别添加和商品类别信息的增删改查操作  
商家模块：  
主要包含商家服务的入驻功能，查看修改商家信息，管理员审核和下架商家等功能。  
商品模块：  
商品服务包含商家发布商品，管理员审核商品，商家管理商品信息，商家上架和下架商品等功能。  
订单模块：  
订单服务包含商家订单管理，用户下订单，用户订单信息修改等。  
支付模块：  
支付模块采用微信支付，详情如下：http://zhang19980825.top/2019/02/17/%E5%BE%AE%E4%BF%A1%E6%94%AF%E4%BB%98/    
频道模块：  
频道服务包含用户注册，登录的部分，用户登录的时候，采用用户名密码登录和微信登录两种方式，两种都使用了JWT进行用户身份的验证。微信登录详情：http://zhang19980825.top/2019/02/15/JWT+%E5%BE%AE%E4%BF%A1%E7%99%BB%E5%BD%95/ ，产品服务的调用，支付服务的调用，搜索服务的调用及其他服务的调用。  
后台管理模块：  
后台管理主要进行商品详情，商品分类，和对商品和商品类别进行管理的功能。


### 技术的应用：  
redis:redis的话主要对商品进行了一个缓存操作，在进行商品的添加操作时在redis中进行缓存，但随之而来的话就会出现redis和数据库的缓存一致性问题。  
解决：商品进行添加的时候先更新数据库再更新缓存，使用quart定时任务，这个是在zhangyangquartservice模块，商品更新操作会在每30秒进行更新，每30秒从数据库取出商品来进行redis缓存的更新。  
rabbitmq：rabbitmq主要用于订单模块的优化，用户在生成订单的时候把订单实体类放在mq中，实现订单的异步保存。其中采用Fanout的Exchange模式。具体代码在zhangyangmsgqueueserv的msg包中。其中使用一个数据库表表名消息的状态1未发送，2，已发送，3发送失败4,消费者未接受 5，消费成功，6消费失败，发送时间等信息。来保证消息的最终一致性。为了保证消息的可靠性，定时任务会每30秒进行数据库中的消息表进行读取会根据消息的类型和消息在mq中存活的时间会对消息进行一个重新发送。但是在发送的时候为了保证消息的幂等性，幂等性就是对消息接收方来说的，在接收到消息之后会进行一个订单业务逻辑的判断，判断的标准是查询mq中订单实体的交易流水号,如果订单流水号存在不会进行再次消费。  
solr：solr的话主要用于商品的站内搜索,solr和es安装教程如下：https://blog.csdn.net/zhangyang199808/article/details/90348895 主要使用就是在solr的scheml.xml文件中加入商品某些属性加入field域里面，我是以商品的id和title为索引添加的，然后在添加商品的时候进行索引的添加。  
fastdfs：文件存储服务器   搭建教程如下：  
https://blog.csdn.net/zhangyang199808/article/details/89816757  
fastdfs原理分析：https://blog.csdn.net/zhangyang199808/article/details/89816764

其中也有对SpringCloud的负载均衡和服务熔断进行了简单使用
