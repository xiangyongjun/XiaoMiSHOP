import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import routes from './router/router'
import '@/assets/icon/iconfont.css'
// import Axios from 'axios'
import Qs from 'qs'
import Axios from './axios/interceptor'
import * as api from './api'
import store from './store'

Vue.config.productionTip = true
Vue.use(VueRouter)
Vue.prototype.$axios = Axios
Vue.prototype.$qs = Qs
Vue.prototype.$api = api
const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next) => {
  /* 路由发生变化修改页面title */
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
