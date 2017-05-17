# webtest
simple SSM practice

说明：由于这两天有其他面试，所以只完成了Department部分的代码，如有需要，可继续更新

使用说明
1. 下载此项目。注意，由于使用maven管理依赖，所以需要联网下载jar包，请等待编译完成。
2. 使用本地mysql，用户名密码必须都为root，否则无法连接数据库
3. 请找到resource目录下的sql初始化脚本，在本地mysql中执行此脚本
4. 启动服务，使用postman调用相关接口

调用接口
1. 创建department
方式：POST 
URL：http://localhost:8080/webtest/v1/departments
Header：Content-Type ：application/json
Body：
{
	"name":"department001",
	"location":"location001",
	"openPositions":6
}

2. 获取所有department
方式：GET 
URL：http://localhost:8080/webtest/v1/departments/list
Header：Content-Type ：application/json

3. 根据department id查询详情
方式：GET 
URL：http://localhost:8080/webtest/v1/departments/details/3
Header：Content-Type ：application/json

4. 查询sub-department
方式：GET 
URL：http://localhost:8080/webtest/v1/departments/sub/3
Header：Content-Type ：application/json

5. 查询parent-department
方式：GET 
URL：http://localhost:8080/webtest/v1/departments/parent/4
Header：Content-Type ：application/json

6. 根据id删除 department
方式：DELETE
URL：http://localhost:8080/webtest/v1/departments/8
Header：Content-Type ：application/json

7. 更新department
方式：PUT
URL：http://localhost:8080/webtest/v1/departments
Header：Content-Type ：application/json
Body：
{
  "id":7
	"name":"department077",
	"location":"location077",
	"openPositions":8,
  "manager":0
}
