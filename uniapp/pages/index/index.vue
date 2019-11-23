<template>
	<view>
		<cu-navbar bgColor="bg-gradual-pink">
			<block slot="content">{{pageTitle}}</block>
		</cu-navbar>
		<view class="cu-form-group margin-top">
			<view class="title">公开状态</view>
			<switch :class="state?'checked':''" :checked="state" @change="handleSwitchState"></switch>
		</view>
	</view>
</template>

<script>
	import cubTabbar from '@/components/cub-tabbar/cub-tabbar.vue'
	import boboIcon from '@/components/bobo-icon/bobo-icon.vue'
	import {mapActions} from 'vuex'
	
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
		onLoad() {
			uni.$once('url-load', ()=> {
				this.handleGetState()
			// 	uni.request({
			// 		url: 'http://www.baidu.com/',
			// 		success: (res) => {
			// 			console.log(JSON.stringify(res))
			// 		},
			// 		fail: (e) => {
			// 			console.log(e)
			// 		}
			// 	})
			})
			this.handleGetState()
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
			}
		}
	}
</script>
