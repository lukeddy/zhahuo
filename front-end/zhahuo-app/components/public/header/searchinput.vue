<template>
  <div class="el-col-searchinput">
    <div class="nav-search-bar">
      <form class="nav-search-form">
        <input type="text" v-model="searchText" @blur="btnBlur" @focus="btnFocus"/>
        <button class="search-btn" type="button" >
            <span class="iconfont" @click="search()">&#xe6a8;</span>
        </button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      searchText:''
    }
  },
  methods:{
    async search(){
      console.log("123")
      return
    },
    async btnBlur(){
      //获取输入框中的值
      var keyword = this.searchText
      if(keyword.length === 0){
        return
      }
      console.log(keyword)
      //发送请求
      location.href = '/category?keyword=' + keyword
    },
    btnFocus(){
      console.log("focus")
    }
  }
}
</script>

<style>

</style>