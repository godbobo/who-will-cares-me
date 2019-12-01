import * as config from '@/config'
import * as app from '@/api/app'

export default {
  state: {
    baseUrl: '',
    showData: true
  },
  mutations: {
    SET_URL (state, url) {
      if (url) {
        state.baseUrl = url + ':' + (process.env.NODE_ENV === 'development' ? config.port.dev : config.port.prod) + '/'
      } else {
        state.baseUrl = ''
      }
    },
    SET_SHOW_DATA (state, payload) {
      state.showData = payload
    }
  },
  actions: {
    // 获取系统基本信息
    getAppInfo () {
      return app.getAppInfo()
    }
  }
}
