package org.xgqc.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.codec.DecoderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.xgqc.entity.CanRedisData;
import org.xgqc.entity.GPSRedisData;
import org.xgqc.entity.VehicleData;
import org.xgqc.service.IRedisVehService;
import org.xgqc.util.ParseRedisVehicle;
import org.xgqc.util.parseGeoLocationUtil;
import org.xgqc.util.canParseUtil.CanDataParser;
import org.xgqc.util.canParseUtil.CanParserFactory;

@Service
public class RedisVehServiceImpl implements IRedisVehService {

    @Autowired
    @Qualifier("binaryRedisTemplate")
    private RedisTemplate<String, byte[]> redisBinaryTemplate;

    @Autowired
    private StringRedisTemplate redisStringTemplate;

    private final CanParserFactory parserFactory;

    // 日志对象（类名作为 Logger 名称，便于定位）
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisVehServiceImpl.class);

    public RedisVehServiceImpl(CanParserFactory parserFactory) {
        this.parserFactory = parserFactory;
    }

    @Override
    public VehicleData getVehicleData(String vin) {
        LOGGER.info("开始获取车辆数据，VIN: {}", vin);
        String dataNumber = this.getDataNumber(vin);
        if (dataNumber == null) {
            LOGGER.warn("未找到 VIN={} 对应的 dataNumber，返回 null", vin);
            return null;
        } else {
            String key = "g." + dataNumber + ".xny.watch";
            LOGGER.debug("尝试从 Redis 获取二进制数据，Key: {}", key);
            byte[] value = (byte[]) this.redisBinaryTemplate.opsForValue().get(key);
            if (value == null) {
                LOGGER.warn("Redis 中未找到 Key={} 对应的车辆数据，VIN={}", key, vin);
                return null;
            } else {
                LOGGER.debug("成功从 Redis 获取车辆二进制数据，Key={}, 数据长度={}", key, value.length);
                VehicleData vehicleData = ParseRedisVehicle.parseVehicleData(value);
                LOGGER.debug("成功解析 VehicleData，VIN={}", vin);

                parseGeoLocationUtil.DetailedAddressInfo vehGeoInfo = parseGeoLocationUtil
                        .convertToDetailedAddress(vehicleData.getLongitude(), vehicleData.getLatitude());
                if (vehGeoInfo != null) {
                    vehicleData.setFormattedAddress(vehGeoInfo.getFormattedAddress());
                    vehicleData.setProvince(vehGeoInfo.getProvince());
                    vehicleData.setCity(vehGeoInfo.getCity());
                    vehicleData.setDistrict(vehGeoInfo.getDistrict());
                    vehicleData.setTownship(vehGeoInfo.getTownship());
                    vehicleData.setStreet(vehGeoInfo.getStreet());
                    vehicleData.setStreetNumber(vehGeoInfo.getStreetNumber());
                    LOGGER.debug("成功设置车辆详细地址信息，VIN={}", vin);
                } else {
                    vehicleData.setFormattedAddress("地址解析失败");
                    LOGGER.warn("地址解析失败，VIN={}, 经度={}, 纬度={}", vin, vehicleData.getLongitude(), vehicleData.getLatitude());
                }

                return vehicleData;
            }
        }
    }

    @Override
    public GPSRedisData getGPSValue(String vin) {
        LOGGER.info("开始获取车辆GPS数据，VIN: {}", vin);
        String dataNumber = this.getDataNumber(vin);
        if (dataNumber == null) {
            LOGGER.warn("未找到 VIN={} 对应的 dataNumber，返回 null", vin);
            return null;
        } else {
            String key = "g." + dataNumber + ".xny.watch";
            LOGGER.debug("尝试从 Redis 获取 GPS 二进制数据，Key: {}", key);
            byte[] value = (byte[]) this.redisBinaryTemplate.opsForValue().get(key);
            if (value == null) {
                LOGGER.warn("Redis 中未找到 Key={} 对应的 GPS 数据，VIN={}", key, vin);
                return null;
            } else {
                LOGGER.debug("成功从 Redis 获取 GPS 二进制数据，Key={}, 数据长度={}", key, value.length);
                GPSRedisData gpsRedisData = ParseRedisVehicle.parseGPSRedisData(value, 28);
                LOGGER.debug("成功解析 GPSRedisData，VIN={}", vin);

                parseGeoLocationUtil.DetailedAddressInfo vehGeoInfo = parseGeoLocationUtil
                        .convertToDetailedAddress(gpsRedisData.getLongitude(), gpsRedisData.getLatitude());
                if (vehGeoInfo != null) {
                    gpsRedisData.setFormattedAddress(vehGeoInfo.getFormattedAddress());
                    gpsRedisData.setProvince(vehGeoInfo.getProvince());
                    gpsRedisData.setCity(vehGeoInfo.getCity());
                    gpsRedisData.setDistrict(vehGeoInfo.getDistrict());
                    gpsRedisData.setTownship(vehGeoInfo.getTownship());
                    gpsRedisData.setStreet(vehGeoInfo.getStreet());
                    gpsRedisData.setStreetNumber(vehGeoInfo.getStreetNumber());
                    LOGGER.debug("成功设置 GPS 详细地址信息，VIN={}", vin);
                } else {
                    gpsRedisData.setFormattedAddress("地址解析失败");
                    LOGGER.warn("GPS 地址解析失败，VIN={}, 经度={}, 纬度={}", vin, gpsRedisData.getLongitude(), gpsRedisData.getLatitude());
                }

                return gpsRedisData;
            }
        }
    }

    @Override
    public String getDataNumber(String vin) {
        LOGGER.debug("尝试获取 VIN={} 对应的 dataNumber，Key: g.{}.ter", vin, vin);
        String key = "g." + vin + ".ter";
        String value = (String) this.redisStringTemplate.opsForValue().get(key);
        if (value != null && !value.isEmpty()) {
            String dataNumber = value.split(",")[0];
            LOGGER.debug("成功获取 VIN={} 的 dataNumber: {}", vin, dataNumber);
            return dataNumber;
        } else {
            LOGGER.warn("Redis 中未找到 VIN={} 对应的 dataNumber，Key: {}", vin, key);
            return null;
        }
    }

    @Override
    public CanRedisData getCanValue(String vin) throws DecoderException {
        LOGGER.info("开始获取车辆 CAN 数据，VIN: {}", vin);
        CanRedisData canData = new CanRedisData();
        canData.setVin(vin);

        // 注意：这里调用了 getDataNumber(vin)，但未使用返回值，而是硬编码了一个 dataNumber，疑似逻辑有误
        String dataNumber = this.getDataNumber(vin);  // 获取了但未使用
        dataNumber = "1000098253";  // 硬编码，应该使用 dataNumber 或从参数/配置中获取
        if (dataNumber == null) {
            LOGGER.warn("未能获取有效的 dataNumber，返回 null");
            return null;
        } else {
            String key = "g." + dataNumber + ".can";
            LOGGER.debug("尝试从 Redis 获取 CAN 数据，Key: {}", key);

            // 定义需要解析的CAN ID列表
            List<String> targetCanIds = Arrays.asList(
                    "0x18FF61F3",  // 累充累放
                    "0x18FF21A6",  // 能量回收挡位
                    "0x18FF63F3",  // 累回
                    "0x18FF62F3"   // soh
            );

            // 批量获取所有CAN数据（减少Redis交互）
            List<Object> rawDataList = redisStringTemplate.opsForHash()
                    .multiGet(key, (Collection<Object>) (List<?>) targetCanIds);

            if (rawDataList == null) {
                LOGGER.warn("从 Redis 批量获取 CAN 数据返回 null，Key={}", key);
                return canData;
            }

            LOGGER.debug("成功批量获取 CAN 原始数据，数量: {}", rawDataList.size());
            for (int i = 0; i < targetCanIds.size(); ++i) {
                String canId = targetCanIds.get(i);
                String rawData = (String) rawDataList.get(i);
                LOGGER.debug("解析 CAN ID={}, 原始数据: {}", canId, rawData);

                if (rawData != null) {
                    CanDataParser canDataParser = this.parserFactory.getParser(canId);
                    if (canDataParser != null) {
                        canDataParser.parse(rawData, canData);
                        LOGGER.debug("成功解析 CAN ID={} 的数据", canId);
                    } else {
                        LOGGER.warn("未找到 CAN ID={} 对应的解析器", canId);
                    }
                } else {
                    LOGGER.warn("CAN ID={} 对应的原始数据为 null", canId);
                }
            }

            return canData;
        }
    }

//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(new Class[]{RedisVehServiceTestConfig.class});
//        System.out.println("Spring上下文初始化完成，开始测试...");
//        IRedisVehService redisVehService = (IRedisVehService)context.getBean(RedisVehServiceImpl.class);
//        String testVin = "LC1HC9AB8S0027465";
//
//        try {
//            System.out.println("\n=== 测试1：获取DataNumber ===");
//            String dataNumber = redisVehService.getDataNumber(testVin);
//            if (dataNumber != null) {
//                System.out.println("VIN[" + testVin + "]对应的DataNumber：" + dataNumber);
//            } else {
//                System.out.println("VIN[" + testVin + "]未查询到DataNumber（Redis中可能无key: g." + testVin + ".ter）");
//            }
//        } catch (Exception e) {
//            System.err.println("测试过程中发生未知异常：" + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            context.close();
//            System.out.println("\nSpring上下文已关闭，测试结束");
//        }
//
//    }
}
