# Who will cares me

用uni-app框架编写的「谁会关心我？」的管理员界面，H5、小程序、APP三端均可运行。

![](https://tva1.sinaimg.cn/large/006y8mN6gy1g98531x91zj30950fudfu.jpg)

## 一、目录结构

```
- api 请求方法
- common colorUI样式文件及配置文件
- components 组件目录
- pages 页面目录
- static 静态资源目录
- store vuex
- utils 工具目录
	|- bobo-router 路由拦截器
	|- luch-request 请求拦截器
	|- Bmob-2.2.1.min.js 云数据库
	|- bmobUtil.js 云数据库操作工具类
	|- helper.js 全局工具类
	|- md5Util.js md5加密工具类
- main.js 入口文件
- manifast.json 项目配置信息
```

## 二、运行方式

1. 下载[HBuilderX](https://www.dcloud.io/hbuilderx.html)并安装
2. 用`HbuilderX`导入项目
3. 点击**播放图标**，选择在`Chrome中运行`或其他方式

## 三、项目说明

### 1、使用Bmob云数据库

> 我的使用场景：有一台国外的配置很低的服务器及国内的阿里云服务器，我的后端项目肯定是要放在阿里云上，但我的域名由于某种原因没有备案，所以不能直接访问。而使用ip地址又怕后面服务器地址变了造成不便。

针对上面的场景，我在bmob上建了一个数据库，保存自己的服务器地址信息，这样前端就可以通过这个云数据库得到我的服务器地址，进而访问到我的后端服务，大大降低了服务器迁移的风险。