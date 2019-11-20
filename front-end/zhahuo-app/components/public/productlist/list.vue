<template>
  <div class="el-col-list">
      <div class="nav-class-box">
          <dl class="nav">
              <dt class="nav-dt">
                <a href="javascript:void(0);">
                    <span class="nav-class-iconfont iconfont"></span>
                    <span class="nav-class-text">商品分类</span>
                </a>
              </dt>
              <dd class="nav-class-list">
                <ul class="nav-category"  @mouseleave="mouseleave">
                    <li class="nav-class-item"  @mouseenter="enter" v-for="(item,index) in 11" :key="index">
                        <a :href="'/category?cid='+ category[index * 3].cid" :class="'type' + (index * 3 + 1)" v-if="category[index * 3] != undefined">{{category[index * 3].cname}}</a>
                        <a :href="'/category?cid='+ category[index * 3 + 1].cid" :class="'type' + (index * 3 + 2)" v-if="category[index * 3 + 1] != undefined">{{category[index * 3 + 1].cname}}</a>
                        <a :href="'/category?cid='+ category[index * 3 + 2].cid" :class="'type' + (index * 3 + 3)" v-if="category[index * 3 + 2] != undefined">{{category[index * 3 + 2].cname}}</a>
                    </li>
                </ul>
              </dd>
          </dl>
          <div class="detail" v-if="kind" @mouseenter="sover" @mouseleave="sout">
             <div class="nav-pop-list">
                 <div class="nav-pop-item">
                     <div class="nav-pop-col1">
                         <ul class="nav-pop-detail">
                             <li class="nav-panal-item" v-for="(item,index) in curdetail" :key="index">
                                 <h3 class="detail-h3">
                                     <span class="h3-product-type">{{item.cname}}</span>
                                     <a href="javascript:void(0);" class="detail-more-a">
                                         <span>更多</span>
                                         <span class="iconfont">&#xe626;</span>
                                     </a>
                                 </h3>
                                 <p class="datail-p">
                                     <a v-for="(bread,idx) in item.zhCategoryTow" :key="idx" :href="'/category?bid='+ bread.bid">{{bread.bname}}</a>
                                 </p>
                             </li>
                         </ul>
                     </div>
                     <div class="nav-pop-col2">
                         <div class="nav-pop-brand"></div>
                     </div>
                 </div>
             </div>
          </div>
      </div>
  </div>
</template>

<script>

export default {
  data(){
    return {
      category: [],
      kind: ''
    }
  },
  async mounted(){
    const {status,data} = await this.$axios.get('http://localhost:10010/api/item/item/category')
    if(status === 200){
      this.category = data
      // console.log(this.category)
    }else{
      console.log('category error')
    }
  },
  computed: {
    curdetail : function(){
    let arr =  this.category.filter(item => item.cid === this.kind[0] || item.cid === this.kind[1] ||item.cid === this.kind[2] )
      console.log(this.category.filter(item => item.cid === this.kind[0] || item.cid === this.kind[1] ||item.cid === this.kind[2] ))
      return arr
    }
  },
  methods: {
      enter:function (e) {
        let element = e.target.querySelectorAll('a')
        const elementArr = []
        for(let e = 0 ; e < 3 ; e++){
          elementArr.push(parseInt(element[e].className.substring(4,element[e].className.length)))
        }
        this.kind = elementArr;
      },
      mouseleave:function(e){
        let self=this;
        self._timer=setTimeout(function(){
          self.kind=''
      },10)
      },
      sover:function(e){
        clearTimeout(this._timer)
      },
      sout:function(e){
          this.kind = ''
      }
  }
  
}
</script>

<style lang="scss">
@import "@/assets/css/public/list/list.scss";
</style>