// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
// element ui样式文件
import 'element-ui/lib/theme-chalk/index.css'
// fade/zoom 等过渡动画
import 'element-ui/lib/theme-chalk/base.css'
import * as config from '@/config'

Vue.config.productionTip = false

Vue.use(ElementUI)

Vue.prototype.$config = config

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
