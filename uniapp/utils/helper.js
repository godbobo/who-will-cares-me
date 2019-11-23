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

/**
 * 展示错误提示
 * @param {Object} e 异常
 */
export function showErrorTips(e) {
	console.error(e)
	if (e.errMsg !== '未定义请求地址') {
		uni.showModal({
			title: '提示',
			content: e.msg || e.message || e.errMsg || '发生未知错误',
			showCancel: false
		})
	}
}