<template>
  <div class="J-home">
      <div class="J-home-box">
          <div class="h-content c-content-reg">
              <div class="c-register">
                  <div class="c-register-head">
                      <div class="c-register-login">
                          <div class="c-register-text">已注册</div>
                          <a href="/login" class="c-register-a">直接登录</a>
                      </div>
                      <h3 class="c-register-title">会员注册</h3>
                  </div>
                  <div class="c-register-body">
                      <div class="reg-form-wrapper">
                          <div class="reg-top" style="display:none;"></div>
                          <el-form ref="ruleForm" :model="ruleForm" :rules="rules" class="c-register-form" action="">
                              <div class="control-group reg-form-tel" prop="phone">
                                  <div class="form-item-group">
                                      <span class="tel-iconfont iconfont">&#xe647;</span>
                                      <input v-model="ruleForm.phone" @blur="phoneForm(ruleForm.phone)" :class="{'ui-input':true,'activPhnoe':active.phone}" type="text" placeholder="请输入手机号码">
                                  </div>
                                  <div class="form-input-tip" style="color:red;">{{errors.phone}}</div>
                              </div>
                              <div class="control-group">
                                  <div class="form-item-group adjust-tip-icon">
                                      <input v-model="ruleForm.code" @blur="codeForm(ruleForm.code)" :class="{'adjust-reg-code':true,'activeCode':active.code}" type="text" placeholder="请输入验证码">
                                      <span class="tel-iconfont iconfont">&#xe621;</span>
                                      <a @click="sendMsg"  :class="{'get-code':true,'send-msg-btn':send}" href="javascript:void(0);">{{stateMsg}}</a>
                                  </div>
                                  <div class="form-input-tip" style="color:red;">{{errors.code}}</div>
                              </div>
                              <div class="control-group">
                                  <div class="form-item-group">
                                      <span class="tel-iconfont iconfont">&#xe61d;</span>
                                      <input v-model="ruleForm.password" @blur="passwordForm(ruleForm.password)" :class="{'ui-input':true,'activePassword':active.password}" type="password" placeholder="密码由20位字母，数字和字符组合">
                                  </div>
                                  <div class="form-input-tip" style="color:red;">{{errors.password}}</div>
                              </div>
                              <div class="control-group">
                                  <div class="form-item-group">
                                      <input v-model="ruleForm.repassword"  @blur="repasswordForm(ruleForm.repassword)" :class="{'ui-input':true,'activeRepassword':active.repassword}" type="password" name="regPwd" placeholder="请再次输入密码" />
                                      <span class="tel-iconfont iconfont">&#xe61d;</span>
                                  </div>
                                  <div class="form-input-tip" style="color:red;">{{errors.repassword}}</div>
                              </div>
                              <div class="control-group">
                                  <div class="form-item-group">
                                      <div class="ui-checkbox">
                                          <span :class="{'form-label':true, 'iconfont':true,'checkbox':checkbox}" @click="checkboxBtn">&#xe61b;</span>
                                      </div>
                                      <div class="ui-position-txt" >
                                          <span :class="{'text':true}" >
                                            我已阅读并接受一下条款:
                                            </span>
                                          <a href="javascript:void(0);">《服务条框》</a>
                                          <a href="javascript:void(0);">《隐私条款》</a>
                                          <a href="javascript:void(0);">《用户服务协议》</a>
                                      </div>
                                  </div>
                                  <div class="form-input-tip"></div>
                              </div>
                              <div class="control-group md30">
                                  <div class="form-item-group">
                                      <a href="javascript:void(0);">
                                          <span type="primary" @click="register" class="register-before">立即注册</span>
                                      </a>
                                  </div>
                              </div>
                          </el-form>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
</template>

