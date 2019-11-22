# Who will cares me

用SpringBoot框架搭建的项目。

## 一、目录结构

```
- java.com.aqzscn.lonely java代码
    ｜- controller 控制器
        |- DashboardController.java 仪表盘相关请求
    ｜- handler 拦截器
        |- AuthenticationFilter.java 用户鉴权过滤器
        |- CORSFilter.java 允许CORS请求
        |- ExceptionAdvice.java 全局异常处理类
        |- JsonResponseAdvice.java 自动包装响应体
        |- LogAspect.java 请求和响应的日志记录
        |- SystemInitializer.java 系统启动时的初始化工作
    |- mapper dao层
    |- service 服务层
    |- utils 工具包
    |- vo
        |- AppException.java 自定义异常类
        |- GlobalCaches.java 全局变量
        |- GlobalNames.java 全局常量
        |- ReturnVo.java 返回体
    |- LonelyApplication 启动类
- resources
    |- application*.yml 配置文件
```