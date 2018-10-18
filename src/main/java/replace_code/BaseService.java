package replace_code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService
 *
 * @author LongShu 2018/02/01
 */
@javax.inject.Named
public abstract class BaseService<M extends BaseManager<E>, E extends BaseEntity> {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @javax.inject.Inject
    protected M manager;

    public M getManager() {
        return manager;
    }


    //********************************************//

    @Transactional
    public int insert(E entity) {
        return manager.insert(entity);
    }

    @Transactional
    public int insertSelective(E entity) {
        return manager.insertSelective(entity);
    }

    @Transactional
    public int insertList(List<E> recordList) {
        return manager.insertList(recordList);
    }

    @Transactional
    public int insertOrUpdate(E entity) {
        return getManager().insertOrUpdate(entity);
    }

    //********************************************//

    @Transactional
    public int deleteByKey(E entity) {
        return manager.deleteByKey(entity);
    }

    //********************************************//

    @Transactional
    public int updateByKey(E entity) {
        return manager.updateByKey(entity);
    }

    @Transactional
    public int updateByKeySelective(E entity) {
        return manager.updateByKeySelective(entity);
    }

    //********************************************//

    public E selectOne(E entity) {
        return manager.selectOne(entity);
    }

    public List<E> select(E entity) {
        return manager.select(entity);
    }

    public List<E> selectAll() {
        return manager.selectAll();
    }

    public E selectByKey(Serializable key) {
        return manager.selectByKey(key);
    }

    public int selectCount(E condition) {
        return getManager().selectCount(condition);
    }

}