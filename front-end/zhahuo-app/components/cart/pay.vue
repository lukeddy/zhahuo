<template>
  <div class="product-fix-bar follow">
      <div class="fix-bar-wrapper">
          <div class="bar-text">您已选择了</div>
          <div class="bar-device-info">
              <h1 class="clearfix">
                  <span class="title">{{payData.pname}}</span>
              </h1>
              <h2>{{payData.pdesc}}</h2>
          </div>
          <el-button class="bar-btn" :plain="true"  @click="addCart">加入购物车</el-button>
          <!-- <div class="bar-btn" @click="addCart">加入购物车</div> -->
          <div class="bar-btn white-btn">
              <a href="javascript:void(0);" @click="nowPay">现在购买</a>
          </div>
          <div class="no-discount-price">
              <div class="bar-price">
                  <span class="price-tip">￥</span>
                  <span class="price">{{payData.marketPrice}}</span>
              </div>
          </div>
      </div>
  </div>
</template>

<script>
export default {
    props: ['payData','paySize','payColor','payNum'],
    data() {
        return {
            PayData: this.payData
        }
    },
    methods: {
        async addCart() {
            const token =  localStorage.getItem('token')
            if(token !== null){
                const u = JSON.parse(localStorage.getItem('userInf')).uid
                const CartProduct = {
                    pid:this.payData.pid,
                    pname:this.payData.pname,
                    marketPrice:this.payData.marketPrice,
                    pimage:this.payData.pimage,
                    count:this.payNum,
                    color:this.payColor[0],
                    size:this.paySize,
                    uid:u
                }
                console.log(this.payColor[0])
                if(this.paySize == ''){
                    alert("请选择商品尺寸")
                    return
                }
                const {status,data} = await this.$axios.post('http://localhost:10010/api/cart/addCart',CartProduct)
                if(status === 200){
                    this.open('success')
                    console.log(data)
                }
                return
            }
            //判断事件是否触发
            if(navigator.cookieEnabled) {
               if(this.paySize !== ''){
                   if(this.payColor !== ''){
                    //获取即将添加到购物车中的信息
                    const product = {
                        pid:this.payData.pid,
                        pname:this.payData.pname,
                        marketPrice:this.payData.marketPrice,
                        pimage:this.payData.pimage,
                        count:this.payNum,
                        color:this.payColor[0],
                        size:this.paySize
                     }
                    //  console.log(product)
                     //将信息添加到购物车中
                     //获取已经在购物车中的信息
                     var productCart = this.getCookie('productsCart')
                     console.log("-===========")
                     console.log(productCart)
                     if(productCart === null)
                        //cookie中不存在商品信息
                        productCart = []
                     else
                        //已经存在信息
                        productCart = JSON.parse(productCart)
                        if(productCart.length != 0){
                            for(let pro in productCart){
                                if(productCart[pro].pid === this.payData.pid && productCart[pro].color[1] === this.payColor[1] && productCart[pro].size === this.paySize){
                                    console.log("pid相等")
                                    // let sum = parseInt(productCart[pro].count)
                                    // sum += this.payNum
                                    // console.log(sum)
                                    // productCart[pro].count = sum + ''
                                    // console.log(productCart[pro].count)
                                    productCart[pro].count += this.payNum
                                    console.log(productCart)
                                    this.getCookie("productsCart",JSON.stringify(productCart),{expires:7})
                                    this.open('success')
                                    return
                                }
                            }
                            
                        }
                        //将当前商品追加到数组中
                        productCart.push(product)
                        console.log(productCart)
                        
                        //继续将购物车信息数组存入cookie中
                        this.getCookie("productsCart",JSON.stringify(productCart),{expires:7})
                        this.open('success')

                   }else{
                       alert('请选择商品颜色!')
                   }
               }else{
                   alert('请选择商品尺寸!')
               }
                
            } else {
                alert("你的浏览器不支持cookie")
            }


            //将信息加入购物车中
            // const {status} = await this.$axios.post('',{

            // })
        },

        async nowPay() {
            //判断事件是否触发
            console.log("现在购买");
            //判断用户是否登录
            if(localStorage.getItem('token') == null){
                //没有登录跳转到登录界面
                location.href = '/login'
            }
            //支付界面
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
                console.log(options)
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
                //路径，通过设置路径可以让不同的cookie进行共享
                options.path = '/'
                if(typeof options.path !== "undefined"){
                    cookie += ";path=" + options.path
                    console.log(options.path)
                }
                //域名
                console.log(options.domain)
                if(typeof options.domain !== "undefined"){
                    cookie += ";domain=" + options.domain
                }
                //建立安全连接
                if(options.secure){
                    cookie += ";secure"
                }
                //保存
                
                console.log(decodeURIComponent(cookie))
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
                message: '已添至购物车',
                type: success
            });
        }
    },
    mounted(){
    }
}
</script>

<style>

</style>