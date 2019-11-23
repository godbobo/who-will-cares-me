<template>
	<view v-if="!(hideZero && count === 0)" class="cu-tag badge">{{ countText}}</view>
</template>

<script>
	export default {
		name: 'cub-badge',
		props: {
			count: {
				type: Number,
				default: 0
			},
			hideZero: {
				type: Boolean,
				default: false
			},
			dot: {
				type: Boolean,
				default: false
			},
			maxCount: {
				type: Number,
				default: 99
			}
		},
		computed: {
			countText() {
				let text = this.count
				if (this.count > this.maxCount) {
					text = this.maxCount + '+'
				}
				return this.dot ? '' : text
			}
		}
	}
</script>
