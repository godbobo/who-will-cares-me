import Vue from 'vue'
import Router from './bobo-router'
import store from '@/store'
import * as bmobUtil from '@/utils/bmobUtil'
import * as helper from '@/utils/helper'

Vue.use(Router)

// 路由配置 页面中全部使用this.$Router来操作路由，以实现路由的全局管理
const router = new Router()

// 路由全局拦截器 在这里处理登录、授权等相关操作
router.beforeEach(async function(to, from, next) {
	const url = store.state.app.url
	const isLogin = store.state.app.isLogin
	try {
		//请求地址不存在时获取请求地址
		if (!url && !to.page) {
			const { ip } = await bmobUtil.getRequestUrl(store.state.app.env || undefined)
			store.commit('SET_URL', ip)
			store.commit('SET_TOKEN', helper.getToken())
			uni.$emit('url-load')
		}
		// 用户未登录时尝试登录
		const token = store.state.app.token
		if (!isLogin && to.page !== '/pages/login/login') {
			if (token) {
				await store.dispatch('login')
				store.commit('SET_LOGIN', true)
			} else {
				next({page: '/pages/login/login', method: 'replace'})
			}
		}
		next()
	} catch(e){
		console.error(e || '网络连接失败')
		next({page: '/pages/login/login', method: 'replace'})
	}
})

// 路由后置拦截器
router.afterEach(function (to, from) {
	console.log('后置守卫')
})

// 路由跳转出错处理
router.onError(function(e) {
	console.log('错误：', e.message || '路由跳转失败')
})

export default router