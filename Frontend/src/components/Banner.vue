<template>
  <div class="banner">
      <div class="container">
        <ul class="nav">
          <li v-for="(item,i) in sideList" :key="i" @mouseenter="nav_mouseenter(i)" @mouseleave="nav_mouseleave()">
              <a href="#" :class="i == aHoverIndex - 1 ? 'a-hover' : ''">
                  <span class="title">{{ item.title }}</span>
                  <span class="icon iconfont icon-gengduo"></span>
              </a>
          </li>
        </ul>
        <div class="nav-modal" v-if="navModalShow" @mouseenter="modal_mouseenter(-1)" @mouseleave="modal_mouseleave()">
          <ul>
            <li v-for="(item,i) in sideModalList" :key="i">
              <a :href="item.link">
                <img :src="item.src" alt="">
                <span>{{ item.title }}</span>
              </a>
            </li>
          </ul>
        </div>
        <div class="prev" v-on:click="prev()"><span class="icon iconfont icon-fanhui"></span></div>
        <div class="next" v-on:click="next()"><span class="icon iconfont icon-gengduo"></span></div>
        <div class="pagination">
          <a href="javascript:void(0)" v-on:click="pagination(i)" :class="i == bannerIndex ? 'a-show' : ''" v-for="(item,i) in bannerList" :key="i"></a>
        </div>
        <div class="slide" :class="i == bannerIndex ? 'slide-show' : ''" v-for="(item,i) in bannerList" :key="i">
          <a :href="item.link">
            <img :src="item.src" alt="">
          </a>
        </div>
      </div>
  </div>
</template>

