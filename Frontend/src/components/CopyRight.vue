<template>
    <div class="copyright">
        <div class="container">
            <p>小米公司版权所有-京ICP备10046444-<img src="https://account.xiaomi.com/static/res/9204d06/account-static/respassport/acc-2014/img/ghs.png">京公网安备11010802020134号-京ICP证110507号</p>
            <p>探索黑科技，小米为发烧而生</p>
        </div>
    </div>
</template>

<script>
export default {
  name: 'CopyRight',
  props: {
  },
  data() {
    return {
      
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .copyright {
      width: 100%;
      margin-top: 20px;
      padding-bottom: 20px;
  }

  .copyright .container {
    width: 1220px;
    height: 100%;
    margin: 0 auto;
    text-align: center;
    color: #757575;
    font-size: 14px;
  }

  .copyright .container p {
    margin-bottom: 10px;
  }
</style>
