package com.springboot.ssm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_operation_log")
public class OperationLog {
    // 主键id
    @TableId(type = IdType.AUTO)
    private Integer id;
    // 请求方式
    private String httpMethod;
    // 请求地址
    private String uri;
    // 注解中定义的resouce
    private String resouce;
    // 参数及值
    private String paramJson;
    @Builder.Default
    private Integer status = 0;
    // 操作人id
    private Integer operationUserId;
    // 操作时间
    @Builder.Default
    private LocalDateTime operationTime = LocalDateTime.now();
}
