<template>
    <div class="brick">
      <div class="container">
        <div class="hd">
          <h2 class="title">手机</h2>
          <a href="#" class="more"><span>查看全部</span><i class="icon iconfont icon-gengduo"></i></a>
        </div>
        <div class="content">
          <a href="#" class="big-link"><img class="bigimg" src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/574c6643ab91c6618bfb2d0e2c761d0b.jpg?w=468&h=1228" alt=""></a>
          <ul class="list">
            <li v-for="(item,i) in goodList" :key="i">
              <a href="#">
                <img :src="item.src" alt="">
                <h3 class="title">{{ item.title }}</h3>
                <p class="desc">{{ item.desc }}</p>
                <p class="price">{{ item.price }}元起</p>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
</template>

<script>
export default {
  name: 'Brick',
  props: {
  },
  data() {
    return {
      goodList: []
    }
  },
  created() {
    this.getGoodList()
  },
  methods: {
    getGoodList() {
      this.$api.GetGoodList().then((res) => {
        this.goodList = res.data
        this.goodList.length = 8
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .brick {
    width: 100%;
  }

  .brick .container {
    width: 1220px;
    height: 100%;
    margin: 0 auto;
    text-align: center;
    padding-bottom: 25px;
  }

  .brick .container .hd {
    width: 100%;
    height: 58px;
    line-height: 58px;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: space-between;
  }

  .brick .container .hd h2 {
    font-size: 22px;
    font-weight: normal;
  }

  .brick .container .hd .more {
    text-decoration: none;
    color: #424242;
    display: flex;
    flex-direction: row;
    align-items: center;
    opacity: 0.7;
  }

  .brick .container .hd .more:hover > span {
    color: #f1702e;
  }

  .brick .container .hd .more:hover > i {
    background-color: #f1702e;
  }

  .brick .container .hd .more i {
    color: white;
    border-radius: 50%;
    background-color: #b0b0b0;
    font-size: 10px;
    font-weight: bold;
    height: 20px;
    width: 18px;
    padding-right: 2px;
    line-height: 20px;
    margin-left: 5px;
  }

  .brick .container .content .bigimg {
    width: 234px;
    height: 614px;
  }

  .brick .container .content {
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: flex-start;
  }

  .brick .container .content .list {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: flex-start;
    list-style: none;
    width: 992px;
    height: 100%;
  }

  .brick .container .content .list li {
    width: 25%;
    padding-left: 15px;
    padding-bottom: 15px;
    box-sizing: border-box;
  }

  .brick .container .content .list li a {
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    justify-content: center;
    text-align: center;
    color: black;
    text-decoration: none;
    background-color: white;
    padding-top: 20px;
    box-sizing: border-box;
    transition: all .2s linear;
  }

  .brick .container .content .list li a:hover {
    box-shadow: 0 15px 30px rgba(0,0,0,.1);
    transform: translate3d(0,-2px,0);
  }

  .brick .container .content .list li a img {
    width: 170px;
    height: 130px;
    margin: 0 auto;
    padding-bottom: 30px;
    padding-top: 20px;
  }

  .brick .container .content .list li a .title {
    font-size: 14px;
    font-weight: normal;
  }

  .brick .container .content .list li a .desc {
    font-size: 12px;
    color: #b0b0b0;
    padding-top: 5px;
  }

  .brick .container .content .list li a .price {
    font-size: 13px;
    color: #b0b0b0;
    padding-top: 5px;
    color: #f1702e;
    padding-top: 15px;
    padding-bottom: 24px;
  }

  .brick .container .content .big-link {
    transition: all .2s linear;
  }

  .brick .container .content .big-link:hover {
    transform: translate3d(0,-2px,0);
  }
</style>
