<template>
    <div class="sidebar">
        <div class="container">
          
          <div class="nav">
            <img class="logo" src="../assets/logo.png" alt="">
            <a v-for="(item,i) in sidebarList" :key="i" :href="item.link==null ? 'javascript: void(0);' : item.link" @mouseleave="nav_mouseleave()" @mouseenter="nav_mouseenner(i)">{{ item.title }}</a>
          </div>
          <div class="search">
            <input type="text">
            <a href="#" class="btn icon iconfont icon-search"></a>
          </div>
          <div class="dropdown" :class="dropdownShow ? 'dropdown-show' : ''">
            <ul>
              <li v-for="(item,i) in dropdownList" :key="i">
                <a href="#">
                  <img :src="item.src" alt="">
                  <p>{{ item.title }}</p>
                  <span>{{ item.price }}元起</span>
                </a>
              </li>
            </ul>
          </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Sidebar',
  props: {
  },
  data() {
    return {
      dropdownShow: false,
      dropdownList: [
        {
          id: 1,
          title: '小米9Pro',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/be92bc4baa572bf467fc9e881fd4be2a.png',
          price: 2799
        },
        {
          id: 2,
          title: '小米9Pro',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/be92bc4baa572bf467fc9e881fd4be2a.png',
          price: 2799
        },
        {
          id: 3,
          title: '小米9Pro',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/be92bc4baa572bf467fc9e881fd4be2a.png',
          price: 2799
        },
        {
          id: 4,
          title: '小米9Pro',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/be92bc4baa572bf467fc9e881fd4be2a.png',
          price: 2799
        },
        {
          id: 5,
          title: '小米9Pro',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/be92bc4baa572bf467fc9e881fd4be2a.png',
          price: 2799
        },
        {
          id: 6,
          title: '小米9Pro',
          src: 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/be92bc4baa572bf467fc9e881fd4be2a.png',
          price: 2799
        },
      ],
      sidebarList: [
        {
          id: 1,
          title: '小米手机',
          link: ''
        },
        {
          id: 2,
          title: 'Redmi 红米',
          link: ''
        },
        {
          id: 3,
          title: '电视',
          link: ''
        },
        {
          id: 4,
          title: '笔记本',
          link: ''
        },
        {
          id: 3,
          title: '家电',
          link: ''
        },
        {
          id: 4,
          title: '路由器',
          link: ''
        },
        {
          id: 5,
          title: '智能硬件',
          link: ''
        },
        {
          id: 6,
          title: '服务',
          link: 'https://www.mi.com/service/'
        },
        {
          id: 7,
          title: '社区',
          link: 'http://www.xiaomi.cn/'
        },
      ]
    }
  },
  created() {
    this.getSidebarList()
  },
  methods: {
    getSidebarList() {
      this.$api.GetSidebarList().then((res) => {
        this.sidebarList = res.data
        this.sidebarList.length = 9
      })
    },
    getDropdownBySid(sid) {
      this.$api.GetDropdownBySid(sid).then((res) => {
        this.dropdownList = res.data
      })
    },
    nav_mouseenner(i) {
      // window.console.log(i)
      if (this.sidebarList[i].link == null) {
        this.dropdownList = this.getDropdownBySid(this.sidebarList[i].id)
        this.dropdownShow = true
      } 
    },
    nav_mouseleave() {
      this.dropdownShow = false
    },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .sidebar {
      width: 100%;
      height: 100px;
      position: relative;
  }

  .sidebar .container {
    width: 1220px;
    height: 100%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
  }

  .sidebar .container .logo {
    width: 55px;
    height: 55px;
    padding-right: 180px;
  }

  .sidebar .container .nav {
    font-size: 16px;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: flex-start;
    /* padding-left: 180px; */
    /* padding-right: 70px; */
    box-sizing: border-box;
    align-items: center;
  }

  .sidebar .container .nav a {
    color: black;
    padding-left: 10px;
    padding-right: 10px;
    box-sizing: border-box;
    text-decoration: none;
    line-height: 100px;
  }

  .sidebar .container .nav a:hover {
    color: #ff6700;
  }

  .sidebar .container .search {
    border: 1px solid #e0e0e0;
    height: 50px;
    width: 296px;
    display: flex;
  }

  .sidebar .container .search input {
    width: 245px;
    height: 100%;
    font-size: 14px;
    outline-color: invert;
    outline-style: none;
    outline-width: 0px;
    border: none;
    border-style: none;
    text-shadow: none;
    box-shadow: none;
    padding-left: 10px;
    box-sizing: border-box;
  }

  .sidebar .container .search .btn {
    width: 50px;
    height: 100%;
    border-left: 1px solid #e0e0e0;
    text-decoration: none;
    color: gray;
    font-size: 18px;
    line-height: 50px;
    text-align: center;
    font-weight: bold;
  }

  .sidebar .container .search .btn:hover {
    background-color: #ff6700;
  }

  .sidebar .dropdown {
    position: absolute;
    left: 0;
    top: 100px;
    width: 100%;
    height: 0px;
    background-color: white;
    transition: box-shadow .2s,height .3s,-webkit-box-shadow .2s;
    z-index: 99999;
    overflow: hidden;
    padding-left: 10px;
    padding-right: 10px;
    box-sizing: border-box;
  }

  .sidebar .dropdown-show,.sidebar .dropdown:hover {
    height: 230px;
    box-shadow: 0 3px 4px rgba(0,0,0,.18);
    border-top: 1px solid #e0e0e0;
  }

  .sidebar .dropdown ul {
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    list-style: none;
    justify-content: space-around;
    overflow: hidden;
    width: 1220px;
    margin: 0 auto;
  }

  .sidebar .dropdown ul li {
    position: relative;
  }

  .sidebar .dropdown ul li::before {
    position: absolute;
    right: -25px;
    top: 35px;
    width: 1px;
    height: 100px;
    background-color: lightgray;
    content: '';
  }

  .sidebar .dropdown ul li a {
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    text-align: center;
    text-decoration: none;
    color: black;
    padding-top: 35px;
    box-sizing: border-box;
  }

  .sidebar .dropdown ul li a img {
    width: 160px;
    height: 110px;
  }

  .sidebar .dropdown ul li a p {
    padding-top: 15px;
    padding-bottom: 5px;
    box-sizing: border-box;
    font-size: 12px;
  }

  .sidebar .dropdown ul li a span {
    font-size: 10px;
    color: #ff6700;
  }
</style>
