package replace_code;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * BaseMapper 集成通用 Mapper
 *
 * @author LongShu 2018/02/01
 * @see tk.mybatis.mapper.common.BaseMapper
 * @see tk.mybatis.mapper.common.Mapper
 */
public interface BaseMapper<T> extends
        Mapper<T>,
        SelectByIdsMapper<T>,
        MySqlMapper<T>,
        MapperMarker {

}
