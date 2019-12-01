<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
html, body, div {
  padding: 0;
  margin: 0;
}

#app {
  width: 100vw;
  height: 100vh;
  background: url('https://bobo-image.oss-cn-beijing.aliyuncs.com/wwcm/wwcm-bg.jpg');
  background-size: cover;
  background-repeat: no-repeat;
}
</style>
