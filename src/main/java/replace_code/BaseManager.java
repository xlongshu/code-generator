package replace_code;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * BaseManager
 *
 * @author LongShu 2018/02/01
 */
@javax.inject.Named
public abstract class BaseManager<E extends BaseEntity> {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @javax.inject.Inject
    protected BaseDao<E> dao;

    public BaseDao<E> getDao() {
        return dao;
    }

    protected E preInsertEntry(E entity) {
        Date now = new Date();
        entity.setCreatedDate(now);
        entity.setYn(Boolean.TRUE);
        return entity;
    }


    protected E preInsert(E entity) {
        Date now = new Date();
        entity.setCreatedDate(now);
        entity.setYn(Boolean.TRUE);
        return entity;
    }

    //********************************************//

    @Transactional
    public int insert(E entity) {
        return dao.insert(preInsert(entity));
    }

    @Transactional
    public int insertSelective(E entity) {
        return dao.insertSelective(preInsert(entity));
    }

    @Transactional
    public int insertList(List<E> recordList) {
        for (E entity : recordList) {
            preInsert(entity);
        }
        return dao.insertList(recordList);
    }

    @Transactional
    public int insertOrUpdate(E entity) {
        Long id = entity.getId();

        int result;
        if (id != null && id > 0) {
            result = this.updateByKeySelective(entity);
        } else {
            result = this.insertSelective(entity);
        }
        return result;
    }

    //********************************************//

    @Transactional
    public int deleteByKey(E entity) {
        entity.setYn(Boolean.TRUE);
        return this.updateByKeySelective(entity);
        //return dao.deleteByPrimaryKey(entity);
    }

    //********************************************//

    @Transactional
    public int updateByKey(E entity) {
        return dao.updateByPrimaryKey(entity);
    }

    @Transactional
    public int updateByKeySelective(E entity) {
        return dao.updateByPrimaryKeySelective(entity);
    }

    //********************************************//

    public E selectOne(E entity) {
        PageHelper.offsetPage(0, 1, false);
        return dao.selectOne(entity);
    }

    public List<E> select(E entity) {
        return dao.select(entity);
    }

    public List<E> selectAll() {
        return dao.selectAll();
    }

    public E selectByKey(Serializable key) {
        return dao.selectByPrimaryKey(key);
    }

    public int selectCount(E condition) {
        return getDao().selectCount(condition);
    }

    //********************************************//

    public Page<E> selectPage(E condition, int pageNum, int pageSize) {
        // 物理分页, 包含count查询
        PageHelper.startPage(pageNum, pageSize);
        // list -> com.github.pagehelper.Page
        Page<E> page = (Page<E>) getDao().select(condition);
        return page;
    }

    public Page<E> selectPage(E condition, Page<E> page) {
        // 物理分页, 包含count查询
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.isCount());
        // list -> com.github.pagehelper.Page
        page = (Page<E>) getDao().select(condition);
        return page;
    }

    //********************************************//

    public int updateByCondition(E entity, Example condition) {
        return getDao().updateByExampleSelective(entity, condition);
    }

    public E selectOneByCondition(Example condition) {
        PageHelper.offsetPage(0, 1, false);
        return getDao().selectOneByExample(condition);
    }

    public List<E> selectByCondition(Example condition) {
        return getDao().selectByExample(condition);
    }

    public Page<E> selectPageByCondition(Example condition, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<E> page = (Page<E>) getDao().selectByExample(condition);
        return page;
    }

    public Page<E> selectPageByCondition(Example condition, Page<E> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.isCount());
        page = (Page<E>) getDao().selectByExample(condition);

        return page;
    }

    public int selectCountByCondition(Example condition) {
        return getDao().selectCountByExample(condition);
    }

}