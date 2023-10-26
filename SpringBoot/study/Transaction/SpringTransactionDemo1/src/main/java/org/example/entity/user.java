package org.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @projectName: SpringTransactionDemo1
 * @package: org.example.entity
 * @className: user
 * @author: lmj
 * @description: TODO
 * @date: 2023/10/11 23:59
 * @version: 1.0
 */
@TableName("user")
@Data
public class user {
    @TableId("id")
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("money")
    private Integer money;
}
