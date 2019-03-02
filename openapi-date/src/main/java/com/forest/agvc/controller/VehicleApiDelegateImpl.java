package com.forest.agvc.controller;


import com.forest.agvc.api.VehicleApiDelegate;
import com.forest.agvc.common.ApiResult;
import com.forest.agvc.datasource.entity.VehicleProfileDao;
import com.forest.agvc.datasource.mapper.VehicleMapper;
import com.forest.agvc.model.Result;
import com.forest.agvc.model.Vehicle;
import com.forest.agvc.model.VehicleResponse;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Collections;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author forestyang
 * @date 2019-02-14
 */
@Service
public class VehicleApiDelegateImpl implements VehicleApiDelegate {

  private VehicleMapper vehicleMapper;

  private ModelMapper modelMapper;

  @Autowired
  public VehicleApiDelegateImpl(VehicleMapper vehicleMapper,
      ModelMapper modelMapper) {
    this.vehicleMapper = vehicleMapper;
    this.modelMapper = modelMapper;
  }

  @Override
  public ResponseEntity<Result> createVehicle(Vehicle vehicle) {
    vehicleMapper.insert(convertTo(vehicle));
    return new ResponseEntity<>(ApiResult.HTTP_RESULT_SUCCESS, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<VehicleResponse> getVehicleById(String id) {
    VehicleProfileDao v = vehicleMapper.selectById(id);
    return (v == null) ?
        new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(convertTo(v), HttpStatus.OK);
  }

  private VehicleResponse convertTo(VehicleProfileDao vehicleProfileDao) {
    Vehicle vehicle = modelMapper.map(vehicleProfileDao, Vehicle.class);

    LocalDateTime createTime =vehicleProfileDao.getCreateTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    vehicle.setCreateTime(OffsetDateTime.of(createTime, ZoneOffset.UTC));

    LocalDateTime updateTime =vehicleProfileDao.getCreateTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    vehicle.setUpdateTime(OffsetDateTime.of(updateTime, ZoneOffset.UTC));

    VehicleResponse vehicleResponse = new VehicleResponse();
    vehicleResponse.setData(Collections.singletonList(vehicle));
    vehicleResponse.setResult(ApiResult.HTTP_RESULT_SUCCESS);
    return vehicleResponse;
  }

  private VehicleProfileDao convertTo(Vehicle vehicle) {
    return modelMapper.map(vehicle, VehicleProfileDao.class);
  }

}
