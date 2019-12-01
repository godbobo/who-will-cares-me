<template>
  <div class="container">
    <h1 class="site-title">{{ appTitle }}</h1>
  </div>
</template>

<script>
import {mapActions} from 'vuex'

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
    this.handleAppInfo()
  },
  methods: {
    ...mapActions([
      'getAppInfo'
    ]),
    async handleAppInfo () {
      // 全屏显示加载中状态
      const loading = this.$loading({
        lock: true,
        text: '加载中',
        spinner: 'el-icon-loading',
        background: 'rgba(0, 0, 0, 0.7)'
      })
      try {
        const { data } = await this.getAppInfo()
        this.$store.commit('SET_SHOW_DATA', data)
      } catch (e) {
        console.error(e)
      } finally {
        loading.close()
        this.titleVisible = true
      }
    }
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
