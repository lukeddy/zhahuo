<template>
  <div class="wrapper-cart">
      <div  v-if="isLogin" class="is-login" >
          <div class="page-cart">
              <div class="gray-box gray-bottom-fixed">
                  <div class="title">
                      <h2>购物清单</h2>
                  </div>
                  <div class="box-inner">
                      <div>
                          <div class="cart-table-title">
                              <span class="name">商品信息</span>
                              <span class="operation">操作</span>
                              <span class="subtotal">小计</span>
                              <span class="num">数量</span>
                              <span class="price">单价</span>
                          </div>
                          <div class="cart-table">
                              <div class="item-list have-margin">
                                  <div class="cart-group">
                                      <div class="divide" v-for="(item,idx) in cartInf" :key="idx">
                                          <div class="cart-items">
                                              <div class="cart-item">
                                                  <div class="checkbox-container">
                                                      <div class="get-product">
                                                          <span @click="addOrder(item,idx)" :class="{'m-blue-checkbox-new':true,'iconfont':true,'active': iconfont.includes(idx)}">&#xe61b;</span>
                                                      </div>
                                                  </div>
                                                  <div class="item-wrapper">
                                                      <div class="items-thumb">
                                                          <img :src="item.pimage" alt="Smartisan Polo衫 经典款">
                                                          <a :href="'/item/?pid=' + item.pid"></a>
                                                      </div>
                                                      <div class="name hide-row">
                                                          <div class="name-table">
                                                              <a :href="'/item/?pid=' + item.pid">{{item.pname}}</a>
                                                              <ul class="attribute clearfix">
                                                                  <li>{{item.color}}</li>
                                                                  <li>{{item.size}}</li>
                                                              </ul>
                                                          </div>
                                                      </div>
                                                      <div class="operation">
                                                          <a href="javascript:void(0);" @click="deleteCartInf(item)" class="items-delete-btn1">
                                                              <span class="iconfont">&#xe676;</span>
                                                          </a>
                                                      </div>
                                                      <div class="subtotal-box">
                                                          <div class="subtotal">
                                                              <span>￥</span>
                                                              <span>{{item.marketPrice * item.count}}</span>
                                                          </div>
                                                          <div class="item-cols-num">
                                                              <div class="quantity">
                                                                  <el-input-number v-model="item.count" @change="handleChange(item.count,item,idx)" :min="1" :max="10" label="描述文字"></el-input-number>
                                                              </div>
                                                          </div>
                                                          <div class="price">
                                                              <span>￥</span>
                                                              <span>{{item.marketPrice}}</span>
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
                  <div class="cart-bottom-bg fix-bottom fix-bottom-fixed">
                      <div class="fix-bottom-inner">
                          <div class="cart-bar-operation">
                              <div class="choose-all js-choose-all">
                                  <div class="m-blue-checkbox-new">
                                      <span :class="{'iconfont':true ,'checkbox-iconfont':true ,'active':isChooseIcon}" @click="chooseCheck()">&#xe61b;</span>
                                  </div>
                                  <span class="text-choose-all">{{isCheckAll ? '清空' : '全选'}}</span>
                              </div>
                              <div class="delete-choose-goods disabled-link" @click="deleteAll">删除选中的商品</div>
                          </div>
                          <div class="shipping">
                              <div class="shipping-box">
                                  <div class="shipping-total shipping-num">
                                      <h4>已选择
                                          <span>{{productCount}}</span>件商品
                                      </h4>
                                      <h5>共计
                                          <span>{{allProductCount}}</span>件商品
                                      </h5>
                                  </div>
                                  <div class="shipping-total shipping-price">
                                      <h4 class="">
                                          应付总额
                                          <span>￥</span>
                                          <span>{{price}}</span>
                                      </h4>
                                      <h5 class="shipping-tips">应付总额不含运费</h5>
                                  </div>
                              </div>
                              <span class="jianguo-blue-main-btn big-main-btn js-checkout disabled-btn">
                                  <a  @click="pay()">现在结算</a>

                              </span>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <div v-if="noLogin" class="no-login">
          <div class="wrapper-cart-box">
              <div class="cart-top">
                  购物清单
              </div>
              <div class="cart-center">
                <div class="empty-label">
                    <h3>购物车中还没有商品</h3>
                    <a class="login-btn" href="/login">登录</a>
                    <a class="link-btn" href="/">现在选购</a>
                </div>
              </div>
          </div>
      </div>
    <el-dialog style="z-index:!important" title="提示" :visible.sync="dialogVisible" heigth="100px" width="20%" :before-close="handleClose">
        <span>用户没有登录，是否跳转到登录界面</span>
        <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="goLoginPage()">确 定</el-button>
        </span>
    </el-dialog>
  </div>
