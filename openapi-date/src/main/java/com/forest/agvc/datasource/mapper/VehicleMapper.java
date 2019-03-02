package com.forest.agvc.datasource.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.forest.agvc.datasource.entity.VehicleProfileDao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 * @author forestyang
 * @date 2019-02-12
 */
@Component(value = "vehicleMapper")
public interface VehicleMapper extends BaseMapper<VehicleProfileDao> {

  default Optional<VehicleProfileDao> selectByDeviceId(String deviceId) {
    List<VehicleProfileDao> vehicleProfileDaoLists = selectList(
        new QueryWrapper<VehicleProfileDao>().lambda()
            .eq(VehicleProfileDao::getDeviceId, deviceId));
    if (vehicleProfileDaoLists != null && !vehicleProfileDaoLists.isEmpty()) {
      return Optional.of(vehicleProfileDaoLists.get(0));
    } else {
      return Optional.empty();
    }

  }
}
