<template>
  <!-- 全屏锁屏 -->
  <transition name="el-zoom-in-center">
    <div v-show="!showState" class="full-container">
      <el-avatar :size="80" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
      <h1>{{lockTips}}</h1>
    </div>
  </transition>
</template>

<script>
import {mapState} from 'vuex'

export default {
  name: 'fullscreen-lock',
  computed: {
    ...mapState({
      showState: state => state.app.showData
    }),
    lockTips () {
      return this.$config.lockTips
    }
  }
}
</script>

<style lang="scss" scoped>
.full-container {
  position: fixed;
  top: 0;
  left: 0;
  right:0;
  bottom:0;
  display: flex;
  z-index: 100;
  align-items: center;
  justify-content: center;
  flex-direction: column;

}
</style>
