# Topdeck Go
> A program about hearthstone.

> PS:图片数据库已挂

![badge](https://img.shields.io/badge/SpringBoot-2.0.1-brightgreen)
![badge](https://img.shields.io/badge/redis-2.0.1-orange)
![badge](https://img.shields.io/badge/JPA-2.0.6-brightgreen)

## Quick Start
1. 运行topdeckgo.sql建立数据库
2. 运行topdeckgo.jar
3. 访问http://localhost:8080/topdeck/

## Environment
- JAVA 1.8
- Vue 2.x
- Mysql 5.7 

### Screenshots
![img](Screenshots/api.jpg "API一览")

![img](Screenshots/code.png "抽取代码")

![img](Screenshots/index.png "首页")

![img](Screenshots/draw.png "抽卡")

![img](Screenshots/data.png "所有卡牌")

![img](Screenshots/detail.png "卡牌信息")


## dev
> 项目采用前后端分离，SpringBoot提供API
1. 前端页面放在src\main\resources\static目录下。
    > vue + muse-ui
2. 数据库文件保存在根目录下，文件名为topdeckgo.sql
    > mysql
3. 直接用spring boot内置tomcat服务器启动即可，访问http://localhost:8080/topdeck/
