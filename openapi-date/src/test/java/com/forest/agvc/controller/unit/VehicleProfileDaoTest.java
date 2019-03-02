package com.forest.agvc.controller.unit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.forest.agvc.datasource.entity.VehicleProfileDao;
import com.forest.agvc.datasource.mapper.VehicleMapper;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author forestyang
 * @date 2019-02-12
 */
@DisplayName("Vehicle profile unit test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class VehicleProfileDaoTest {

    @Autowired
    private VehicleMapper vehicleMapper;

    @Test
    void testSelect() {
        List<VehicleProfileDao> vehicles = vehicleMapper.selectList(null);
        assertTrue(!vehicles.isEmpty());
    }
}
