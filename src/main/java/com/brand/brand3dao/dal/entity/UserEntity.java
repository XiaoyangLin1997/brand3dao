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
@TableName("user")
public class UserEntity extends Model<UserEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 钱包地址
     */
    private String publicAddress;

    /**
     * 用户验证
     */
    private String nonce;


    public static final String ID = "id";

    public static final String USER_NAME = "user_name";

    public static final String PUBLIC_ADDRESS = "public_address";

    public static final String NONCE = "nonce";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
