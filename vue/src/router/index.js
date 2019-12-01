import Vue from 'vue'
import Router from 'vue-router'
import routes from './routes'
import * as config from '@/config'

Vue.use(Router)
const router = new Router({
  routes,
  mode: 'hash'
})

// 路由前置守卫
router.beforeEach((to, from, next) => {
  console.log('哈哈哈')
  next()
})

// 路由后置守卫
router.afterEach(to => {
  // 设置页面标题
  document.title = config.appTitle
})

export default router
