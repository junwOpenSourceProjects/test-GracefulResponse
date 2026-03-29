# 🎯 test-GracefulResponse - 优雅响应框架测试

![Java](https://img.shields.io/badge/Java-17+-orange?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![License](https://img.shields.io/badge/License-AGPL--3.0-blue)

## 📖 项目简介

test-GracefulResponse是Graceful Response框架的测试项目,演示如何使用Graceful Response实现统一响应格式、异常处理、参数校验等功能。

## 🏗️ 系统架构

```mermaid
graph TB
    subgraph "请求层"
        Client[客户端请求]
        Controller[控制器]
    end
    
    subgraph "响应处理层"
        ResponseAdvice[响应增强]
        ResultWrapper[结果包装]
        ExceptionHandler[异常处理]
    end
    
    subgraph "业务层"
        Service[业务服务]
        Validator[参数校验]
    end
    
    subgraph "响应格式"
        SuccessResponse[成功响应]
        ErrorResponse[错误响应]
        PageResponse[分页响应]
    end
    
    Client --> Controller
    Controller --> Validator
    Validator --> Service
    
    Service --> ResponseAdvice
    ResponseAdvice --> ResultWrapper
    
    Controller --> ExceptionHandler
    ExceptionHandler --> ErrorResponse
    
    ResultWrapper --> SuccessResponse
    ResultWrapper --> PageResponse
```

## 🚀 快速开始

```bash
# 克隆项目
git clone https://github.com/yourusername/test-GracefulResponse.git

# 运行项目
mvn spring-boot:run

# 访问测试
curl http://localhost:8080/api/test
```

## 💡 核心示例

### 统一响应格式

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    private Long timestamp;
    
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data, System.currentTimeMillis());
    }
    
    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message, null, System.currentTimeMillis());
    }
}
```

### 全局异常处理

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BusinessException.class)
    public Result<Void> handleBusinessException(BusinessException e) {
        return Result.error(e.getCode(), e.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e) {
        return Result.error(500, "系统错误");
    }
}
```

## 📝 更新日志

### v1.0.0 (2024-01-01)
- ✨ 初始版本发布
- ✨ 完成统一响应格式
- ✨ 完成全局异常处理

---

⭐ 如果这个项目对你有帮助,欢迎Star支持!
