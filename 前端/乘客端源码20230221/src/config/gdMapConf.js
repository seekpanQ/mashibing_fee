/*
 * @Author: ch cwl_ch@163.com
 * @Date: 2022-12-28 14:39:29
 * @LastEditors: ch
 * @LastEditTime: 2023-01-03 21:00:14
 * @Description: 高德地图配置，需要自行去高德开放平台申请
 */
export default {
    // 高德地图JS Api key
    key:'6ca5da78f393e39b2783782bc43be436',
    // 高德地图JS Api key对应的秘钥，正式环境最好不要放前端
    securityJsCode : 'f339d23e0fb16dcc9ced1e5821065165',
    // 城市获取key
    cityKey : 'ed08e6101b2e0e7f043a10a40849d95d',
    // 高德城市请求地址
    cityApiUrl : 'https://restapi.amap.com/v3/config/district',
    // 默认选中城市
    city: {
        adcode: "110000",
        center: "116.407387,39.904179",
        citycode: "010",
        name: "北京市"
    }
}