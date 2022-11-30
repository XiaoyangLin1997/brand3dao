package com.brand.brand3dao.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Xiaoyang Lin
 * @since 2022-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("slogan_group")
public class SloganGroupEntity extends Model<SloganGroupEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private byte[] id;

    /**
     * slogan id
     */
    private Long sloganId;

    /**
     * 群组成员id
     */
    private Long menberId;


    public static final String ID = "id";

    public static final String SLOGAN_ID = "slogan_id";

    public static final String MENBER_ID = "menber_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
