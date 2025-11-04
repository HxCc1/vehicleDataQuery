package org.xgqc.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class parseGeoLocationUtil {
    private static final String GEOCODING_API = "https://restapi.amap.com/v3/geocode/regeo";
    private static final String AMAP_KEY = "f7aab016c39e38d60ce8bfdac7a969c5";

    public parseGeoLocationUtil() {
    }

    public static DetailedAddressInfo convertToDetailedAddress(Long lonInt, Long latInt) {
        double longitude = (double)lonInt / (double)1000000.0F;
        double latitude = (double)latInt / (double)1000000.0F;
        System.out.printf("转换后经纬度：经度=%.6f，纬度=%.6f%n", longitude, latitude);
        String addressJson = getDetailedRegeoFromAmap(longitude, latitude);
        if (addressJson == null) {
            System.err.println("API调用失败，无法获取详细地址");
            return null;
        } else {
            return parseDetailedAddressFromJson(addressJson);
        }
    }

    private static String getDetailedRegeoFromAmap(double longitude, double latitude) {
        String url = String.format("%s?location=%.6f,%.6f&key=%s&extensions=all&radius=1000", "https://restapi.amap.com/v3/geocode/regeo", longitude, latitude, "f7aab016c39e38d60ce8bfdac7a969c5");

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            Throwable var9 = null;

            String var11;
            try {
                HttpEntity entity = response.getEntity();
                if (entity == null) {
                    return null;
                }

                var11 = EntityUtils.toString(entity, "UTF-8");
            } catch (Throwable var39) {
                var9 = var39;
                throw var39;
            } finally {
                if (response != null) {
                    if (var9 != null) {
                        try {
                            response.close();
                        } catch (Throwable var38) {
                            var9.addSuppressed(var38);
                        }
                    } else {
                        response.close();
                    }
                }

            }

            return var11;
        } catch (ParseException | IOException e) {
            System.err.println("高德API调用异常：" + ((Exception)e).getMessage());
            ((Exception)e).printStackTrace();
            return null;
        }
    }

    private static DetailedAddressInfo parseDetailedAddressFromJson(String json) {
        JSONObject root = JSONObject.parseObject(json);
        if (!"1".equals(root.getString("status"))) {
            System.err.println("地址解析失败：" + root.getString("info") + "，错误码：" + root.getString("infocode"));
            return null;
        } else {
            JSONObject regeoObject = root.getJSONObject("regeocode");
            if (regeoObject != null && !regeoObject.isEmpty()) {
                JSONObject addressComponent = regeoObject.getJSONObject("addressComponent");
                String province = addressComponent.getString("province");
                String city = getCity(addressComponent);
                String district = addressComponent.getString("district");
                String townShip = addressComponent.getString("township");
                JSONArray poisArray = regeoObject.getJSONArray("pois");
                String street = "";
                String streetNumber = "";
                String formattedAddress = regeoObject.getString("formatted_address");
                if (poisArray != null && !poisArray.isEmpty()) {
                    JSONObject firstPoi = poisArray.getJSONObject(0);
                    street = firstPoi.getString("street");
                    streetNumber = firstPoi.getString("number");
                }

                return new DetailedAddressInfo(province, city, district, townShip, street, streetNumber, formattedAddress);
            } else {
                System.err.println("未查询到对应地址信息");
                return null;
            }
        }
    }

    private static String getCity(JSONObject addressComponent) {
        String city = addressComponent.getString("city");
        if (city != null && !city.isEmpty()) {
            return city.contains("市辖区") ? city.replace("市辖区", "") : city;
        } else {
            return addressComponent.getString("province");
        }
    }

    public static void main(String[] args) {
        DetailedAddressInfo info = convertToDetailedAddress(103960933L, 30585693L);
        if (info != null) {
            System.out.println("解析结果：");
            System.out.println(info);
            System.out.println(info.getFormattedAddress());
        }

    }

    public static class DetailedAddressInfo {
        private String province;
        private String city;
        private String district;
        private String township;
        private String street;
        private String streetNumber;
        private String formattedAddress;

        public DetailedAddressInfo(String province, String city, String district, String township, String street, String streetNumber, String formattedAddress) {
            this.province = province;
            this.city = city;
            this.district = district;
            this.township = township;
            this.street = street;
            this.streetNumber = streetNumber;
            this.formattedAddress = formattedAddress;
        }

        public String getProvince() {
            return this.province;
        }

        public String getCity() {
            return this.city;
        }

        public String getDistrict() {
            return this.district;
        }

        public String getTownship() {
            return this.township;
        }

        public String getStreet() {
            return this.street;
        }

        public String getStreetNumber() {
            return this.streetNumber;
        }

        public String getFormattedAddress() {
            return this.formattedAddress;
        }

        public String toString() {
            return String.format("完整地址：%s;%n省：%s，市：%s，区：%s%n乡镇：%s，街道：%s，门牌号：%s", this.formattedAddress, this.province, this.city, this.district, this.township, this.street, this.streetNumber);
        }
    }
}
