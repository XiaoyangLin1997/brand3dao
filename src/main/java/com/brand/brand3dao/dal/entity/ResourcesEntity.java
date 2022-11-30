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
@TableName("resources")
public class ResourcesEntity extends Model<ResourcesEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文字信息
     */
    private String post;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 视频地址
     */
    private String videoUrl;

    /**
     * 资源所有人
     */
    private Long userId;

    /**
     * 1.pending 待审批 2.minted 已通过 3.dismissed 拒绝
     */
    private Integer status;

    /**
     * 归属于对应slogan
     */
    private Long sloganId;


    public static final String ID = "id";

    public static final String POST = "post";

    public static final String IMAGE_URL = "image_url";

    public static final String VIDEO_URL = "video_url";

    public static final String USER_ID = "user_id";

    public static final String STATUS = "status";

    public static final String SLOGAN_ID = "slogan_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
