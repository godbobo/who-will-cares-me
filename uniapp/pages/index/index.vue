<template>
	<view>
		<cu-navbar bgColor="bg-gradual-pink">
			<block slot="content">{{pageTitle}}</block>
		</cu-navbar>
		<view class="cu-form-group margin-top">
			<view class="title">公开状态</view>
			<switch :class="state?'checked':''" :checked="state" @change="handleSwitchState"></switch>
		</view>
		<view class="cu-form-group">
			<view class="title">开发环境</view>
			<switch :class="isDevEnv?'checked':''" :checked="isDevEnv" @change="handleEnvChanged"></switch>
		</view>
	</view>
</template>

<script>
	import cubTabbar from '@/components/cub-tabbar/cub-tabbar.vue'
	import boboIcon from '@/components/bobo-icon/bobo-icon.vue'
	import {mapActions, mapState} from 'vuex'
	import * as bmobUtil from '@/utils/bmobUtil'
	
	export default {
		name: 'index',
		components: {
			cubTabbar, boboIcon
		},
		data() {
			return {
				pageTitle: 'Who will cares me?',
				state: false
			}
		},
		computed: {
			...mapState({
				env: state => state.app.env,
				url: state => state.app.url
			}),
			// 是否是开发环境
			isDevEnv() {
				return this.env === 'dev'
			}
		},
		onLoad() {
			if (this.url) {
				this.handleGetState()
			} else {
				uni.$once('url-load', ()=> {
					this.handleGetState()
				})
			}
		},
		methods: {
			...mapActions([
				'getState', 'switchState'
			]),
			/**
			 * 获取公开状态
			 */
			async handleGetState() {
				try{
					const {data} = await this.getState()
					this.state = data
				}catch(e){
					this.state = false
					this.$helper.showErrorTips(e)
				}
			},
			/**
			 * 切换公开状态
			 */
			async handleSwitchState() {
				uni.showLoading({
					title: '加载中...',
					mask: true
				})
				try{
					await this.switchState()
					this.state = !this.state
				}catch(e){
					this.$helper.showErrorTips(e)
				} finally {
					uni.hideLoading()
				}
			},
			/**
			 * 环境改变
			 */
			async handleEnvChanged() {
				uni.showLoading({
					title: '加载中...',
					mask: true
				})
				try{
					// 切换环境
					const env = this.isDevEnv ? 'prod' : 'dev'
					const {ip} = await bmobUtil.getRequestUrl(env)
					this.$store.commit('SET_URL', ip)
					this.$store.commit('SET_ENV', env)
					// 清除登录信息，自动跳转登录界面
					this.$store.commit('SET_TOKEN', '')
					this.$Router.replaceAll('/pages/login/login')
				}catch(e){
					this.$helper.showErrorTips(e)
				} finally {
					uni.hideLoading()
				}
			}
		}
	}
</script>
