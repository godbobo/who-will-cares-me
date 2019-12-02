import * as config from '@/config'
import * as app from '@/api/app'
import Vue from 'vue'

export default {
  state: {
    baseUrl: '',
    showData: false,
    socket: {
      isConnected: false,
      message: '',
      reconnectError: false
    }
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
    },
    // WebSocket事件
    SOCKET_ONOPEN (state, event) {
      Vue.prototype.$socket = event.currentTarget
      state.socket.isConnected = true
    },
    SOCKET_ONCLOSE (state, event) {
      state.socket.isConnected = false
    },
    SOCKET_ONERROR (state, event) {
      console.error(state, event)
    },
    // default handler called for all methods
    SOCKET_ONMESSAGE (state, message) {
      state.socket.message = message
      if (message.type === 'stateChange') {
        // 展示状态变化的事件
        this.commit('SET_SHOW_DATA', message.data)
      }
    },
    // mutations for reconnect methods
    SOCKET_RECONNECT (state, count) {
      console.info(state, count)
    },
    SOCKET_RECONNECT_ERROR (state) {
      state.socket.reconnectError = true
    }
  },
  actions: {
    // 获取系统基本信息
    getAppInfo () {
      return app.getAppInfo()
    }
  }
}
