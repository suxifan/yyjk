# yyjk_yb

本项目为前后端分离的Web应用后端程序，采用技术框架如下：
1. springboot 1.5.18.RELEASE
2. mybatis 3.4.5 及pagehelper分页插件
3. jwt 3.2.0
4. es  2.2.0
5. websocket  消息实时推送
6. 数据库：postgresql
7. java编译环境jkd1.8

代码生成器：
1. 采用Freemarker模板代码生成器组件生成系统基础代码，运行后基础的curd代码已经全部自动生成，只需要编写特殊的业务逻辑代码

该版本没有实现
1.使用jwt采用token有效期内刷新机制更新Token。

注意事项：
创建模块时，文件夹要以com.cictec.yyjk.**形式命名，因为整个mybatis配置的扫描路径为 
com.cictec.yyjk.**.entity，
com.cictec.yyjk.**.mapper