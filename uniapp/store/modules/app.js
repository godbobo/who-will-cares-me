import * as app from '@/api/app'
import * as helper from '@/utils/helper'
import * as config from '@/common/config'

export default {
	state: {
		token: '',
		url: '',
		isLogin: false,
		env: 'dev'
	},
	mutations: {
		SET_TOKEN(state, payload) {
			state.token = payload
			helper.setToken(payload)
		},
		SET_URL(state, payload) {
			if (payload) {
				state.url = `${payload}:${config.port}/`
			} else {
				state.url = ''
			}
		},
		SET_LOGIN(state, payload) {
			state.isLogin = payload
		},
		SET_ENV(state, payload) {
			state.env = payload
			helper.setEnv(payload)
		}
	},
	actions: {
		// 用户登录
		login() {
			return app.login()
		},
		// 获取公开状态
		getState() {
			return app.getState()
		},
		// 切换公开状态
		switchState() {
			return app.switchState()
		}
	}
}
