<template>
  <el-row :gutter="20" class="m-header" style="margin:0;">
    <el-col :span="3">
        <log/>
    </el-col>
    <el-col :span="11">
        <top-nav/>
    </el-col>
    <el-col :span="6">
        <user/>
    </el-col>
  </el-row>
</template>

<script>
import Log from './log.vue'
import TopNav from './topnav.vue'
import User from './user.vue'
export default {
  components: {
      Log,
      TopNav,
      User
  }
}
</script>

<style>

</style>