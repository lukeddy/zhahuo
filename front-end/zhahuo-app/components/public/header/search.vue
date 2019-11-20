<template>
  <div class="search wrapper-search">
    <el-row :gutter="20" class="search-text-item" style="margin:0 auto;">
      <el-col :span="3">
        <list/>
      </el-col>
      <el-col :span="13">
        <search-nav/>
      </el-col>
      <el-col :span="8">
        <search-input/>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import SearchInput from './searchinput.vue'
import SearchNav from './searchnav.vue'
import List from './../productlist/list.vue'
export default {
  components: {
      SearchInput,
      SearchNav,
      List
  }
}
</script>

<style>
</style>