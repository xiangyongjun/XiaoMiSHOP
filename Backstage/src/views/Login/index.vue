<template>
  <div class="login">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="0px" class="loginForm">
      <h1 class="loginTitle">后台系统</h1>
      <el-form-item prop="name">
        <el-input type="text" v-model="ruleForm.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item prop="pass">
        <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
      </el-form-item>
      <div class="loginRem">
        <el-checkbox label="记住密码 (账号:随意/密码:随意)" v-model="remember"></el-checkbox>
      </div>
      <el-form-item>
        <el-button class="loginButton" type="primary" @click="submitForm('ruleForm')" :loading="logining">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import service from '@/service/index'
import { mapGetters, mapActions } from 'vuex'

export default {
  data() {
    return {
      logining: false,
      ruleForm: {
        name: 'admin',
        pass: 'admin'
      },
      rules: {
        name: [
          { required: true, message: '请输入账号', trigger: 'blur' },
        ],
        pass: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ]
      },
      remember: true
    };
  },

  methods: {
    ...mapActions([
      'UpdateRememberPass',
      'UpdateIsFold'
    ]),

    submitForm(formName) {
      sessionStorage.setItem('admin', this.ruleForm.name)
      sessionStorage.setItem('pass', this.ruleForm.pass)
      this.$router.push('/dashboard')
      // this.$refs[formName].validate((valid) => {
      //   if (valid) {
      //     let params = Object.assign({}, this.ruleForm)
      //     this.logining = true;
      //     service.login(params).then(res => {
      //       let { code, msg = '', result = {} } = res['data'];
      //       if (code === 0) {
      //         sessionStorage.setItem('admin', this.ruleForm.name)
      //         sessionStorage.setItem('pass', this.ruleForm.pass)
      //         this.$router.push('/dashboard')
      //         this.UpdateRememberPass(this.remember)  // 全局变量是否记住密码
      //       } else {
      //         this.$message({
      //           message: msg,
      //           type: 'error',
      //           duration: 1000
      //         })
      //       }
      //       this.logining = false
      //     }).catch(err => {
      //       this.$message({
      //         message: err,
      //         type: 'error',
      //         duration: 1000
      //       })
      //     });
      //   } else {
      //     this.$message({
      //       message: 'error submit!!',
      //       type: 'error',
      //       duration: 1000
      //     })
      //     return false;
      //   }
      // });
    },

    _isMobile() {
      let flag = navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i)
      return flag;
    }

  },

  mounted() {
    if (this._isMobile()) {
      this.UpdateIsFold(true)
    }
  }
}
</script>

<style scoped lang="less">
.login {
  display: flex;
  flex-flow: column nowrap;
  align-items: center;
  justify-content: center;
  height: 100%;
  background-image: url('../../../public/img/background.jpeg');
  background-size: 100% 100%;
  &Form {
    -webkit-border-radius: 20px;
    border-radius: 20px;
    -moz-border-radius: 20px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 50px;
    background-image: linear-gradient(to right, rgba(	245,245,220,0.8), rgba(135,206,250,0.8));
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #AFEEEE; 
  }
  &Title {
    margin: 0 0 20px 0;
    text-align: center;
    font-size: 1.8rem;
  }
  &Button {
    width: 50%;
  }
  &Rem {
    display: flex;
    flex-flow: row nowrap;
    align-items: flex-start;
    margin-bottom: 20px;
  }
}
</style>