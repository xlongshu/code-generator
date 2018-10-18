package replace_code;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * BaseDao 集成通用 Mapper
 *
 * @author LongShu 2018/02/01
 * @see tk.mybatis.mapper.common.BaseMapper
 * @see tk.mybatis.mapper.common.Mapper
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface BaseDao<T> extends
        Mapper<T>,
        MySqlMapper<T>,
        DaoMarker {

}
