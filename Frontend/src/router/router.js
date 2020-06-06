import App from '../App'

export default [{
    path: '/',
    component: App,
    children: [{
        path: '',
        component: r => require.ensure([], () => r(require('../pages/home')), 'home'),
        meta: {
            title: '小米商城 - 首页'
        }
    }]
},
{
    path: '/login',
    component: r => require.ensure([], () => r(require('../pages/login')), 'login'),
    meta: {
        title: '小米账号 - 登录'
    }
},
{
    path: '/register',
    component: r => require.ensure([], () => r(require('../pages/register')), 'register'),
    meta: {
        title: '小米账号 - 注册'
    }
}]