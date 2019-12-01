<template>
  <div id="app">
    <div class="app-container" :class="!showState ? 'bg-blur' : ''">
      <router-view/>
    </div>

    <!-- 定义锁屏区域，当服务器设置不展示状态时默认显示锁屏 -->
    <fullscreen-lock />
  </div>
</template>

<script>
import FullscreenLock from '@/components/fullscreen-lock'
import {mapState} from 'vuex'

export default {
  name: 'App',
  components: {
    FullscreenLock
  },
  computed: {
    ...mapState({
      showState: state => state.app.showData
    })
  }
}
</script>

<style>
html, body, div, a, span {
  padding: 0;
  margin: 0;
  color: #a7a8aa;
}

.app-container {
  position: fixed;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  margin: -20px;
  background: url('https://bobo-image.oss-cn-beijing.aliyuncs.com/wwcm/wwcm-bg.jpg');
  background-size: cover;
  background-repeat: no-repeat;
  overflow: auto;
}

.bg-blur {
  filter: blur(10px)
}
</style>
