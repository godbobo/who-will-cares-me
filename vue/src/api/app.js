import http from '@/libs/request'

/**
 * 获取服务器基本信息
 */
export function getAppInfo () {
  return http.get('dhb/state')
}
