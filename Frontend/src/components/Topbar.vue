<template>
    <div class="topbar">
        <div class="container">
            <div class="link-nav">
                <div v-for="(item,i) in linkList" :key="i">
                    <a :href="item.link">{{ item.title }}</a>
                    <span class="sep" v-if="i < linkList.length - 1">|</span>
                </div>
            </div>
            <div class="user-nav">
                <a href="#" v-if="$store.getters.username">您好，{{ $store.getters.nickname }}！</a>
                <router-link to="login" v-if="!$store.getters.username">登录</router-link>
                <span class="sep">|</span>
                <router-link to="register" v-if="!$store.getters.username">注册</router-link>
                <a href="#" v-if="$store.getters.username" v-on:click="logout()">退出</a>
                <span class="sep">|</span>
                <a href="#">消息通知</a>
                <a href="#" class="cart" :class="cartHover ? 'cart-hover' : ''">
                    <span class="icon iconfont icon-cart_light"></span>
                    <span class="text">购物车</span>
                    <span class="num">(0)</span>
                </a>
                <div class="cart-modal" @mouseenter="cart_mouseenner()" @mouseleave="cart_mouseleave()">
                    购物车中还没有商品，赶紧选购吧！
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Topbar',
  props: {
  },
  data() {
    return {
        cartHover: false,
        linkList: [
            {
                title: '小米商城',
                link: 'http://www.baidu.com'
            },
            {
                title: 'MIUI',
                link: 'http://www.baidu.com'
            },
            {
                title: 'IoT',
                link: 'http://www.baidu.com'
            },
            {
                title: '云服务',
                link: 'http://www.baidu.com'
            },
            {
                title: '金融',
                link: 'http://www.baidu.com'
            },
            {
                title: '有品',
                link: 'http://www.baidu.com'
            },
            {
                title: '小爱开放平台',
                link: 'http://www.baidu.com'
            },
            {
                title: '企业团购',
                link: 'http://www.baidu.com'
            },
            {
                title: '资质证照',
                link: 'http://www.baidu.com'
            },
            {
                title: '协议规则',
                link: 'http://www.baidu.com'
            },
            {
                title: '下载APP',
                link: 'http://www.baidu.com'
            }
        ]
    }
  },
  methods: {
    cart_mouseenner() {
        this.cartHover = true
    },
    cart_mouseleave() {
        this.cartHover = false
    },
    logout() {
        this.$store.commit('clearUserInfo')
        this.$router.go(0)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .topbar {
        width: 100%;
        height: 40px;
        background-color: #333333;
        box-sizing: border-box;
    }

    .topbar .container {
        margin: 0 auto;
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        width: 1220px;
        line-height: 40px;
        font-size: 12px;
    }

    .topbar .link-nav {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: flex-start;
        z-index: 9999;
    }

    .topbar .link-nav a {
        text-decoration: none;
        color: #b0b0b0;
    }

    .topbar .link-nav a:hover {
        color: white;
    }

    .topbar .link-nav .sep {
        color: #424242;
        margin-left: 10px;
        margin-right: 10px;
    }

    .topbar .user-nav {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: flex-start;
        position: relative;
    }

    .topbar .user-nav a {
        text-decoration: none;
        color: #b0b0b0;
    }

    .topbar .user-nav a:hover {
        color: white;
    }

    .topbar .user-nav .sep {
        color: #424242;
        margin-left: 10px;
        margin-right: 10px;
    }

    .topbar .user-nav .cart {
        margin-left: 30px;
        padding-left: 15px;
        padding-right: 15px;
        box-sizing: border-box;
        background-color: #424242;
        height: 40px;
        color: #b0b0b0;
        display: flex;
        align-items: center;
        z-index: 9999;
    }

    .topbar .user-nav .cart-modal {
        position: absolute;
        top: 40px;
        right: 0;
        transition: height .3s;
        width: 316px;
        height: 0;
        box-shadow: 0 2px 10px rgba(0,0,0,.15);
        background-color: white;
        overflow: hidden;
        text-align: center;
        line-height: 100px;
        color: black;
        z-index: 31;
    }

    .topbar .user-nav .cart:hover + .cart-modal,.topbar .user-nav .cart-modal:hover {
        height: 100px;
    }

    .topbar .user-nav .cart-modal:hover + .cart {
        color: #ff6700;
        background-color: white;
    }

    .topbar .user-nav .cart:hover,.topbar .user-nav .cart-hover {
        color: #ff6700;
        background-color: white;
    }

    .topbar .user-nav .cart .icon {
        font-size: 18px;
        padding-left: 5px;
        padding-right: 5px;
        box-sizing: border-box;
    }

    .topbar .user-nav .cart .num {
        padding-left: 5px;
        padding-right: 5px;
        box-sizing: border-box;
    }
</style>
