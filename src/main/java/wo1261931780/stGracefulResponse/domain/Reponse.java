package wo1261931780.stGracefulResponse.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Intellij IDEA.
 * Project:st-GracefulResponse
 * Package:wo1261931780.stGracefulResponse.domain
 *
 * @author liujiajun_junw
 * @Date 2024-05-18-47  星期二
 * @Description 响应对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    private Object data;
}
