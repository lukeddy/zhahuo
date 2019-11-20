<template>
  <div class="m-header">
    <el-row class="m-header-row">
      <el-col>
        <top-bar />
      </el-col>
    </el-row>
    <el-row class="m-search-row">
      <el-col>
        <search />
      </el-col>
    </el-row>
  </div>
</template>

<script>
import TopBar from './topbar.vue';
import Search from './search.vue';
export default {
  components: {
    TopBar,
    Search
  }
};
</script>

<style lang="scss">
 @import "@/assets/css/public/header/topbar.scss"; 
 @import "@/assets/css/public/header/search.scss";
</style>