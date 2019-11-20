<template>
<div>
  <div class="container-item">
    <div class="item-wrapper">
      <div class="gallery-wrapper">
        <div class="gallery">
          <div class="thumbnail">
            <ul class="thumbnail-ul">
              <li @click="changeImage(inf,index)" v-for="(inf,index) in imageInf" :key="index" :class="{ischanke: nowindex == index}">
                <img
                  :src="host + inf"
                  alt
                />
              </li>
            </ul>
          </div>
          <div class="thumb">
            <ul class="thumb-ul">
              <li>
                <img
                  :src="changeImg"
                  alt
                />
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="item-information">
        <div class="item-title">
          <h1>{{itemProduct.product.pname}}</h1>
          <h2>{{itemProduct.product.pdesc}}</h2>
          <div class="item-price">
            <div class="item-price-box">
              <span class="iconfont">¥</span>
              <span>{{itemProduct.product.marketPrice}}</span>
            </div>
          </div>
        </div>
        <div v-if="productColor.length  > 0" class="item-spec-wrapper clearfix item-spec-color">
          <div class="item-spec">
            <span class="spec-title">颜色选择</span>
            <ul class="spec-info">
              <li @click="changeColor(color)" :class="{'spec-info-li': true,'active': nowColor[1] == color[1]}"  v-for="(color,index) in productColor" :key="index" >
                <span class="spec-info-one" :style="{background: color}"></span>
              </li>
            </ul>
          </div>
        </div>
        <div v-if="sizeInf != ''" class="clearfix item-spec-package">
          <div class="item-spec">
            <span class="spec-title">尺码选择</span>
            <ul class="spec-info">
              <li :class="{disabled: true,active: nowSize == size}" @click="changeSize(sizeInf[index],index)" v-for="(size,index) in sizeInf" :key="index">
                <span class="item-name">{{size}}</span>
              </li>
            </ul>
          </div>
        </div>
        <div class="item-do-count-wrapper clearfix">
          <div class="item-do-count">
            <span class="do-count-title">数量选择</span>
            <div class="do-count">
              <div class="select">
                <el-input-number v-model="num1" @change="handleChange" :min="1" label="描述文字"></el-input-number>
              </div>
            </div>
          </div>
        </div>
        <div class="sku-custom-tips-wrapper clearfix">
          <div class="sku-custom-tips">
            <span class="sku-custom-tips-title">服务说明</span>
            <div class="sku-custom-tips-text">
              <p>满 99 元包邮</p>
              <p>拆封后不支持七天无理由退货</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <recommend/>
  <pay :pay-data="addCart" :pay-size="productSize" :pay-color="productColorGet" :pay-num="num1"/>
</div>
</template>

<script>
import Recommend from '@/components/public/productlist/recommend.vue'
import Pay from '@/components/cart/pay.vue'
export default {
  components: {
    Recommend,
    Pay
  },
  data() {
    return {
      itemProduct: [],
      addCart:[],
      imageInf:[],
      num1: 1,
      imgUrl:'',
      host:'',
      nowindex:0,
      sizeInf:'',
      nowSize:'',
      nowColor:'',
      productColor:[]
    };
  },
  async asyncData(context){
    const pid = context.query.pid
    if(context.query.pid){
      const {status,data} = await context.app.$axios.post('http://localhost:10010/api/search/item/ProductInf',{
        pid:pid
      })
      if(status === 200){
        // console.log(data.image)
        return {itemProduct:data,addCart:data.product}
      }
    }
  },
  methods: {
    handleChange(value) {

    },
    changeImage(inf,index){
      this.nowindex = index;
      this.imgUrl = inf
    },
    changeSize(size,index){
      this.nowSize = size
    },
    changeColor(color){
      console.log(color[1])
      this.nowColor = color[1]
      console.log(this.nowColor)
    }
  },
  computed : {
      changeImg: function(inf) {
        return this.host + this.imgUrl
      },
      //给子组件传递商品尺寸
      productSize: function(){
        return this.nowSize
      },
      //给子组件传递商品颜色
      productColorGet:function(){
        return this.nowColor
      }
  },
  async mounted(){
      //过去图片集合
      const ProductImage = this.itemProduct.image.imageAddr
      if(ProductImage){
        this.imageInf = ProductImage.split('|')
      }
      
      //默认图片
      this.imgUrl = this.imageInf[0]
      //地址前缀
      this.host = "http://localhost:8090"
      //尺寸
      const ProductSize = this.itemProduct.image.imageSize
      if(ProductSize){
        this.sizeInf = ProductSize.split('|')
      }
      const productColor = this.itemProduct.image.imageColor
      if(productColor){
        const productColorArr = []
        productColorArr.push(productColor.split('|'))
        this.productColor = productColorArr
        this.nowColor = productColor.split('|')
      }
  }
};
</script>

<style lang="scss">
@import "@/assets/css/item/item.scss";
@import "@/assets/css/cart/pay.scss";

</style>