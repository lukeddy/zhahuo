<template>
  <div class="J-home">
    <div class="J-home-box">
      <div class="h-content">
        <div class="h-login-panal">
          <div class="h-login-body">
            <div class="login-body-tab">
              <div class="h-login-nav">
                <div class="h-tab-nav tab-nav-item-qr is-nav-tab-active">账户登录</div>
                <div class="h-tab-nav tab-nav-item">扫码登录</div>
              </div>
              <div class="h-login-context">
                <div class="h-tab-panal J-tab-panal">
                  <div class="h-login-form">
                    <form class="h-login-form-list" action="">
                      <div class="login-form-top"></div>
                      <div class="h-form-text">
                        <div class="form-text-user">
                          <span class="user-iconfont iconfont">&#xe634;</span>
                          <input v-model="username" type="text" class="j-username" placeholder="邮箱/用户名/手机号">
                        </div>
                        <div class="form-text-tis"></div>
                      </div>
                      <div class="h-form-pwd">
                        <div class="form-pwd-user">
                          <span class="key-iconfont iconfont">&#xe63b;</span>
                          <input v-model="password" type="password" class="j-password" placeholder="密码">
                        </div>
                        <div class="form-pwd-tis"></div>
                      </div>
                      <div class="h-form-rem">
                        <div class="form-auto-login">
                          <span class="remenber-iconfont iconfont">&#xe61b;</span>
                          <span>自动登录</span>
                        </div>
                        <div class="form-other-method">
                          <a href="">忘记密码</a>
                          <span class="iconfont method-iconfont">&#xe61f;</span>
                          <a href="/register">立即注册</a>
                        </div>
                      </div>
                      <div class="h-form-btn">
                        <span class="submit-btn disabled" type="primary" @click="login">登录</span>
                      </div>
                    </form>
                  </div>
                </div>
                <div class="h-tab-panal J-tab-panal h-hidden" style="display:none;">
                  <div class="J-qr">
                    <div class="J-pr-group">
                      <div class="J-qr-row">
                          <div class="J-qr-img-wrapper">
                            <img src="" alt="扫码登录">
                          </div>
                      </div>
                      <div class="J-qr-guide-text"></div>
                    </div>
                    <div class="J-qr-group J-qr-success"></div>
                    <div class="J-qr-group J-qr-error"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="h-login-foot">
            <div class="h-login-third">
              <span class="h-login-title">其他登录方式:</span>
              <ul class="">
                <li class="other-login-li">
                  <a href="javascript:void(0);">
                    <span class="iconfont other-login-md1">&#xe639;</span>
                  </a>
                </li>
                <li class="other-login-li">
                  <a href="javascript:void(0);">
                    <span class="iconfont other-login-md2">&#xe637;</span>
                  </a>
                </li>
                <li class="other-login-li">
                  <a href="javascript:void(0);">
                    <span class="iconfont other-login-md3">&#xe642;</span>
                  </a>
                </li>
                <li class="other-login-li">
                  <a href="javascript:void(0);">
                    <span class="iconfont other-login-md4">&#xe6a9;</span>
                  </a>
                </li>
              </ul>
              <a href="" class="h-more-foot">
                <span>更多</span><span class="iconfont">&#xe626;</span>
              </a>
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
      username:'',
      password:''
    }
  },
  layout: 'userlayout',
  methods: {
    async login(){
      //保存当前this
      let self = this;
      var timer
      if(this.username.length == 0 && this.password == 0){
        return
      }

      //加载
      const loading = this.$loading({
        lock: true,
        text: 'Loading',
        spinner: 'el-icon-loading',
        background: 'rgba(0, 0, 0, 0.7)'
      });

      timer = setTimeout(function() {
        loading.close();
      }, 20000);
      //进行表单验证

      //表单验证成功，发送axios请求进行登录
      self.$axios.post('http://localhost:10010/api/auth/login',{
        username:self.username,
        password:self.password
      }).then(({status,data}) => {
        //回调
        if(data.code === 200) {
          console.log("登录成功:" + data.data.token);
          //保存token和用户信息到localstorage中
          const token = data.data.token
          const userInf = data.data.admin
          if(token != null && userInf != null){
            localStorage.setItem('token',token)
            //把用户信息这个对象存储进localstorage
            localStorage.setItem('userInf',JSON.stringify(userInf))
            //登录成功后我们查看有没有cookie
            var productCartNoToken = this.getCookie('productsCart')
            if(productCartNoToken === null || productCartNoToken.length === 0){
                location.href = "/"
                return
            }
            //获取cookie 中的数据
            productCartNoToken = JSON.parse(productCartNoToken)
            //将cookie中购物车信息保存到数据库中 对数据进行整理

            //获取用户信息
            const userId = JSON.parse(localStorage.getItem('userInf')).uid
            console.log(userId)
            for(let i in productCartNoToken){
                productCartNoToken[i]['uid'] = userId
                productCartNoToken[i]['color'] = productCartNoToken[i].color[0]
            }
            console.log(productCartNoToken)
            self.$axios.post('http://localhost:10010/api/cart/saveCartList',productCartNoToken).then(({status,data}) =>{
              // console.log(data)
              if(status === 200){
                console.log("yes")
               self.removeCookie("productsCart",null)
                self.password = ''
                self.username = ''
                location.href = '/'
                loading.close();
              }else{
                console.log("登录失败")
                loading.close();
              }
            })
          }
        }else if(data.code === 404){
          this.password = ''
          this.username = ''
          alert("用户名或密码错误!!!")
          loading.close();
        }
      })
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
  }

}
</script>

<style lang="scss">
@import "@/assets/css/login/login.scss";
</style>