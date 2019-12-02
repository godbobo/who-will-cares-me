<template>
  <div id="app">
    <router-view/>

    <!-- 定义锁屏区域，当服务器设置不展示状态时默认显示锁屏 -->
    <fullscreen-lock />
  </div>
</template>

<script>
import FullscreenLock from '@/components/fullscreen-lock'

export default {
  name: 'App',
  components: {
    FullscreenLock
  }
}
</script>

<style>
@import "./assets/styles/transitions.css";

html, body, div, a, span {
  padding: 0;
  margin: 0;
  color: #a7a8aa;
}

#app {
  width: 100vw;
  height: 100vh;
  background: url('https://bobo-image.oss-cn-beijing.aliyuncs.com/wwcm/wwcm-bg.jpg');
  background-size: cover;
  background-repeat: no-repeat;
  overflow: auto;
}

</style>
