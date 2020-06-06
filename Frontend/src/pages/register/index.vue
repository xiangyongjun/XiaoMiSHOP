<template>
  <div class="container">
    <div class="wrap">
      <div class="logo"></div>
      <h1>注册小米账号</h1>
      <h4>手机/用户名</h4>
      <input v-model="username" type="text" name="username">
      <h4>密码</h4>
      <input v-model="password" type="password" name="password">
      <h4>昵称</h4>
      <input v-model="nickname" type="text" name="nickname">
      <span class="message" v-if="message">提示：{{ message }}</span>
      <button v-on:click="register_onclick()">立即注册</button>
      <div class="agree">
        已阅读并同意：小米 <a href="https://cn.account.xiaomi.com/about/protocol/agreement">用户协议</a> 和 <a href="https://cn.account.xiaomi.com/about/protocol/privacy">隐私政策</a>
      </div>
    </div>
    <footer>
      <CopyRight></CopyRight>
    </footer>
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
      message: '',
      username: '',
      password: '',
      nickname: ''
    }
  },
  beforeCreate() {
    if (this.$store.getters.username)
      this.$router.push({path: '/'})
  },
  methods: {
    register_onclick() {
      if (this.username == '' || this.password == '' || this.nickname == '') {
        this.message = '用户名或密码、昵称不能为空'
        return;
      }
      if (this.username.length < 6 || this.password.length < 6) {
        this.message = '用户名或密码长度不能少于6'
        return;
      }
      this.$api.AddUser({username: this.username, password: this.password, nickname: this.nickname}).then((res) => {
        // window.console.log(res)
        if (res.result == 'success') {
          alert('注册成功！')
          this.$router.push({path: '/login'})
        } else {
          this.message = '注册失败'
        }
      })
    }
  }
}
</script>

<style>
body,html {
  height: 100%;
  background-color: #f9f9f9
}

h1,h4 {
  font-weight: normal;
}

.container {
  width: 100%;
  height: 100%;
  position: relative;
  box-sizing: border-box;
}

.container .wrap {
  width: 854px;
  height: 550px;
  background-color: white;
  position: absolute;
  left: 50%;
  top: calc(50% - 40px);
  transform: translate(-50%, -50%);
  display: flex;
  flex-direction: column;
  align-items: center;
  position: relative;
}

.container .wrap .logo {
  width: 48px;
  height: 48px;
  background-repeat: no-repeat;
  background-image: url(https://account.xiaomi.com/static/res/28f08d0/account-static/respassport/acc-2014/img/milogo.png);
}

.container .wrap h1 {
  font-size: 30px;
  padding-top: 40px;
  padding-bottom: 30px;
}

.container .wrap h4 {
  width: 332px;
  font-size: 14px;
  padding-bottom: 5px;
  padding-top: 5px;
}

.container .wrap input {
  background: none;
  background-color: white;
  outline: none;  
  border: 1px solid #e8e8e8;
  width: 332px;
  height: 40px;
  font-size: 14px;
  padding: 10px;
  box-sizing: border-box;
}

.container .wrap button {
  width: 332px;
  height: 40px;
  background-color: #ff6700;
  color: white;
  margin-top: 20px;
  font-size: 14px;
  cursor: pointer;
}

.container .wrap .agree {
  width: 332px;
  height: 40px;
  font-size: 14px;
  text-align: center;
  color: black;
  position: absolute;
  bottom: 30px;
  left: 50%;
  transform: translate(-50%, 0);
}

.container .wrap .agree a {
  text-decoration: none;
  font-weight: bold;
  color: black;
}

.container .wrap .message {
  padding-top: 10px;
  box-sizing: border-box;
  color: red;
  font-size: 14px;
}

.container footer {
  position: absolute;
  left: 0;
  bottom: 0;
  width: 100%;
}
</style>