package com.brand.brand3dao.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("tag")
public class TagEntity extends Model<TagEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * tag字段
     */
    private String name;

    /**
     * nft地址
     */
    private String nftAddress;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 拥有者
     */
    private Long ownerId;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String NFT_ADDRESS = "nft_address";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String OWNER_ID = "owner_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
