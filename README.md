
#spring cloud组件 demo

端口
eureka-1            8080
eureka-1            8081
eureka-provider01   8002
eureka-provider02   8003
hystrix             8004
ribbon              8005

ribbon:
生产使用ribbon,则需要每个服务都引入ribbon的相关依赖，并且配置注册中心，
调用服务时使用resttemplate进行远程调用，需要自定制负载均衡策略可以新建
类继承AbstractLoadBalancerRule，然后在自己注入。需要注意的是我们在定
制化规则类时，这个自定义的类不能放在@ComponentScan所扫描的当前包以及子
包下，否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就是
我们达不到特殊化指定的目的了。