<template>
    <div class="sub">
        <div class="container">
          <ul class="nav-list">
              <li><a href="#"><img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/82abdba456e8caaea5848a0cddce03db.png?w=48&h=48" alt=""><span>小米秒杀</span></a></li>
              <li><a href="#"><img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/806f2dfb2d27978e33fe3815d3851fa3.png?w=48&h=48" alt=""><span>企业团购</span></a></li>
              <li><a href="#"><img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/eded6fa3b897a058163e2485532c4f10.png?w=48&h=48" alt=""><span>F码通道</span></a></li>
              <li><a href="#"><img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/43a3195efa6a3cc7662efed8e7abe8bf.png?w=48&h=48" alt=""><span>米粉卡</span></a></li>
              <li><a href="#"><img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/f4846bca6010a0deb9f85464409862af.png?w=48&h=48" alt=""><span>以旧换新</span></a></li>
              <li><a href="#"><img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/9a76d7636b08e0988efb4fc384ae497b.png?w=48&h=48" alt=""><span>话费充值</span></a></li>
          </ul>
          <a href="#" class="block"><img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/7c5524bbd8d8e2d8b4fec3774915d2fb.jpg?w=632&h=340" alt=""></a>
          <a href="#" class="block"><img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/daae21ecb17e628f5255412f103c626f.jpg?w=632&h=340" alt=""></a>
          <a href="#" class="block"><img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/816a66edef10673b4768128b41804cae.jpg?w=632&h=340" alt=""></a>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Sub',
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
    .sub {
        width: 100%;
    }

    .sub .container {
    width: 1220px;
    height: 220px;
    margin: 0 auto;
    padding-top: 15px;
    padding-bottom: 30px;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: space-between;
    box-sizing: border-box;
    }

    .sub .container .block {
    transition: box-shadow .2s linear,-webkit-box-shadow .2s linear;
    }

    .sub .container .block:hover {
    box-shadow: 0 15px 30px rgba(0,0,0,.1);
    }

    .sub .container .block img {
        width: 316px;
        height: 100%;
    }

    .sub .container .nav-list {
        list-style: none;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-between;
        width: 234px;
        background-color: #5e5751;
        overflow: hidden;
    }

    .sub .container .nav-list li {
        width: 33.3%;
        position: relative;
    }

    .sub .container .nav-list li::after {
        height: 70px;
        width: 1px;
        background-color: #665e57;
        position: absolute;
        right: 0;
        top: 6px;
        content: '';
    }

    .sub .container .nav-list li::before {
        height: 1px;
        width: 64px;
        background-color: #665e57;
        position: absolute;
        right: 6px;
        top: -1px;
        content: '';
    }

    .sub .container .nav-list li a {
        text-decoration: none;
        color: white;
        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
        align-items: center;
        padding-top: 21px;
        font-size: 12px;
        box-sizing: border-box;
        align-items: center;
        opacity: 0.7;
    }

    .sub .container .nav-list li a:hover {
        opacity: 1;
    }

    .sub .container .nav-list li a img {
        width: 24px;
        height: 24px;
    }

    .sub .container .nav-list li a span {
        padding-top: 5px;
        box-sizing: border-box;
    }

    .sub .container img {
        width: 316px;
    }
</style>