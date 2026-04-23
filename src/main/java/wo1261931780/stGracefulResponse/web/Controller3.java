package wo1261931780.stGracefulResponse.web;

import wo1261931780.stGracefulResponse.domain.UserInfoView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Intellij IDEA.
 * Project:st-GracefulResponse
 * Package:wo1261931780.stGracefulResponse.web
 *
 * @author liujiajun_junw
 * @Date 2024-05-18-46  星期二
 * @Description
 */
@Controller
public class Controller3 {
	@RequestMapping("/get")
	@ResponseBody
	public UserInfoView get(Long id) {
		return UserInfoView.builder().id(id).name("name" + id).build();
	}
}
