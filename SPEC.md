# 项目规格说明书 - test-GracefulResponse

## 基本信息

| 项目名 | test-GracefulResponse |
|--------|----------------------|
| 路径 | /Users/junw/Documents/GitHub/test-GracefulResponse |
| 简介 | Graceful Response 框架测试项目，演示统一响应格式和异常处理 |
| 技术栈 | Spring Boot 3.x + Graceful Response + Lombok |
| License | AGPL-3.0 |

## 功能概述

- 统一响应格式封装
- 全局异常处理
- 参数校验
- 响应增强（ResponseAdvice）

## 项目结构

```
src/main/java/wo1261931780/stGracefulResponse/
├── TestGracefulResponseApplication.java  # 启动类
├── domain/        # 实体类（TbUser 等）
├── service/      # 业务服务层
├── web/          # 控制器层
└── config/      # 配置类
```

## 核心组件

| 组件 | 说明 |
|------|------|
| Result<T> | 统一响应包装类 |
| GlobalExceptionHandler | 全局异常处理器 |
| ResponseAdvice | 响应增强 |
| ValidationUtils | 参数校验工具 |

## 升级记录

- 2026-04-22: pom.xml 升级 Spring Boot 3.2.5→3.4.4, Java 17→21, Lombok 1.18.40, MyBatis-Plus 3.5.7-boot3, 配置 annotationProcessorPaths
- 2026-04-22: 源码引用了不存在的类（UserInfoView、Query），仓库本身代码不完整，无法编译

## 编译问题

**pom.xml 已修复，但源码存在不完整引用，无法编译通过**

源码缺少以下类定义：
```
src/main/java/wo1261931780/stGracefulResponse/web/Controller3.java:20 - UserInfoView (不存在)
src/main/java/wo1261931780/stGracefulResponse/service/QueryService.java:15 - UserInfoView (不存在)
src/main/java/wo1261931780/stGracefulResponse/service/QueryService.java:15 - Query (不存在)
src/main/java/wo1261931780/stGracefulResponse/service/impl/QueryServiceImpl.java:23 - UserInfoView, Query (不存在)
src/main/java/wo1261931780/stGracefulResponse/service/impl/QueryServiceImpl.java:21 - UserInfoMapper (缺少 mybatis-plus 依赖)
```

pom.xml 中已添加 mybatis-plus-spring-boot3-starter 依赖，理论上 UserInfoMapper 应继承 BaseMapper<TbUser> 可正常工作，但 UserInfoView 和 Query 类从未创建，属于仓库源码缺陷。

## 响应格式设计

### 成功响应
```json
{
  "code": 200,
  "message": "success",
  "data": { ... },
  "timestamp": 1704067200000
}
```

### 错误响应
```json
{
  "code": 500,
  "message": "系统错误",
  "data": null,
  "timestamp": 1704067200000
}
```

## 环境要求

- JDK 17+（JDK 25 存在 Lombok 兼容问题）
- Maven 3.6+
