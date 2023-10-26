package org.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @projectName: SpringTransactionDemo1
 * @package: org.example.entity
 * @className: good
 * @author: lmj
 * @description: TODO
 * @date: 2023/10/12 0:01
 * @version: 1.0
 */
@TableName("good")
@Data
public class good {
    @TableId("id")
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("number")
    private Integer number;
}
