package wo1261931780.stGracefulResponse.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Intellij IDEA.
 * Project:st-GracefulResponse
 * Package:wo1261931780.stGracefulResponse.domain
 *
 * @author liujiajun_junw
 * @Date 2024-05-18-47  星期二
 * @Description 命令对象
 */
@Data
public class Command implements Serializable {
    private static final long serialVersionUID = 1L;

    private String type;

    private String payload;
}
