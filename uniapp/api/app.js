import {http} from '@/utils/luch-request'

/**
 * 用户登陆
 */
export function login() {
	return http.get('dhb/user-state')
}

/**
 * 获取公开状态
 */
export function getState() {
	return http.get('dhb/state')
}

/**
 * 切换公开状态
 */
export function switchState() {
	return http.put('dhb/state')
}