<script>
export default {
  name: 'Banner',
  props: {
  },
  data() {
    return {
      aHoverIndex: 0,
      navModalShow: false,
      sideModalList: [
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
        {
          title: 'Redmi K30 Pro',
          link: '#',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b2b8b609aab05d9ad184bbe5c8e8be28.jpg'
        },
      ],
      sideList: [
        {
          id: 1,
          title: '手机 电话卡'
        },
        {
          id: 2,
          title: '电视 盒子'
        },
        {
          id: 3,
          title: '笔记本 显示器 平板'
        },
        {
          id: 4,
          title: '家电 拆线板'
        },
        {
          id: 5,
          title: '出行 穿戴'
        },
        {
          id: 6,
          title: '智能 路由器'
        },
        {
          id: 7,
          title: '电源 配件'
        },
        {
          id: 8,
          title: '健康 儿童'
        },
        {
          id: 9,
          title: '耳机 音箱'
        },
        {
          id: 10,
          title: '生活 箱包'
        },
      ],
      timer: null,
      bannerIndex: 0,
      bannerList: []
    }
  },
  created() {
    this.getBannerList()
    this.setTimer()
  },
  methods: {
    getBannerList() {
      this.$api.GetBannerList().then((res) => {
        this.bannerList = res.data
      })
    },
    nav_mouseenter(i) {
      if (i > -1)
        this.aHoverIndex = i + 1
      this.navModalShow = true
    },
    nav_mouseleave() {
      this.navModalShow = false
      this.aHoverIndex = 0 - this.aHoverIndex
    },
    modal_mouseleave() {
      this.aHoverIndex = 0
      this.navModalShow = false
    },
    modal_mouseenter() {
      this.aHoverIndex = Math.abs(this.aHoverIndex)
      this.navModalShow = true
    },
    prev() {
      this.setTimer()
      if (this.bannerIndex - 1 < 0) {
        this.bannerIndex = this.bannerList.length - 1
      } else {
        this.bannerIndex--
      }
    },
    next() {
      this.setTimer()
      if (this.bannerIndex + 1 < this.bannerList.length) {
        this.bannerIndex++
      } else {
        this.bannerIndex = 0
      }
    },
    pagination(i) {
      this.bannerIndex = i
      this.setTimer()
    },
    setTimer() {
      clearInterval(this.timer)
      this.timer = setInterval(() => {
        this.next()
      }, 5000)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .banner {
      width: 100%;
      height: 460px;
  }

  .banner .container {
    width: 1220px;
    height: 100%;
    margin: 0 auto;
    position: relative;
  }

  .banner .container .nav-modal {
    position: absolute;
    left: 234px;
    top: 0;
    width: 986px;
    height: 100%;
    background-color: white;
    z-index: 9999;
    box-shadow: 0 8px 16px rgba(0,0,0,.18);
    border: 1px solid lightgray;
    box-sizing: border-box;
  }

  .banner .container .nav-modal ul {
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    list-style: none;
    padding: 15px 15px 15px 15px;
    box-sizing: border-box;
    height: 100%;
  }

  .banner .container .nav-modal ul li {
    height: 16.6%;
    padding-top: 10px;
    box-sizing: border-box;
    width: 200px; 
  }

  .banner .container .nav-modal ul li a {
    display: flex;
    flex-direction: row;
    align-items: center;
    color: black;
    font-size: 14px;
    text-decoration: none;
  }

  .banner .container .nav-modal ul li a img {
    padding-right: 10px;
    box-sizing: border-box;
  }

  .banner .container .nav-modal ul li a:hover {
    color: #f1702e;
  }

  .banner .container .nav-modal ul li a img {
    width: 40px;
    height: 40px;
  }

  .banner .container .prev {
    position: absolute;
    left: 234px;
    top: 50%;
    transform: translate(0,-50%);
    width: 40px;
    height: 70px;
    z-index: 40;
    padding-left: 8px;
    cursor: pointer;
    color: lightgray;
    box-sizing: border-box;
  }

  .banner .container .pagination {
    position: absolute;
    right: 30px;
    bottom: 20px;
    height: 20px;
    z-index: 40;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: flex-end;
    align-items: center;
  }

  .banner .container .pagination a {
    width: 11px;
    height: 11px;
    border-radius: 50%;
    border: 2px solid #d0d3e1;
    margin-left: 8px;
    box-sizing: border-box;
    background-color: rgba(0, 0, 0, 0.3);
  }

  .banner .container .pagination a:hover,.banner .container .pagination .a-show {
    background-color: rgba(0, 0, 0, 0);
  }

  .banner .container .prev:hover {
    background-color: rgba(0, 0, 0, 0.5);
    color: white;
  }

  .banner .container .next {
    position: absolute;
    right: 0;
    top: 50%;
    transform: translate(0,-50%);
    width: 40px;
    height: 70px;
    z-index: 40;
    padding-right: 8px;
    cursor: pointer;
    color: lightgray;
    box-sizing: border-box;
  }

  .banner .container .next:hover {
    background-color: rgba(0, 0, 0, 0.5);
    color: white;
  }

  .banner .container .prev span,.banner .container .next span {
    font-size: 30px;
    line-height: 70px;
  }

  .banner .container .slide {
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    transition-duration: 800ms;
    opacity: 0;
    transition-property: opacity;
    z-index: 1;
  }

  .banner .container .slide-show {
    opacity: 1;
    z-index: 10;
  }

  .banner .container .slide a {
    width: 100%;
    height: 100%;
  }

  .banner .container .slide a img {
    width: 100%;
    height: 100%;
  }

  .banner .container .nav {
    position: absolute;
    left: 0;
    top: 0;
    background-color: rgba(0, 0, 0, 0.3);
    width: 234px;
    height: 100%;
    padding-top: 20px;
    padding-bottom: 20px;
    box-sizing: border-box;
    list-style: none;
    display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    justify-content: flex-start;
    z-index: 20;
  }

  .banner .container .nav li a {
    display: flex;
    justify-content: space-between;
    width: 100%;
    text-decoration: none;
    color: white;
    padding-left: 30px;
    padding-right: 22px;
    box-sizing: border-box;
    font-size: 14px;
    line-height: 42px;
  }

  .banner .container .nav li a .icon {
    font-weight: bold;
    font-size: 12px;
  }

  .banner .container .nav li a:hover,.banner .container .nav li .a-hover {
    background-color: #f1702e;
  }

</style>
