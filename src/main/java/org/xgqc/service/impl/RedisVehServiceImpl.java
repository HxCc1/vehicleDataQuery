package org.xgqc.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.apache.commons.codec.DecoderException;
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

    public RedisVehServiceImpl(CanParserFactory parserFactory) {
        this.parserFactory = parserFactory;
    }

    public VehicleData getVehicleData(String vin) {
        String dataNumber = this.getDataNumber(vin);
        if (dataNumber == null) {
            return null;
        } else {
            String key = "g." + dataNumber + ".xny.watch";
            byte[] value = (byte[])this.redisBinaryTemplate.opsForValue().get(key);
            if (value == null) {
                return null;
            } else {
                VehicleData vehicleData = ParseRedisVehicle.parseVehicleData(value);
                parseGeoLocationUtil.DetailedAddressInfo vehGeoInfo = parseGeoLocationUtil.convertToDetailedAddress(vehicleData.getLongitude(), vehicleData.getLatitude());
                if (vehGeoInfo != null) {
                    vehicleData.setFormattedAddress(vehGeoInfo.getFormattedAddress());
                    vehicleData.setProvince(vehGeoInfo.getProvince());
                    vehicleData.setCity(vehGeoInfo.getCity());
                    vehicleData.setDistrict(vehGeoInfo.getDistrict());
                    vehicleData.setTownship(vehGeoInfo.getTownship());
                    vehicleData.setStreet(vehGeoInfo.getStreet());
                    vehicleData.setStreetNumber(vehGeoInfo.getStreetNumber());
                } else {
                    vehicleData.setFormattedAddress("地址解析失败");
                }

                return vehicleData;
            }
        }
    }

    public GPSRedisData getGPSValue(String vin) {
        String dataNumber = this.getDataNumber(vin);
        if (dataNumber == null) {
            return null;
        } else {
            String key = "g." + dataNumber + ".xny.watch";
            byte[] value = (byte[])this.redisBinaryTemplate.opsForValue().get(key);
            if (value == null) {
                return null;
            } else {
                GPSRedisData gpsRedisData = ParseRedisVehicle.parseGPSRedisData(value, 28);
                parseGeoLocationUtil.DetailedAddressInfo vehGeoInfo = parseGeoLocationUtil.convertToDetailedAddress(gpsRedisData.getLongitude(), gpsRedisData.getLatitude());
                if (vehGeoInfo != null) {
                    gpsRedisData.setFormattedAddress(vehGeoInfo.getFormattedAddress());
                    gpsRedisData.setProvince(vehGeoInfo.getProvince());
                    gpsRedisData.setCity(vehGeoInfo.getCity());
                    gpsRedisData.setDistrict(vehGeoInfo.getDistrict());
                    gpsRedisData.setTownship(vehGeoInfo.getTownship());
                    gpsRedisData.setStreet(vehGeoInfo.getStreet());
                    gpsRedisData.setStreetNumber(vehGeoInfo.getStreetNumber());
                } else {
                    gpsRedisData.setFormattedAddress("地址解析失败");
                }

                return gpsRedisData;
            }
        }
    }

    public String getDataNumber(String vin) {
        String key = "g." + vin + ".ter";
        String value = (String)this.redisStringTemplate.opsForValue().get(key);
        if (value != null && !value.isEmpty()) {
            String dataNumber = value.split(",")[0];
            return dataNumber;
        } else {
            return null;
        }
    }

    public CanRedisData getCanValue(String vin) throws DecoderException {
        CanRedisData canData = new CanRedisData();
        canData.setVin(vin);

        this.getDataNumber(vin);
        String dataNumber = "1000098253";
        if (dataNumber == null) {
            return null;
        } else {
            String key = "g." + dataNumber + ".can";
            // 定义需要解析的CAN ID列表
            List<String> targetCanIds = Arrays.asList(
                    "0x18FF61F3",  // 累充累放
                    "0x18FF21A6",  // 能量回收挡位
                    "0x18FF63F3",  // 累回
                    "0x18FF62F3"  // soh
            );
            // 批量获取所有CAN数据（减少Redis交互）
            List<Object> rawDataList = redisStringTemplate.opsForHash()
                    .multiGet(key, (Collection<Object>) (List<?>) targetCanIds);

            for(int i = 0; i < targetCanIds.size(); ++i) {
                String rawData = (String)rawDataList.get(i);
                if (rawData != null) {
                    CanDataParser canDataParser = this.parserFactory.getParser((String)targetCanIds.get(i));
                    if (canDataParser != null) {
                        canDataParser.parse(rawData, canData);
                    }
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
