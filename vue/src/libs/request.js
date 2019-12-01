import axios from 'axios'
import { Message } from 'element-ui'
import store from '@/store'

// create an axios instance
const http = axios.create({
  baseURL: '',
  timeout: 5000 // request timeout
})

// request interceptor
http.interceptors.request.use(
  config => {
    if (store.state.app.baseUrl) {
      config.baseURL = store.state.app.baseUrl
    } else {
      return Promise.reject(new Error('未设置请求地址'))
    }
    return config
  },
  error => {
    console.error(error) // for debug
    return Promise.reject(error)
  }
)

// response interceptor
http.interceptors.response.use(
  /**
   * If you want to get http information such as headers or status
   * Please return  response => response
  */

  response => {
    return response.data
  },
  error => {
    console.error('err' + error) // for debug
    Message({
      message: error.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

export default http
