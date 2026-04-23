package wo1261931780.stGracefulResponse.service.impl;

import jakarta.annotation.Resource;
import wo1261931780.stGracefulResponse.domain.Query;
import wo1261931780.stGracefulResponse.domain.TbUser;
import wo1261931780.stGracefulResponse.domain.UserInfoView;
import wo1261931780.stGracefulResponse.exception.NotFoundException;
import wo1261931780.stGracefulResponse.mapper.UserInfoMapper;
import wo1261931780.stGracefulResponse.service.QueryService;

import java.util.Objects;

/**
 * Created by Intellij IDEA.
 * Project:st-GracefulResponse
 * Package:wo1261931780.stGracefulResponse.service.impl
 *
 * @author liujiajun_junw
 * @Date 2024-05-18-48  星期二
 * @Description
 */
public class QueryServiceImpl implements QueryService {
	@Resource
	private UserInfoMapper mapper;

	public UserInfoView queryOne(Query query) {
		TbUser userInfo = mapper.selectById(query.getId());
		if (Objects.isNull(userInfo)) {
			// 这里直接抛自定义异常
			throw new NotFoundException();
		}
		//……后续业务操作
		return UserInfoView.builder()
				.id(userInfo.getId())
				.name(userInfo.getUsername())
				.username(userInfo.getUsername())
				.address(userInfo.getAddress())
				.build();
	}
}
