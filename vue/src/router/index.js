import Vue from 'vue'
import Router from 'vue-router'
import routes from './routes'
import store from '../store'
import * as config from '@/config'
import * as bmobUtil from '@/libs/bmobUtil'

Vue.use(Router)
const router = new Router({
  routes,
  mode: 'hash'
})

// 路由前置守卫
router.beforeEach((to, from, next) => {
  // 请求地址不存在时需要先获取请求地址
  if (!store.state.app.baseUrl && to.name !== 'error_500') {
    bmobUtil.getRequestUrl().then(data => {
      store.commit('SET_URL', data.ip)
      next()
    }).catch(error => {
      console.error(error)
      next({name: 'error_500'})
    })
  } else {
    next()
  }
})

// 路由后置守卫
router.afterEach(to => {
  // 设置页面标题
  document.title = config.appTitle
})

export default router
