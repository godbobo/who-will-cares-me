<template>
  <!-- 全屏锁屏 -->
  <transition name="el-zoom-in-top">
    <div v-show="cptVisible" class="full-container">
      <el-avatar :size="80" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
      <transition name="el-zoom-in-top">
        <h1 v-show="tipVisible" class="tips">{{lockTips}}</h1>
      </transition>
    </div>
  </transition>
</template>

<script>
import {mapState} from 'vuex'

export default {
  name: 'fullscreen-lock',
  data () {
    return {
      cptVisible: true,
      tipVisible: true
    }
  },
  computed: {
    ...mapState({
      showState: state => state.app.showData
    }),
    lockTips () {
      return this.showState ? this.$config.unlockTips : this.$config.lockTips
    }
  },
  watch: {
    showState (newVal) {
      if (newVal) {
        setTimeout(() => {
          this.cptVisible = false
        }, 2000)
      } else {
        this.cptVisible = true
      }
    },
    lockTips () {
      this.tipVisible = false
      this.$nextTick(() => {
        this.tipVisible = true
      })
    }
  },
  mounted () {
    this.cptVisible = !this.showState
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
  background: url('https://bobo-image.oss-cn-beijing.aliyuncs.com/wwcm/lockscreen-bg.jpg');
  background-size: cover;
  background-repeat: no-repeat;

  .tips {
    color: white;
  }
}
</style>