</template>

<script>
import { async } from 'q';
export default {
    props : [],
    data() {
      return {
        num1: 1,
        isLogin:'',
        noLogin:'',
        cartInf:[],
        productOrderInf:[],
        iconfont:[],
        dialogVisible:false
      }
    },
    methods: {
        openFullScreen2() {
            const loading = this.$loading({
            lock: true,
            text: 'Loading',
            spinner: 'el-icon-loading',
            background: 'rgba(0, 0, 0, 0.7)'
            });
            setTimeout(() => {
            loading.close();
            }, 2000);
        },
        goLoginPage(){
            this.dialogVisible = false
            location.href = '/login'
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
            .then(_ => {
                done();
            })
            .catch(_ => {});
        },
        async deleteAll(){
            const self = this
            var delProductInf = self.productOrderInf
            // console.log(self.productOrderInf)
            //判断用户是否登录
            const token =  localStorage.getItem('token')
            if(token != null){
                if(delProductInf != null){
                    // const {status,data} = await self.$axios.post('http://localhost:10010/api/cart/deleteById',{
                    //     cartId:item.cartId
                    // })
                    console.log('登录转态下批量删除商品')

                }else{
                    return
                }
            }else{
                console.log("商品批量删除，没有登录状态，暂未完成")
            }
            
            
        },
        async pay(){
            const self = this
            console.log(this.productOrderInf)
            //在支付之间我们需要判断用户是否登录
            const token =  localStorage.getItem('token')
            if(token != null){
                if(this.iconfont.length == 0){
                    alert("请选择支付商品")
                    return
                }
                //已登录
                //获取登录用户信息
                const user = localStorage.getItem('userInf')
                // console.log(user)
                var orderInf = this.productOrderInf
                if(orderInf.length === 0){
                    return
                }
                //加载
                const loading = this.$loading({
                    lock: true,
                    text: 'Loading',
                    spinner: 'el-icon-loading',
                    background: 'rgba(0, 0, 0, 0.7)'
                });
                setTimeout(() => {
                    loading.close();
                }, 20000)
                const u = JSON.parse(localStorage.getItem("userInf")).uid
                var order = new Array();
                for(let i in orderInf){
                    // console.log(user.uid)
                    orderInf[i]['color'] = orderInf[i].color[0]
                    orderInf[i]['uid'] = u
                    order.push(orderInf[i])
                    // console.log(orderInf[i])
                }
                //将订单信息打包发送给后台
                const {status,data} = await self.$axios.post('http://localhost:10010/api/order/toPay',order)
                if(status === 200){
                    console.log(data)
                    const div=document.createElement('divform');
                    console.log(div)
                    div.innerHTML=data; // data就是接口返回的form 表单字符串
                    document.body.appendChild(div);
                    //document.forms[0].setAttribute('target', '_blank') // 新开窗口跳转
                    document.forms[0].submit()
                }else{
                    console.log("失败")
                }
            }else{
                console.log("没有登录我们将跳转到登录界面")
                this.dialogVisible = true
            }
        },
        async handleChange(count,item,index) {
          const self = this
          const cartinf = self.cartInf
          const token =  localStorage.getItem('token')
          if(token !== null){
              //已登录
            //   console.log(item)
              const {status,data} = await self.$axios.post('http://localhost:10010/api/cart/saveByCart',item)
              if(status === 200){
                //   console.log(data)
                  for(let e in cartinf){
                      if(cartinf[e].cartId === item.cartId){
                          cartinf[e].count =item.count
                      }
                  }
                //   console.log(cartinf)
              }
          }else{
              //游客
            var productCartNoToken = this.getCookie('productsCart')
            productCartNoToken = JSON.parse(productCartNoToken)
            // console.log(productCartNoToken)
            for(let e in productCartNoToken){
                // console.log(item)
                // console.log(productCartNoToken[e])
                if(productCartNoToken[e].pid === item.pid && productCartNoToken[e].color[1] === item.color[1] && productCartNoToken[e].size === item.size){
                    
                    productCartNoToken[e].count = count
                }
            }
            // console.log(productCartNoToken)
            this.cartInf = productCartNoToken
            this.getCookie("productsCart",JSON.stringify(productCartNoToken),{expires:7})
            this.open('success')
            if(this.iconfont.includes(index)){
                var productOrder = this.productOrderInf
                for(let i in productOrder){
                    if(productOrder[i].pid === item.pid && productOrder[i].size === item.size && productOrder[i].color[1] === item.color[1]){
                        productOrder.splice(i,1)
                    }
                }
                productOrder.push(item)
            }
          }
        },
        async deleteCartInf(item){
            const self = this
            const token =  localStorage.getItem('token')
            if(token !== null){
                const {status,data} = await self.$axios.post('http://localhost:10010/api/cart/deleteById',{
                     cartId:item.cartId
                })
                if(status === 200){
                    console.log(data)
                    var cartInfDelAfter = self.cartInf
                    for(let i in cartInfDelAfter){
                        if(cartInfDelAfter[i].cartId === item.cartId){
                            cartInfDelAfter.splice(i,1)
                        }
                    }
                    console.log(cartInfDelAfter)
                    self.cartInf = cartInfDelAfter
                }else{
                    console.log("删除失败")
                }
            }else{
                // console.log(item)
                var productCartNoToken = this.getCookie('productsCart')
                productCartNoToken = JSON.parse(productCartNoToken)
                for(let e in productCartNoToken){
                    if(productCartNoToken[e].pid === item.pid && productCartNoToken[e].color[1] === item.color[1] && productCartNoToken[e].size === item.size){
                       console.log(111111)
                       productCartNoToken.splice(e,1)
                    }
                }
                if(productCartNoToken.length === 0){
                    this.isLogin = false
                    this.noLogin = true
                }
                this.getCookie("productsCart",JSON.stringify(productCartNoToken),{expires:7})
                // console.log(productCartNoToken)
                this.cartInf = productCartNoToken
            }
        },
        //读取cookie
        getCookie(key,value,options){
            if(navigator.cookieEnabled){
                //如果没有传递value,则表示根据key读取cookie值。
                if(typeof value === "undefined") {
                    //获取当前域下的所有cookie保存到cookies数组中
                    const cookies = document.cookie.split('; ')
                    //遍历cookies数组中的每个元素
                    for(let i = 0; i < cookies.length; i++){
                        //获取每个cookie的键和值
                        let cookie = cookies[i].split('=')
                        //判断是否是需要查找的key
                        if(decodeURIComponent(cookie[0]) === key){
                            return decodeURIComponent(cookie[1])
                        }
                    }
                    //没有找到返回null
                    return null
                }
                //设置options默认未空对象
                options = options || {}
                // console.log(options)
                //对key和value进行编码
                var cookie = encodeURIComponent(key) + "=" + encodeURIComponent(value)
                //设置失效时间
                if((typeof options.expires) !== "undefined"){
                    if(typeof options.expires === "number"){//有配置失效时间
                        const days = options.expires
                        const t = options.expires = new Date()
                        t.setDate(t.getDate() + days)
                    }
                    cookie += ";expires=" + options.expires.toUTCString()
                }
                //路径
                if(typeof options.path !== "undefined"){
                    cookie += ";path=" + ''
                    console.log(options.path)
                }
                //域名
                if(typeof options.domain !== "undefined"){
                    cookie += ";domain=" + options.domain
                }
                // console.log(cookie)
                //建立安全连接
                if(options.secure){
                    cookie += ";secure"
                }
                //保存
                document.cookie = cookie
            }else{
                alert("你的浏览器不支持cookie")
            }
        },
        removeCookie(key,options){
            options = options || {}
            options.expires = -1
            this.getCookie(key,"",options)
        },
        open(success){
            this.$message({
                message: '更改成功',
                type: success
            });
        },
        addOrder(item,index){
            var productOrder = this.productOrderInf
            var idx = this.iconfont.indexOf(index)
            if(idx >- 1){
                this.iconfont.splice(idx,1)
            }else{
                this.iconfont.push(index)
            }
            for(let i in productOrder){
                if(productOrder[i].pid === item.pid && productOrder[i].size === item.size && productOrder[i].color[1] === item.color[1]){
                    productOrder.splice(i,1)
                    return
                }
            }
            productOrder.push(item)
        },
        checkeAll(){
            const cartInf = this.cartInf
            var len = cartInf.length
            this.iconfont = []
            for(var i = 0; i < len; i++){
                this.iconfont.push(i)
            }
            for(let e in cartInf){
               this.productOrderInf.push(cartInf[e])
            }
        },
        clearCheckbox(){
            this.iconfont = []
            this.productOrderInf = []
        },
        chooseCheck(){
            if(this.isCheckAll){
                this.clearCheckbox()
            }else{
                this.checkeAll()
            }
        },
        cartInfChange(data){
            for(let ct in data){
                data[ct]['pid'] = data[ct].pid
                data[ct]['uid'] = data[ct].uid
                data[ct]['pname'] = data[ct].cartProductName
                delete data[ct].cartProductName
                data[ct]['marketPrice'] = data[ct].cartProductMp
                delete data[ct].cartProductMp
                data[ct]['pimage'] = data[ct].cartProductImage
                delete data[ct].cartProductImage
                data[ct]['count'] = data[ct].cartProductCount
                delete data[ct].cartProductCount
                data[ct]['color'] = data[ct].cartProductColor
                delete data[ct].cartProductColor
                data[ct]['size'] = data[ct].cartProductSize
                delete data[ct].cartProductSize
            }
            return data
        }
    },
    computed: {
        isChooseIcon(){
            if(this.iconfont.length == this.cartInf.length){
                return true
            }else{
                return false
            }
        },
        isCheckAll(){
            if(this.iconfont.length == this.cartInf.length){
                return true
            }else{
                return false
            }
        },
        allProductCount:function(){
            const cartData = this.cartInf
            let count = 0
            for(let i in cartData){
               count += cartData[i].count
            }
            return count
        },
        price:function(){
            const productOrderInf = this.productOrderInf
            // console.log(productOrderInf)
            let tatolPrice = 0
            if(productOrderInf.length <= 0 ){
                return '0.00'
            }
            for(let i in productOrderInf){
               tatolPrice += productOrderInf[i].marketPrice * productOrderInf[i].count
            }
            return tatolPrice
        },
        productCount:function(){
            const productOrderInf = this.productOrderInf
            let productCount = 0
            if(productOrderInf.length <= 0 ){
                return '0'
            }
            for(let i in productOrderInf){
                productCount += productOrderInf[i].count
            }
            return productCount
        }
        
    },
    async mounted(){
        const self = this
        const token =  localStorage.getItem('token')
        self.cartInf = ''
        // console.log("是否登录" +token)
        //已经登录
        if(token !== null){
            const u = JSON.parse(localStorage.getItem('userInf')).uid
            const {status,data} = await self.$axios.post('http://localhost:10010/api/cart/findCartByUid',{
                uid:u
            })
            if(status === 200){
                console.log(data)
                var ct = self.cartInfChange(data)
                // for(let ct in data){
                //     data[ct]['pid'] = data[ct].pid
                //     data[ct]['uid'] = data[ct].uid
                //     data[ct]['pname'] = data[ct].cartProductName
                //     data[ct]['marketPrice'] = data[ct].cartProductMp
                //     data[ct]['pimage'] = data[ct].cartProductImage
                //     data[ct]['count'] = data[ct].cartProductCount
                //     data[ct]['color'] = data[ct].cartProductColor
                //     data[ct]['size'] = data[ct].cartProductSize
                // }
                //将值赋值该
                console.log(ct)
                this.cartInf = ct
            }else{
                console.log("登录转态下获取购物车数据失败")
            }
            self.isLogin = true
        }else{//没有登录
            var productCartNoToken = this.getCookie('productsCart')
            // console.log(typeof productCartNoToken)
            if(productCartNoToken !== null){
               if(productCartNoToken != '[]'){
                // console.log("nologin")
                this.isLogin = true
                productCartNoToken = JSON.parse(productCartNoToken)
                this.cartInf = productCartNoToken
               }else{
                this.isLogin = false
                this.noLogin = true
               }
            }else{
                this.isLogin = false
                this.noLogin = true
            }
            
        }
    }
}
</script>

<style>

</style>