<script>
export default {
  data() {
      return {
          send:false,
          stateMsg: '获取验证码',
          success:{
            phone: false,
            code: false,
            password: false,
            repassword: false
          },
          active:{
              phone: false,
              code: false,
              password: false,
              repassword: false
          },
          errors:{
              phone: '',
              code: '',
              password: '',
              repassword: ''
          },
          ruleForm: {
              phone: '',
              code: '',
              password: '',
              repassword: ''
          },
          rules: {
          },
          checkbox:false
      }
  },
  layout: 'userlayout',
  computed:{
      
  },
  methods: {
      checkboxBtn(){
          this.checkbox = !this.checkbox
      },
      phoneForm(phone){
          console.log(phone)
          if(phone === ''){
              this.errors.phone = '请输入手机号'
              this.active.phone = true
              return
          }
          if(phone.length !== 11 && phone.length != 0){
              this.errors.phone = '手机号格式不正确'
              this.active.phone = true
              return
          }
          var reg = /^[0-9]+\.?[0-9]*$/;
          if(phone.length === 11 && reg.test(phone)){
              this.errors.phone = ''
              this.active.phone = false
              this.success.phone = true
          }else{
              this.errors.phone ='手机号格式不正确'
              this.active.phone = true
          }
      },
      codeForm(code){
          console.log(code)
          if(code === ''){
              this.errors.code = '请输入验证码'
              this.active.code = true
          }
          if(code.length !== 6 && code.length != 0){
              this.errors.code = '验证码为六位随机数字组成'
              this.active.code = true
          }
          var reg = /^[0-9]+\.?[0-9]*$/;
          if(code.length === 6 && reg.test(code)){
              this.errors.code = ''
              this.active.code = false
              this.success.code = true
          }else{
              this.errors.code ='验证码为六位随机数字组成'
              this.active.code = true
          }
      },
       passwordForm(password){
          console.log(password.length)
          if(password.length === 0){
              this.errors.password = '请输入密码，密码为8-18位的数字、字符串、特殊字符组成'
              this.active.password = true
              return
          }
          if(password.length <= 8 && password.length >= 18){
              this.errors.password = '密码为8-18位的数字、字符串、特殊字符组成'
              this.active.password = true
              return
          }
          if(password.length >= 8 && password.length <= 18){
              this.errors.password = ''
              this.active.password = false
              this.success.password = true
              return
          }
      },
       repasswordForm(repassword){
          if(repassword.length === 0){
              this.errors.repassword = '密码不能为空'
              this.active.repassword = true
              return
          }
          if(repassword === this.ruleForm.password){
              this.errors.repassword = ''
              this.active.repassword = false
              this.success.repassword = true
              return
          }else{
              this.errors.repassword = '两次输入密码不一致'
              this.active.repassword = true
          }
      },
      //发送验证码
      sendMsg: function(){
          const self = this
          var sendInf = self.send
          var count = 0
          //判断是否输入号码，以及格式是否正确
          self.phoneForm(self.ruleForm.phone)
          if(self.success.phone !== true){
              return
          }
          //判断是否已经发送短信，避免二次点击
          //发送短信
          if(self.send == true){
              return
          }
          self.send = true
          self.$axios.post('http://localhost:10010/api/user/user/registerCode',{
           phone:self.ruleForm.phone
          }).then(({status,data}) => {
              console.log(status)
              console.log(data)
              if(status === 200){
                  count = 60;
                  self.stateMsg = `剩余${count--}秒`
                  self.timerid = setInterval(function () {
                      self.stateMsg = `剩余${count--}秒`
                      if (count === 0) {
                        self.stateMsg = '获取验证码'
                        self.send = false
                        clearInterval(self.timerid)
                        
                      }
                  }, 1000)
              }else{
                  alert("验证码获取失败");
              }
          })
      },
      //注册
      register: function(){
          if(this.success.phone != true || this.success.code != true || this.success.password != true || this.success.repassword != true){
            this.phoneForm(this.ruleForm.phone)
            this.codeForm(this.ruleForm.code)
            this.passwordForm(this.ruleForm.password)
            this.repasswordForm(this.ruleForm.repassword)
            return
          }

          const loading = this.$loading({
            lock: true,
            text: 'Loading',
            spinner: 'el-icon-loading',
            background: 'rgba(0, 0, 0, 0.7)'
           });
          setTimeout(() => {
            loading.close();
          }, 20000);

          let self = this;
          self.$axios.post('http://localhost:10010/api/user/user/register',{
              phone: self.ruleForm.phone,
              code: self.ruleForm.code,
              password: self.ruleForm.password,
              repassword: self.ruleForm.repassword
          }).then(({status,data}) => {
              if(status === 200 && data == 'success'){
                  console.log('注册成功');
                  location.href = '/login'
              }else if(data == 'notfound'){
                  console.log('注册失败');
                  loading.close();
              }
          })
      }
  }
}
</script>

<style lang="scss">

@import "@/assets/css/register/register.scss";
</style>