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
@TableName("slogan")
public class SloganEntity extends Model<SloganEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * slogan content
     */
    private String content;

    /**
     * slogan 名（群组名）
     */
    private String name;

    /**
     * slogan 发起用户id
     */
    private Long ownerId;

    /**
     * nft 地址
     */
    private String nftAddress;

    /**
     * 税率
     */
    private String nftTaxRate;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updetime;

    /**
     * 1.pending 待审批 2.minted 已通过 3.dismissed 拒绝
     */
    private Integer status;


    public static final String ID = "id";

    public static final String CONTENT = "content";

    public static final String NAME = "name";

    public static final String OWNER_ID = "owner_id";

    public static final String NFT_ADDRESS = "nft_address";

    public static final String NFT_TAX_RATE = "nft_tax_rate";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDETIME = "updetime";

    public static final String STATUS = "status";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
