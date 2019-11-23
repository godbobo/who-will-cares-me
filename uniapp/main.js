import Vue from 'vue'
import App from './App'
import store from './store'
import cuNavbar from './components/cu-navbar/cu-navbar.vue'
import * as config from './common/config'
import boboRouter from './utils/bobo-router'
import * as helper from './utils/helper'

Vue.config.productionTip = false
App.mpType = 'app'

Vue.component('cu-navbar', cuNavbar)
Vue.prototype.$config = config
Vue.prototype.$helper = helper

const app = new Vue({
    ...App
})
app.$mount()
