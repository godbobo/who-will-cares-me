<template>
	<view class="cub-page">
		<view class="cub-content">
			<slot></slot>
		</view>
		<view class="cu-bar tabbar bg-white">
			<block v-for="(tab, tabIndex) in items" :key="tabIndex">
				<view :class="[current === tabIndex ? hightlightTextColor : defaultTextColor, tab.isAdd ? 'add-action' : '']" class="action" @tap="onTabClicked(tab, tabIndex)">
					<button v-if="tab.isAdd" :class="[tab.icon, tab.addClass]" class="cu-btn shadow" />
					<view v-else class="cuIcon-cu-image">
						<bobo-icon :type="tab.icon" size="52rpx" />
						<cub-badge :count="tab.badge || 0" :dot="tab.showDot" hide-zero />
					</view>
					<view>{{tab.title}}</view>
				</view>
			</block>
		</view>
	</view>
</template>

<script>
	import boboIcon from '@/components/bobo-icon/bobo-icon.vue'
	import cubBadge from '@/components/cub-badge/cub-badge.vue'
	export default {
		name: 'cub-tabbar',
		components: {
			boboIcon, cubBadge
		},
		props: {
			items: {
				type: Array,
				default: function() {
					return []
				}
			},
			highlightColor: {
				type: String,
				default: 'green'
			},
			defaultColor: {
				type: String,
				default: 'gray'
			},
			current: {
				type: Number,
				default: 0
			}
		},
		computed: {
			hightlightTextColor() {
				return 'text-' + this.highlightColor
			},
			defaultTextColor() {
				return 'text-' + this.defaultColor
			}
		},
		methods: {
			onTabClicked(e, index) {
				this.$emit('tab-clicked', {
					tab: e,
					index
				})
			}
		}
	}
</script>

<style>
	
</style>

<style lang="scss" scoped>
	.cub-page {
		height: 100vh;
		display: flex;
		flex-direction: column;
		
		.cub-content {
			flex: 1;
			overflow: auto;
		}
		
		.cuIcon-cu-image {
			padding-bottom: 3px;
		}
	}
</style>