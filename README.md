
#spring cloud组件 demo

端口
eureka-1            8080
eureka-1            8081
eureka-provider01   8002
eureka-provider02   8003
hystrix             8004
ribbon              8005
cloud_config_server 8006
cloud_config_client 8007



##ribbon:
生产使用ribbon,则需要每个服务都引入ribbon的相关依赖，并且配置注册中心，
调用服务时使用resttemplate进行远程调用，需要自定制负载均衡策略可以新建
类继承AbstractLoadBalancerRule，然后在自己注入。需要注意的是我们在定
制化规则类时，这个自定义的类不能放在@ComponentScan所扫描的当前包以及子
包下，否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就是
我们达不到特殊化指定的目的了。

##spring cloud config:
在微服务应用场景中，每个服务都要加载不同的配置，而当我们需要修改配置文件时,\
因为配置文件没有解耦，修改非常麻烦，或者如果线上环境多个微服务要修改，停掉大\
部分微服务太难受。这个时候引入spring cloud config。\
主要方便在于本地会使用远程仓库的配置文件，当我们需要修改配置文件时，我们可以直接\
在远程仓库修改配置文件，然后各个服务通过mq去订阅config server端，修改完成后\
config server端发出消息，订阅该消息的服务会去获取刷新的值，更新内存中配置文件对应\
的值。


