package wo1261931780.stGracefulResponse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wo1261931780.stGracefulResponse.domain.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * Project:st-GracefulResponse
 * Package:wo1261931780.stGracefulResponse.mapper
 *
 * @author liujiajun_junw
 * @Date 2024-05-18-54  星期二
 * @Description
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<TbUser> {
    int updateBatch(List<TbUser> list);

    int updateBatchSelective(List<TbUser> list);

    int batchInsert(@Param("list") List<TbUser> list);

    boolean insertOrUpdate(TbUser record);

    int insertOrUpdateSelective(TbUser record);
}
