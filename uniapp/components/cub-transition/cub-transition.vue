<template>
	<view :class="[isReverse ? 'animation-reverse': '', animationType]">
		<slot></slot>
	</view>
</template>

<script>
	export default {
		name: 'cub-transition',
		props: {
			type: {
				type: String,
				default: 'fade'
			}
		},
		data() {
			return {
				isReverse: false,
				animationType: ''
			}
		},
		mounted() {
			this.animationType = 'animation-' + this.type
			setTimeout(() => {
				this.animationType = ''
			}, 500)
		},
		methods: {
			/**
			 * 外部调用该方法显示退出动画
			 */
			exit(type) {
				this.isReverse = true
				this.animationType = 'animation-' + (type || this.type)
				setTimeout(() => {
					this.animationType = ''
					this.isReverse = false
					this.$emit('animation-end')
				}, 500)
			}
		}
	}
</script>
