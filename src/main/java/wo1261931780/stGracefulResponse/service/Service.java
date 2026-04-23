package wo1261931780.stGracefulResponse.service;

import wo1261931780.stGracefulResponse.domain.Command;
import wo1261931780.stGracefulResponse.domain.Reponse;

/**
 * Created by Intellij IDEA.
 * Project:st-GracefulResponse
 * Package:wo1261931780.stGracefulResponse.service
 *
 * @author liujiajun_junw
 * @Date 2024-05-18-47  星期二
 * @Description 直接返回Reponse的Service
 */
public interface Service {
	Reponse commandMethod(Command command);
}
