<template>
  <div>
    <div v-if="recommended" class="box-inner">
      <ul class="recommend-items clearfix items-line1">
          <li @click="itemProduct(item)" class="recommend-item-four" v-for="(item,index) in recommended" :key="index">
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
    <div v-if="!recommended" class="category-is-show">
        <div class="category-type">抱歉没有找到与“{{type}}”相关的商品</div>
    </div>
  </div>
  
</template>

<script>
export default {
    props :['childData','productType'],
    data(){
        return {
            recommended: this.childData.length > 0 ? this.childData : false,
            type: this.productType
        }
    },
    methods:{
        itemProduct(item){
            if(item != null){
                location.href = '/item?pid=' +item.pid
            }
        }
    }
}
</script>

<style>

</style>