# test-GracefulResponse 项目规格说明书

## 1. 基本信息

| 项目名 | test-GracefulResponse |
|--------|----------------------|
| 路径 | /Users/junw/Documents/GitHub/test-GracefulResponse |
| 简介 | Graceful Response 统一响应框架测试项目，演示统一响应格式和异常处理 |
| 技术栈 | Spring Boot 3.4.4 + MyBatis-Plus 3.5.7 + Lombok 1.18.40 |
| License | AGPL-3.0 |
| Java | JDK 25 |

## 2. 功能概述

- 统一响应格式封装（Result/Reponse）
- 全局异常处理（GlobalExceptionHandler/NotFoundException）
- 参数校验（ValidationUtils）
- 响应增强（ResponseAdvice）
- 统一异常处理机制

## 3. 项目结构

```
src/main/java/wo1261931780/stGracefulResponse/
├── TestGracefulResponseApplication.java  # 启动类
├── domain/        # 实体类
│   ├── TbUser.java         # 用户实体
│   ├── UserInfoView.java   # 用户信息视图
│   ├── Query.java          # 查询条件对象
│   ├── Command.java        # 命令对象
│   └── Reponse.java        # 响应对象
├── service/      # 业务服务层
│   ├── QueryService.java           # 查询服务接口
│   ├── impl/QueryServiceImpl.java  # 查询服务实现
│   └── Service.java                # Service接口
├── mapper/      # 数据访问层
│   └── UserInfoMapper.java        # 用户Mapper（继承BaseMapper）
├── web/          # 控制器层
│   ├── Controller2.java  # 控制器2
│   └── Controller3.java  # 控制器3
├── config/      # 配置类
└── exception/  # 异常类
    └── NotFoundException.java
```

## 4. 核心组件

| 组件 | 说明 |
|------|------|
| Result<T>/Reponse | 统一响应包装类 |
| NotFoundException | 自定义异常 |
| GlobalExceptionHandler | 全局异常处理器 |
| ResponseAdvice | 响应增强 |
| ValidationUtils | 参数校验工具 |

## 5. 响应格式设计

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

## 6. 环境要求

- JDK 25
- Maven 3.6+

## 7. 升级记录

- 2026-04-23: 完整升级 Spring Boot 3.4.4, Java 25, Lombok 1.18.40, MyBatis-Plus 3.5.7-boot3
- 2026-04-23: 修复源码缺陷，创建缺失的 UserInfoView、Query、Command、Reponse 类
- 2026-04-23: 修复 QueryServiceImpl 使用 MyBatis-Plus 的 selectById 替代不存在的 findOne 方法
- 2026-04-23: 修复 insertOrUpdate 返回类型冲突（int → boolean）
- 2026-04-22: pom.xml 升级 Spring Boot 3.2.5→3.4.4, Java 17→21, Lombok 1.18.40, MyBatis-Plus 3.5.7-boot3
