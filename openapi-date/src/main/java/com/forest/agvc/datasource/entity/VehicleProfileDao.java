package com.forest.agvc.datasource.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author forestyang
 * @date 2/11/2019
 */
@Data
@TableName(value = "atc_vehicle_profile")
public class VehicleProfileDao {
    private long id;
    private String deviceId;
    private String agvIp;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
