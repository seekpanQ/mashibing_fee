/*
 * @Author: ch cwl_ch@163.com
 * @Date: 2022-12-30 14:47:25
 * @LastEditors: ch
 * @LastEditTime: 2023-01-03 19:51:18
 * @Description: 服务端配置
 */

export default {
    // #ifdef H5
        // 支付服务
        pay: '/payApi',
        // sse服务
        sse: '/sseApi',
        // 其他接口服务
        other: '/api',
    // #endif

    // #ifdef APP-PLUS ||MP
        // 支付服务
        pay: 'http://127.0.0.1:9001',
        // sse服务
        sse: 'http://127.0.0.1:9000',
        // 其他接口服务
        other: 'http://127.0.0.1:8081',
    // #endif
}