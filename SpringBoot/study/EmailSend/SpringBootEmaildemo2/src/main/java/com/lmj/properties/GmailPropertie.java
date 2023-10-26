package com.lmj.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @projectName: SpringBootEmaildemo2
 * @package: com.lmj.properties
 * @className: GmailPropertie
 * @author: lmj
 * @description: TODO
 * @date: 2023/10/19 14:13
 * @version: 1.0
 */

@Component
@ConfigurationProperties(value = "gmail.smtp")
public class GmailPropertie implements Serializable {
    /** 邮箱名称 */
    private String name;

    /** SMTP服务 */
    private String host;

    /** 端口 */
    private Integer port;

    /** 账号 */
    private String username;

    /** 密码 */
    private String password;

    /** 是否开启debug） */
    private Boolean debug;

    /** 启用SSL */
    private Boolean enableSsl;
}
