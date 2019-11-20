<template>
   <el-container>
    <el-header height="100px">
      <user-header/>
    </el-header>
    <el-main>
      <nuxt/>
    </el-main>
    <el-footer height="100%">
      <user-footer/>
    </el-footer>
  </el-container>
</template>
<script>
import UserHeader from '@/components/user/userheader.vue'
import UserFooter from '@/components/user/userfooter.vue'
export default{
  components: {
    UserHeader,
    UserFooter
  }
}
</script>
<style lang="scss">
@import "@/assets/css/user/userheader.scss";
@import "@/assets/css/user/userfooter.scss";
</style>
