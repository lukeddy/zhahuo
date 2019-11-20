<template>
  <div class="header-login">
    <ul>
      <li v-if="!islogin" class="header-login-li">
        <a href="/login" class="login-item-a">
          <span class="iconfont">&#xe634;</span>
          <span>登录</span>
        </a>
      </li>
      <li v-if="!islogin" class="header-login-li">
        <a href="/register" class="login-item-a">
          <span class="iconfont">&#xe608;</span>
          <span>注册</span>
        </a>
      </li>
      <li v-if="islogin" class="header-login-li">
        <a href="javascript:void(0);" class="login-item-a">
          <span class="iconfont">&#xe634;</span>
          <span>欢迎，{{username}}</span>
        </a>
      </li>
      <li v-if="islogin" class="header-login-li">
        <a class="login-item-a" href="javascript:void(0);">
          <span class="iconfont">&#xe608;</span>
          <span @click="exit">退出</span>
        </a>
      </li>
      <li v-if="cart" class="header-login-li">
        <a href="/cart" class="login-item-a">
          <span class="iconfont">&#xe62d;</span>
          <span>购物车</span>
        </a>
      </li>
    </ul>
  </div>
</template>

<script>
import { async } from 'q'
export default {
   data(){
     return{
        islogin:false,
        cart:true,
        username: '登录'
     }
   },
   async mounted(){
     /*
      判断用户是否登录 用户登录后会在客户端保存token，
      我们通过判断token是否储存在来判定用户是否登录，如果
      需要更加安全的方法可以每次在页面加载前，拿到token，去
      够短校验token是否正确
      */
     if(this.$route.path === "/cart"){
        this.cart = false
     }
     const token = localStorage.getItem("token")
     if(token != null){
       const userInf = JSON.parse(localStorage.getItem("userInf"))
       console.log(userInf.username)
        this.username = userInf.username
        this.islogin = !this.islogin;
     }
     
   },
   methods: {
     exit:function(){
       localStorage.removeItem("token")
       localStorage.removeItem("userInf")
       location.href = "/"
     }
   }
}
</script>

<style>
</style>