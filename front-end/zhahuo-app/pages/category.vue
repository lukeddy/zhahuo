<template>
  <div class="category">
      <div>
        <breadcrumb/>
      </div>
      <div class="category-box">
         <product :child-data="asyncData" :product-type="type"/>
      </div>
      <div>
        <recommend/>
      </div>
  </div>
</template>

<script>
import Product from '@/components/public/category/productCategory.vue'
import Breadcrumb from '@/components/public/category/breadcrumb.vue'
import Recommend from '@/components/public/productlist/recommend.vue'
export default {
  components: {
      Product,
      Breadcrumb,
      Recommend
  },
  data() {
    return {
      asyncData : [],
      type: '你查找'
    }
  },
  async asyncData(context){
      if(context.query.cid){
        let cid = context.query.cid
        const {status,data} = await context.app.$axios.post('http://localhost:10010/api/search/product/cid',{
          cid:cid
        })
        if(status === 200){
          return {asyncData:data}
        }else{
          console.log("cid")
        }
      }
      if(context.query.bid){
        let bid = context.query.bid
        const {status,data} = await context.app.$axios.post('http://localhost:10010/api/search/product/bid',{
          bid:bid
        })
        if(status === 200){
          return {asyncData:data}
        }else{
          console.log("bid")
        }
        // return {asyncData:data}
      }
      if(context.query.keyword){
        let keyword = context.query.keyword
        console.log(keyword)
        const {status,data} = await context.app.$axios.post('http://localhost:10010/api/search/product/keyword',{
          keyword:keyword
        })
        if(status === 200){
          return {asyncData:data}
        }else{
          console.log("keyword")
        }
      }
  },
  mounted() {
    console.log(this.asyncData)
  }
}
</script>

<style lang="scss">
@import "@/assets/css/category/category.scss";
@import "@/assets/css/item/recommend.scss";
</style>