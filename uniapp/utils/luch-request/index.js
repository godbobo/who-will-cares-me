import Request from './request'
import store from '@/store'

const http = new Request()

http.setConfig((config) => {
  config.baseUrl = ''
  config.header = {
    ...config.header
  }
  return config
})

/**
 * 自定义验证器，如果返回true 则进入响应拦截器的响应成功函数(resolve)，否则进入响应拦截器的响应错误函数(reject)
 * @param { Number } statusCode - 请求响应体statusCode（只读）
 * @return { Boolean } 如果为true,则 resolve, 否则 reject
 */
http.validateStatus = (statusCode) => {
  return statusCode === 200
}

http.interceptor.request((config, cancel) => {
	const token = store.state.app.token
	const url = store.state.app.url
	if (!url) {
		cancel('未定义请求地址')
		return
	}
	
	config.baseUrl = url
  config.header = {
    ...config.header,
		Authorization: token || ''
  }
	console.log(config)
  return config
})

http.interceptor.response((response) => {
  // console.log(response)
  return response.data
}, (response) => {
  return response.data
})

export {
  http
}
