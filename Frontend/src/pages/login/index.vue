<template>
  <div class="container">
    <div class="h_panel">
      <router-link to="/" class="logo">
        <img src="" alt="">
      </router-link>
    </div>
    <div class="login_panel">
      <a href="#"></a>
      <div class="form_panel">
        <div class="qrcode_panel" v-if="qrcode_login">
          <img src="../../assets/qrcode.png" alt="">
        </div>
        <div class="tabs">
          <a href="#" class="tabs_account" :class="qrcode_login ? '' : 'a-activity'" v-on:click="account_onclick()">账号登录</a>
          <span>|</span>
          <a href="#" class="tabs_qrcode" :class="qrcode_login ? 'a-activity' : ''" v-on:click="qrcode_onclick()">扫码登录</a>
        </div>
        <input type="text" v-model="username" name="username" placeholder="邮箱/手机号码/小米ID">
        <input type="password" v-model="password" name="password" placeholder="密码">
        <div class="login-btn" v-on:click="login_onclick()">登录</div>
        <div class="other_panel">
          <router-link class="phone_link" to="register" v-if="!$store.getters.username">手机短信登录/注册</router-link>
          <div class="others_panel">
            <router-link to="register" v-if="!$store.getters.username">立即注册</router-link>
            <span>|</span>
            <a href="#">忘记密码?</a>
          </div>
        </div>
        <div class="links-panel">
          <span>其他方式登录</span>
        </div>
        <div class="icons-panel">
          <a href="#" class="qq icon iconfont icon-icon"></a>
          <a href="#" class="weibo icon iconfont icon-weibo"></a>
          <a href="#" class="zhifubao icon iconfont icon-zhifubao"></a>
          <a href="#" class="wechat icon iconfont icon-wechat"></a>
        </div>
      </div>
    </div>
    <CopyRight></CopyRight>
  </div>
</template>

<script>
import CopyRight from "../../components/CopyRight"

export default {
  components: {
    CopyRight
  },
  data() {
    return {
      qrcode_login: false,
      username: null,
      password: null
    }
  },
  beforeCreate() {
    if (this.$store.getters.username)
      this.$router.push({path: '/'})
  },
  methods: {
    login_onclick() {
      this.$api.Login(this.username, this.password).then((res) => {
        if (res.result == 'success') {
          window.console.log(res)
          this.$store.commit('handleUsername', res.data.username)
          this.$store.commit('handlePassword', res.data.password)
          this.$store.commit('handleNickname', res.data.nickname)
          this.$router.push({path: '/'})
        } else {
          alert('登录失败')
        }
      })
    },
    account_onclick() {
      this.qrcode_login = false
    },
    qrcode_onclick() {
      this.qrcode_login = true
    }
  }
}
</script>

<style>
.container {
  width: 100%;
}

.container .h_panel {
  margin: 0 auto;
  width: 1130px;
  height: 100px;
}

.container .h_panel .logo {
  display: inline-block;
  width: 200px;
  height: 98px;
  background: url(https://account.xiaomi.com/static/res/7f6f2f5/account-static/respassport/acc-2014/img/mistore_logo.png) no-repeat;
}

.container .login_panel {
  margin-bottom: 90px;
  position: relative;
  width: 100%;
  height: 588px;
  background-repeat: no-repeat;
  background-position: top center;
  background-image: url("https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/e8201bfbb8c9d474a48da76f7d81a5c7.jpg");
}

.container .login_panel a {
  display: block;
  width: 100%;
  height: 100%;
}

.container .login_panel .form_panel {
  position: absolute;
  width: 410px;
  height: 554px;
  left: 60%;
  bottom: 0;
  z-index: 9999;
  background-color: white;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container .login_panel .form_panel .tabs {
  padding: 27px 0 24px;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: space-around;
  align-items: center;
  width: 100%;
  height: 38px;
}

.container .login_panel .form_panel .tabs a {
  font-size: 23px;
  color: #666;
  text-decoration: none;
  text-align: center;
  line-height: 38px;
}

.container .login_panel .form_panel a:hover,.container .login_panel .form_panel .tabs .a-activity {
  color: #ff6700;
}

.container .login_panel .form_panel span {
  font-size: 27px;
  color: lightgray;
}

.container .login_panel .form_panel input {
  width: 346px;
  height: 48px;
  margin-top: 15px;
  padding: 13px 16px 13px 14px;
  box-sizing: border-box;
  outline: none;
  border: 1px solid #e0e0e0;
  font-size: 14px;
}

.container .login_panel .form_panel input::placeholder {
  color: rgba(80, 80, 80, 0.5);
}

.container .login_panel .form_panel .other_panel {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: space-between;
}

.container .login_panel .form_panel .login-btn {
  margin-top: 24px;
  width: 346px;
  height: 50px;
  background-color: #ff6700;
  color: white;
  text-align: center;
  line-height: 50px;
  font-size: 14px;
  cursor: pointer;
}

.container .login_panel .form_panel .other_panel {
  padding-top: 10px;
  box-sizing: border-box;
  width: 346px;
}

.container .login_panel .form_panel .other_panel .phone_link {
  color: #ff6700;
  font-size: 14px;
  text-decoration: none;
  width: 120px;
}

.container .login_panel .form_panel .other_panel .others_panel {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: space-between;
  width: 140px;
  align-items: center;
}

.container .login_panel .form_panel .other_panel .others_panel a {
  text-decoration: none;
  font-size: 14px;
  color: rgba(80, 80, 80, 0.5);
  text-align: center;
}

.container .login_panel .form_panel .other_panel .others_panel a:hover {
  color: #ff6700;
}

.container .login_panel .form_panel .other_panel .others_panel span {
  font-size: 12px;
  color: rgba(80, 80, 80, 0.5);
}

.container .login_panel .form_panel .links-panel {
  width: 348px;
  background-color: white;
  margin-top: 120px;
  padding-top: 10px;
  border-top: 1px solid rgba(80, 80, 80, 0.5);
  position: relative;
}

.container .login_panel .form_panel .links-panel span {
  position: absolute;
  top: -10px;
  left: 50%;
  transform: translate(-50%,0);
  color: #bbb;
  font-size: 14px;
  padding-inline-start: 2px;
  padding-inline-end: 2px;
  border-width: initial;
  border-color: initial;
  border-image: initial;
  border-style: none;
  text-align: center;
  display: block;
  background-color: white;
}

.container .login_panel .form_panel .icons-panel {
  width: 348px;
  padding-top: 15px;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: space-evenly;
}

.container .login_panel .form_panel .icons-panel a {
  width: 30px;
  height: 30px;
  font-size: 18px;
  color: white;
  text-align: center;
  line-height: 30px;
  text-decoration: none;
  border-radius: 50%;
}

.container .login_panel .form_panel .icons-panel .qq {
  background-color: #0288d1;
}

.container .login_panel .form_panel .icons-panel .weibo {
  background-color: #d32f2f;
}

.container .login_panel .form_panel .icons-panel .zhifubao {
  background-color: #0ae;
}

.container .login_panel .form_panel .icons-panel .wechat {
  background-color: #00d20d;
}

.container .login_panel .form_panel .qrcode_panel {
  position: absolute;
  top: 100px;
  left: 0;
  width: 100%;
  height: 450px;
  background-color: white;
  z-index: 9999;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}

.container .login_panel .form_panel img {
  width: 180px;
  height: 180px;
}
</style>