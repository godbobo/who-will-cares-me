<template>
	<text :class="[iconClass]" :style="{fontSize: size, color: color}"></text>
</template>

<script>
	export default {
		name: 'bobo-icon',
		props: {
			// 图标类型 前面加_则使用cuIcon的图标
			type: {
				type: String,
				default: ''
			},
			// 图标大小
			size: {
				type: String,
				default: ''
			},
			color: {
				type: String,
				default: 'inherit'
			}
		},
		computed: {
			iconClass() {
				const isCuIcon = this.type.indexOf('_') === 0
				return isCuIcon ? 'cuIcon-' + this.type.substr(1, this.type.length -1) : 'icon-' + this.type
			}
		}
	}
</script>
