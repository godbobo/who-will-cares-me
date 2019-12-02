// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
// element ui样式文件
import 'element-ui/lib/theme-chalk/index.css'
// fade/zoom 等过渡动画
import 'element-ui/lib/theme-chalk/base.css'
// 全局配置文件
import * as config from '@/config'
// webSocket客户端
import VueNativeSock from 'vue-native-websocket'
// 全局帮助函数
import * as helper from './libs/helper'

Vue.config.productionTip = false

Vue.use(ElementUI)
// 项目中没有保存服务器地址，因此先设置本地地址占位
Vue.use(VueNativeSock, 'ws://0.0.0.0/', {store, connectManually: true, format: 'json', reconnection: true, reconnectionAttempts: 5, reconnectionDelay: 10000})

Vue.prototype.$config = config
Vue.prototype.$helper = helper

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
