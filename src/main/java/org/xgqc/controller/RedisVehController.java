package org.xgqc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xgqc.entity.CanRedisData;
import org.xgqc.entity.GPSRedisData;
import org.xgqc.entity.VehicleData;
import org.xgqc.pojo.RateLimit;
import org.xgqc.pojo.RateLimit.LimitType;
import org.xgqc.response.R;
import org.xgqc.service.IRedisVehService;

@RestController
@Tag(name = "Redis车辆数据接口", description = "包含车辆实时整车数据、定位数据、DBC数据，支持在线调试")
@RequestMapping({"/api/32960"})
public class RedisVehController {
    @Autowired
    private IRedisVehService redisService;
    private static final Logger logger = LoggerFactory.getLogger(RedisVehController.class);

    public RedisVehController() {
    }

    @Operation(summary = "获取车辆实时整车数据")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功获取车辆整车数据"),
            @ApiResponse(responseCode = "400", description = "请求参数错误"),
            @ApiResponse(responseCode = "500", description = "服务器内部错误")
    })
    @RateLimit(
            time = 1,
            count = 10,
            limitType = LimitType.IP
    )
    @GetMapping({"/veh"})
    public R getRealVehData(
            @Parameter(description = "车辆识别码（VIN）", required = true)
            @RequestParam("vin") String vin) {
        R validationResult = this.validateRequest(vin);
        if (validationResult != null) {
            return validationResult;
        } else {
            VehicleData result = null;

            try {
                result = this.redisService.getVehicleData(vin);
                if (result != null) {
                    result.setVin(vin);
                }
            } catch (Exception e) {
                logger.error("获取VIN: {}的整车数据时发生异常", vin, e);
            }

            logger.info("车辆最新整车数据 - 响应数据: {}", result);
            return R.success(result);
        }
    }

    @Operation(summary = "获取车辆实时定位数据")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功获取车辆定位数据"),
            @ApiResponse(responseCode = "400", description = "请求参数错误"),
            @ApiResponse(responseCode = "500", description = "服务器内部错误")
    })
    @RateLimit(
            time = 1,
            count = 10,
            limitType = LimitType.IP
    )
    @GetMapping({"/gps"})
    public R getRealGPSData(@RequestParam("vin") String vin) {
        R validationResult = this.validateRequest(vin);
        if (validationResult != null) {
            return validationResult;
        } else {
            GPSRedisData result = null;

            try {
                result = this.redisService.getGPSValue(vin);
                if (result != null) {
                    result.setVin(vin);
                }
            } catch (Exception e) {
                logger.error("获取VIN: {}的GPS数据时发生异常", vin, e);
            }

            logger.info("车辆最新GPS数据 - 响应数据: {}", result);
            return R.success(result);
        }
    }

    @Operation(summary = "获取车辆实时DBC数据")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功获取车辆DBC数据"),
            @ApiResponse(responseCode = "400", description = "请求参数错误"),
            @ApiResponse(responseCode = "500", description = "服务器内部错误")
    })
    @RateLimit(
            time = 1,
            count = 10,
            limitType = LimitType.IP
    )
    @GetMapping({"/dbc"})
    public R getRealCanData(
            @Parameter(description = "车辆识别码（VIN）", required = true)
            @RequestParam("vin") String vin) {
        R validationResult = this.validateRequest(vin);
        if (validationResult != null) {
            return validationResult;
        } else {
            CanRedisData result = null;

            try {
                result = this.redisService.getCanValue(vin);
                if (result != null) {
                    result.setVin(vin);
                }
            } catch (Exception e) {
                logger.error("获取VIN: {}的CAN数据时发生异常", vin, e);
            }

            logger.info("车辆最新DBC数据 - 响应数据: {}", result);
            return R.success(result);
        }
    }

    private R validateRequest(String vin) {
        if (vin != null && !vin.trim().isEmpty()) {
            String cleanedVin = vin.trim();
            if (cleanedVin.length() != 17) {
                return R.fail("VIN码必须为17位，当前为: " + cleanedVin.length() + "位");
            } else {
                return !cleanedVin.matches("^[A-HJ-NPR-Z0-9]{17}$") ? R.fail("VIN码格式错误，包含无效字符: " + cleanedVin) : null;
            }
        } else {
            return R.fail("VIN不能为空");
        }
    }
}
