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

## 编译问题

**编译问题：Lombok 生成的变量/方法及 MyBatis-Plus 注解在编译时丢失**

错误信息示例：
```
cannot find symbol: class TableId
cannot find symbol: variable IdType
cannot find symbol: class TableField
cannot find symbol: variable log
cannot find symbol: method getId()
```

原因分析：
- Lombok 1.18.x 版本与 JDK 25 不兼容
- MyBatis-Plus 注解（@TableId/@TableField/@IdType）处理器未能正确执行
- @Slf4j 生成的 log 变量不存在
- 自定义类（UserInfo/UserInfoView）可能也依赖 Lombok 生成的代码

建议解决方案：
1. 升级 Lombok 至 1.18.32+
2. 升级 MyBatis-Plus 至最新版本
3. 确保 maven-compiler-plugin 正确配置了 annotationProcessorPaths
4. 执行 `mvn clean compile` 清理后重试
5. 如使用 JDK 25，考虑降级至 JDK 21 或 17

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
