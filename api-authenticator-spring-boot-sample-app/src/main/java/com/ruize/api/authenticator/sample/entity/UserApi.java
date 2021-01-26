package com.ruize.api.authenticator.sample.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author Lory
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserApi implements Serializable {


    @TableId("KEY_GID")
    private String keyGid;

    @TableField("KEY_ID")
    private String keyId;

    @TableField("APIKEY")
    private String apikey;

    @TableField("TTID")
    private String ttid;

    @TableField("CREATED_DATE")
    private LocalDateTime createdDate;


}
