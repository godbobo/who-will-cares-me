<template>
  <div class="container">
    <transition name="el-zoom-in-top">
      <h1 v-show="titleVisible" class="site-title">{{ appTitle }}</h1>
    </transition>
  </div>
</template>

<script>
export default {
  name: 'index',
  data () {
    return {
      titleVisible: false
    }
  },
  computed: {
    appTitle () {
      return this.$config.appTitle
    }
  },
  mounted () {
    this.titleVisible = true
  }
}
</script>

<style lang="scss" scoped>
@import "@/assets/styles/variables.scss";

.container {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;

  .site-title {
    color: $gray-1;
    font-size: 2.5rem;
    margin: 16px 0 0;
  }
}
</style>
