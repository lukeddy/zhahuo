<template>
  <div class="recommend">
    <div class="gray-box">
      <el-row class="">
        <el-col>
            <product-title/>
        </el-col>
        </el-row>
        <el-row class="">
        <el-col>
            <product/>
        </el-col>
        </el-row>
    </div>
  </div>
</template>

<script>
import ProductTitle from './title.vue'
import Product from './product.vue'
export default {
  components:{
      ProductTitle,
      Product
  }
}
</script>

<style lang="scss">
@import "@/assets/css/item/recommend.scss"
</style>