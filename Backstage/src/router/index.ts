import Vue from 'vue'
import VueRouter, { RawLocation }  from 'vue-router'
import Login from '../views/Login/index.vue'
import Home from '../views/Home/index.vue'
import store from '@/store'

/**
 * 重写路由的push方法
 */
const routerPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location: RawLocation) {
  return (<any>(routerPush.call(this, location))).catch((error: any)=> error)
}

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'login',
    hidden: true,
    component: Login
  },
  {
    path: '/',
    component: Home,
    name: '',
    iconCls: 'el-icon-s-help',
    leaf: true,
    children: [
      {
        path: '/dashboard',
        name: '首页',
        component: () => import('../views/Dashboard/index.vue')
      }
    ]
  },
  // {
  //   path: '/',
  //   component: Home,
  //   name: '',
  //   iconCls: 'el-icon-s-grid',
  //   leaf: true,
  //   children: [
  //     {
  //       name: '表格',
  //       path: '/admin',
  //       component: () => import('../views/AdminTable/index.vue')
  //     }
  //   ]
  // },
  {
    path: '/',
    component: Home,
    name: '',
    iconCls: 'el-icon-s-grid',
    leaf: true,
    children: [
      {
        name: '用户列表',
        path: '/user',
        component: () => import('../views/UserTable/index.vue')
      }
    ]
  },
  {
    path: '/',
    component: Home,
    name: '',
    iconCls: 'el-icon-s-grid',
    leaf: true,
    children: [
      {
        name: '轮播图列表',
        path: '/banner',
        component: () => import('../views/BannerTable/index.vue')
      }
    ]
  },
  {
    path: '/',
    component: Home,
    name: '',
    iconCls: 'el-icon-s-grid',
    leaf: true,
    children: [
      {
        name: '商品列表',
        path: '/good',
        component: () => import('../views/GoodTable/index.vue')
      }
    ]
  },
  {
    path: '/',
    component: Home,
    name: '',
    iconCls: 'el-icon-s-grid',
    leaf: true,
    children: [
      {
        name: '顶栏列表',
        path: '/sidebar',
        component: () => import('../views/SidebarTable/index.vue')
      }
    ]
  },
  {
    path: '/',
    component: Home,
    name: '',
    iconCls: 'el-icon-s-grid',
    leaf: true,
    children: [
      {
        name: '下拉列表',
        path: '/dropdown',
        component: () => import('../views/DropdownTable/index.vue')
      }
    ]
  },
  // {
  //   path: '/',
  //   component: Home,
  //   name: '图表',
  //   iconCls: 'el-icon-s-data',
  //   leaf: false,
  //   children: [
  //     {
  //       name: '图表Tab',
  //       iconCls: 'el-icon-help',
  //       path: '/chart',
  //       component: () => import('../views/Charts/index.vue')
  //     },
  //     {
  //       name: '图标Icon',
  //       iconCls: 'el-icon-bicycle',
  //       path: '/icon',
  //       component: () => import('../views/Icon/index.vue')
  //     }
  //   ]
  // }, 
  // {
  //   path: '/',
  //   component: Home,
  //   name: '',
  //   iconCls: 'el-icon-share',
  //   leaf: true,
  //   children: [
  //     {
  //       name: 'Form表单',
  //       path: '/form',
  //       component: () => import('../views/Form/index.vue')
  //     }
  //   ]
  // },
  // {
  //   path: '/',
  //   component: Home,
  //   name: '',
  //   iconCls: 'el-icon-star-on',
  //   leaf: true,
  //   children: [
  //     {
  //       name: 'Vuex使用',
  //       path: '/vuex',
  //       component: () => import('../views/VuexRelated/index.vue')
  //     }
  //   ]
  // } 
]

const router = new VueRouter({
  // mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  if (to.path == '/login') {
    sessionStorage.removeItem('admin');
  }
  let admin = <String>sessionStorage.getItem('admin');
  if (!admin && to.path !== '/login') {
    next({ path: '/login' })
  } else {
    if (to.path !== '/login') {
      let newPath = {
        name: to.name,
        path: to.fullPath
      }
      store.dispatch("AddRouter", newPath)  // 向全局变量中添加路由
    }
    next()
  }
});

export default router
