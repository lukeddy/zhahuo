<template>
   <el-container>
    <el-header height="135px">
      <my-header/>
    </el-header>
    <el-main>
      <nuxt/>
    </el-main>
    <el-footer height="100%">
      <my-footer/>
    </el-footer>
  </el-container>
</template>
<script>
import MyHeader from '@/components/public/header/index.vue'
import MyFooter from '@/components/public/footer/index.vue'
export default{
  components: {
    MyHeader,
    MyFooter
  }
}
</script>
<style lang="scss" scoped>
@import "@/assets/css/public/header/topbar.scss";
</style>
