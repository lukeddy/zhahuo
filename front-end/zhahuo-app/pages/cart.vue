<template>
  <div class="cart-root-bag">
      <div class="cart-box">
        <cart-page/>
      </div>
      <div class="recommend-box">
        <recommend/>
      </div>
  </div>
</template>

<script>
import Recommend from '@/components/public/productlist/recommend.vue'
import CartPage from '@/components/cart/cartpage.vue'

export default {
  layout:'cartlayout',
  components: {
    Recommend,
    CartPage
  },
  data() {
    return {
    }
  },
  async asyncData(){
    console.log(1)
  },
  async mounted(){

  }
  
}
</script>

<style lang="scss">
@import "@/assets/css/cart/cart.scss";
@import "@/assets/css/public/header/topbar.scss"; 
</style>