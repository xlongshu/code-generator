package replace_code;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * BaseEntity
 *
 * @author LongShu 2018/02/01
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
@lombok.NoArgsConstructor
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * <pre>
     * 1.全部数据库通用的@GeneratedValue(META-INF="UUID")
     * 2.useGeneratedKeys的@GeneratedValue(META-INF="JDBC")
     * 3.类似mysql数据库的@GeneratedValue(strategy=GenerationType.IDENTITY[,META-INF="Mysql"])
     * </pre>
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    protected Long id;
    /**
     * 是否有效
     */
    @Column(name = "yn")
    protected Boolean yn = Boolean.TRUE;
    /**
     * 创建时间
     */
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;
    /**
     * 更新时间
     */
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date modifiedDate;
    /**
     * 备注
     */
    @Column(name = "remark")
    protected String remark;

}
