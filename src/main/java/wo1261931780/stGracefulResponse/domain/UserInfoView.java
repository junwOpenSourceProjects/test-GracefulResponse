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
 * @Date 2024-05-18-48  星期二
 * @Description 用户信息视图对象，用于返回给前端的用户数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoView implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String username;

    private String address;
}
