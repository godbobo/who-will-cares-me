const tokenName = 'token'

/**
 * 保存token
 * @param {Object} token token
 */
export function setToken(token) {
	uni.setStorageSync(tokenName, token)
}
/**
 * 获取token
 */
export function getToken() {
	return uni.getStorageSync(tokenName)
}

const envName = 'env'

/**
 * 保存使用环境
 * @param {Object} env 环境
 */
export function setEnv(env) {
	uni.setStorageSync(envName, env)
}
/**
 * 获取使用环境
 */
export function getEnv() {
	return uni.getStorageSync(envName)
}

/**
 * 展示错误提示
 * @param {Object} e 异常
 */
export function showErrorTips(e) {
	console.error(e || '网络连接失败')
	if (e) {
		uni.showModal({
			title: '提示',
			content: e.msg || e.message || e.errMsg || '发生未知错误',
			showCancel: false
		})
	}
}