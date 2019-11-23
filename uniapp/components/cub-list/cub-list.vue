<template>
	<view :class="typeClass" class="cu-list menu sm-border">
		<block v-for="(item, index) in items" :key="index">
			<view :class="[item.showArrow ? 'arrow' : '']" class="cu-item">
				<view :class="[item.subTitle ? 'padding-tb-sm' : '']" class="content">
					<view>
						<bobo-icon :type="item.icon" :color="item.iconColor" class="margin-right-xs" />
						<text class="text-grey">{{item.title}}</text>
					</view>
					<view class="text-gray text-sm">{{item.subTitle}}</view>
				</view>
				<view class="action">
					<slot name="action"></slot>
				</view>
			</view>
		</block>
	</view>
</template>

<script>
	import BoboIcon from '@/components/bobo-icon/bobo-icon.vue'
	
	export default {
		name: 'cub-list',
		components: {
			BoboIcon
		},
		props: {
			type: {
				type: String,
				default: 'normal'
			},
			items: {
				type: Array,
				default: function() {
					return []
				}
			}
		},
		computed: {
			typeClass() {
				return this.type === 'card' ? 'card-menu margin-top' : ''
			}
		}
	}
</script>

<style>
</style>
