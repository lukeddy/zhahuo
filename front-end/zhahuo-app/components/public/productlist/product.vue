<template>
  <div class="box-inner">
      <ul class="recommend-items clearfix items-line1">
          <li @click="recommendItem(item)" class="recommend-item-four" v-for="(item,index) in recommended" :key="index">
              <div class="product-box-item cart-box">
                  <div class="recommend-box-img">
                      <div class="recommend-img">
                          <img :src="item.pimage" />
                      </div>
                      <h4 class="recommend-box-title">{{item.pname}}</h4>
                  </div>
                  <div class="recommend-box-msg">
                      <span class="iconfont">￥</span>
                      <span class="price">{{item.marketPrice}}</span>
                  </div>
              </div>
          </li>
      </ul>
  </div>
</template>

<script>
export default {
    data(){
        return {
            recommended: []
        }
    },
    async mounted() {
      const {status,data} = await this.$axios.post('http://localhost:10010/api/search/page/productPage',{
          page:1,
          rows:8
      })
      if(status === 200){
        this.recommended = data.currentPage
      }else{
          alert("recommended is error")
      }
    },
    methods: {
        recommendItem(item){
            if(item != null){
                location.href = '/item?pid=' +item.pid
            }
        }
    }
}
</script>

<style>

</style>