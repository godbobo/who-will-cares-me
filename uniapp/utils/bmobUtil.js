import Bmob from '@/utils/Bmob-2.2.1.min'
import * as config from '@/common/config'

/**
 * 异步获取请求地址
 */
export function getRequestUrl(env = 'dev') {
	return new Promise((resolve, reject) => {
		// 获取服务器信息
		Bmob.initialize(config.bmobSecrect, config.bmobKey)
		const query = Bmob.Query("server")
		// query.equalTo('env', '==', process.env.NODE_ENV === 'development' ? 'dev' : 'prod')
		query.equalTo('env', '==', env)
		query.find().then(res => {
			if (res && res.length) {
				resolve(res[0])
			} else {
				reject(new Error('未查询到数据'))
			}
		})
	})
	
	
}