# itoken

​		itoken项目是我学习过程中做的一个Spring Cloud Netflix 综合练习项目，主流框架都有涉及。该项目使用GitLab做代码管理，使用Nexus做依赖私服，使用Registry做Docker镜像私服，使用GitLab Runner做持续集成。

​		该项目所有的项目支撑性框架都使用linux 虚拟机docker容器的方式提供服务，大体的虚拟机结构如下：

​		![微信截图_20200825093013](https://pic.imgdb.cn/item/5f447a94160a154a67e8517d.png)

​		虚拟机说明如下：

| 虚拟机名称                                                   | 说明                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Ubuntu Server X64 Docker                                     | 基础Docker虚拟机，安装有Docker，并且换过阿里的源，用于创建新虚拟机克隆使用 |
| Ubuntu Server X64 Docker Nexus                               | Nexus服务器，依赖私服                                        |
| Ubuntu Server X64 Docker GitLab                              | GitLab服务器，代码管理，持续集成DevOps                       |
| Ubuntu Server X64 Docker Registry                            | Registry服务器，Docker镜像私服                               |
| Mysql + Nginx + FastDFS + RabbitMQ                           | 部署有多台Mysql，每个微服务一个Mysql；Nginx主要做项目的CDN；FastDFS 分布式文件管理；RabbitMQ消息队列服务端 |
| Ubuntu Server X64 Docker Service Cloud （eureka集群、config、redis集群） | 部署有3台 eureka，交叉注册做集群；config 分布式配置中心；3台 redis 和 3台 sentinel 做缓存集群 |
| Ubuntu Server X64 Docker Service Cloud 2（zipkin-admin-zull） | 部署有zipkin 链路追踪服务端；admin 服务监控服务端；zuul 网关 |

​		该项目的代码结构如下：

![微信截图_20200825095820](https://pic.imgdb.cn/item/5f447a94160a154a67e85188.png)

​	各项目说明如下：

| 项目名称                | 说明                                                         |
| ----------------------- | ------------------------------------------------------------ |
| itoken-dependencies     | 所有项目的父项目，主要管理依赖版本                           |
| itoken-config           | config配置中心，每个微服务的配置都由config管理，配合GitLab管理配置 |
| itoken-config-respo     | 存放所有微服务的配置文件                                     |
| itoken-eureka           | eureka 服务注册发现，每个微服务都要注册eureka                |
| itoken-zuul             | zuul 网关，路由管理，服务聚合                                |
| itoken-admin            | admin服务监控服务端，每个微服务都要接入admin                 |
| itoken-zipkin           | zipkin 链路追踪                                              |
| itoken-common           | 定义常量、定义通用dto、定义通用hystrix熔断方法、定义工具类等 |
| itoken-domain           | 定义通用的领域模型                                           |
| itoken-service          | 提供通用数据库访问服务、抽象CRUD                             |
| itoken-common-web       | 提供Web端通用服务，定义Web端常量，提供Web端工具类，提供通用、拦截器通用函数、通用服务消费者接口 |
| itoken-service-admin    | 后台管理服务提供者，一个业务 service端demo                   |
| itoken-service-posts    | 文章服务提供者，也是一个业务 service端demo                   |
| itoken-service-quartz   | 任务调度服务提供者                                           |
| itoken-service-redis    | redis服务提供者                                              |
| itoken-service-sso      | sso服务提供者                                                |
| itoken-service-upload   | FastDFS服务提供者                                            |
| itoken-service-rabbitmq | rabbitmq 消息队列服务提供者                                  |
| itoken-web-admin        | 管理后台前端服务，一个业务web 端demo                         |
| itoken-web-posts        | 文章管理前端服务，也是一个业务web 端demo                     |
| itoken-web-backend      | 前端聚合服务，用zuul把admin和posts聚合在一起                 |
