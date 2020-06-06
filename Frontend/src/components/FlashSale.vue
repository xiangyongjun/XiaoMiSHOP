<template>
    <div class="flashsale">
      <div class="container">
        <div class="hd">
          <h2 class="title">小米闪购</h2>
          <div class="controls">
            <span class="prev icon iconfont icon-fanhui" :class="flashsaleLeft == 0 ? 'disable' : ''" v-on:click="prev_onclick()"></span>
            <span class="next icon iconfont icon-gengduo" :class="flashsaleLeft < -(flashsaleList.length * 246 - 246 * 4 - 1) ? 'disable' : ''" v-on:click="next_onclick()"></span>
          </div>
        </div>
        <div class="row">
          <div class="flashsale-block">
            <div class="round">14:00 场</div>
            <img src="data:img/jpg;base64,iVBORw0KGgoAAAANSUhEUgAAACIAAAA1CAYAAAAklDnhAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ%0AbWFnZVJlYWR5ccllPAAAAyNpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdp%0Abj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6%0AeD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNS1jMDE0IDc5LjE1%0AMTQ4MSwgMjAxMy8wMy8xMy0xMjowOToxNSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJo%0AdHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlw%0AdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAv%0AIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RS%0AZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpD%0AcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChNYWNpbnRvc2gpIiB4bXBNTTpJbnN0YW5j%0AZUlEPSJ4bXAuaWlkOjY4Q0ZFMkY5MTJFNzExRThCMkM4OEM1RTNBNjczQUVBIiB4bXBNTTpEb2N1%0AbWVudElEPSJ4bXAuZGlkOjY4Q0ZFMkZBMTJFNzExRThCMkM4OEM1RTNBNjczQUVBIj4gPHhtcE1N%0AOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NjhDRkUyRjcxMkU3MTFFOEIy%0AQzg4QzVFM0E2NzNBRUEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NjhDRkUyRjgxMkU3MTFF%0AOEIyQzg4QzVFM0E2NzNBRUEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94Onht%0AcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz5oEyacAAACoklEQVR42sSYv0tbURTHX0LqD6T4g4pE%0AcHDoUOloBxVd/QFFEcQqWtrSKlKFmmAslopohzgIbv4FwUEE0clFujiIi+BSIbRQ0ooKRReRULHf%0AS48Qgu++c3/FAx+iyU3eJzf3nnPuC/1qavQ04zVY8szjCHRGNN9cBD6DSkOJKzAGzsOaH/AW1FuY%0AjRg4EH/oiJSCTxYk1sDK7T86Iu9BraHED/Au9wlVkYdg2lAiC/rBhYnIB/DIUOQj2M9/UkWkCsQN%0AJbbA8l0vqIhMgXIDiZ/gFbgxEakBEwYSf8Eg+OM3gCsyA8oMRETy25UN4IjUgVEDiW2wGDSIIzIL%0AijUljsFLv3WhIvKYFphOXNO6OOUMDhKZA7qFcQF85Q6WXeQpeKEpcULlvY8xthp8iwR8I93qLLb7%0AKnOsSPWNfhd6Bro99yHqTi9IhyWzEXIsIXbSG7Djt1jbQHsBZkMkyZRs13wpgIRoiJKy7dsBWh1L%0AbN5Vt3JFQrQ2XMYeGKBk5yvSI7aRQ4k0eA4uZZlVPM47lDgTZxd6lKb4AcqkLuKSZiIdVGsiVFNc%0AxDV9yT1Orekjoe+MDw4pHqwmaJewit66Ql0QaX+DOTaZe4DitAFZxQaaEynKnJ6KCDeaQAtj3A7V%0AkBtXIpwT3iFV06zqquaKPKEtKIsM6Mo/StoWiQeMvSCJjO4+54hEwTCjuTk0STgckUm6QxTY3LgU%0AKc+/jyFrblyKCIkKbnPjSkT8HDGV5saVyBAtVHZz40Ik7HNTRtrcuBARF2tQbW5ciCR0mhvbIs2E%0AcnNjWySh29zYFGnIK25KzY1Nkdziptzc2BKJUu7Qbm5sicQom2o3NzZEKqiu/DZpbmyIjIAHNBMZ%0A7x4iTALjhcgVQSIl3v87w5vePcY/AQYAFYR6skFSqBUAAAAASUVORK5CYII=" alt="">
            <div class="desc">距离结束还有</div>
            <div class="countdown">
              <span>00</span>
              <i>:</i>
              <span>44</span>
              <i>:</i>
              <span>48</span>
            </div>
          </div>
          <div class="wrapper">
            <ul :style="{transform:`translate(${flashsaleLeft}px,0)`}">
              <li v-for="(item,i) in flashsaleList" :key="i" :style="{borderTopColor: randomRgbColor()}">
                <a :href="item.link">
                  <img :src="item.src" alt="">
                  <div class="title">{{ item.title }}</div>
                  <div class="desc">{{ item.desc }}</div>
                  <p class="price">
                    <span>{{ item.price }}元</span>
                    <del>{{ item.old_price }}元</del>
                  </p>
                </a>
              </li>
            </ul>
        </div>
        </div>
      </div>
    </div>
</template>

<script>
export default {
  name: 'FlashSale',
  props: {
  },
  data() {
    return {
      flashsaleLeft: 0,
      flashsaleList: []
    }
  },
  created() {
    this.getGoodList()
  },
  methods: {
    randomRgbColor() { //随机生成RGB颜色
      var r = Math.floor(Math.random() * 256); //随机生成256以内r值
      var g = Math.floor(Math.random() * 256); //随机生成256以内g值
      var b = Math.floor(Math.random() * 256); //随机生成256以内b值
      return `rgb(${r},${g},${b})`; //返回rgb(r,g,b)格式颜色
    },
    getGoodList() {
      this.$api.GetGoodList().then((res) => {
        this.flashsaleList = res.data
        this.flashsaleList.forEach((item) => {
          item.link = '#'
        })
      })
    },
    prev_onclick() {
      if (this.flashsaleLeft + 246 * 4 > 0)
        return;
        
      this.flashsaleLeft += 246 * 4
    },
    next_onclick() {
      if (this.flashsaleLeft - 246 * 4 - 1 < -(this.flashsaleList.length * 246))
        return;
      this.flashsaleLeft -= 246 * 4
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .flashsale {
    width: 100%;
  }

  .flashsale .container {
    width: 1220px;
    margin: 0 auto;
    padding-bottom: 20px;
  }

  .flashsale .container .hd {
    width: 100%;
    height: 58px;
    line-height: 58px;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: space-between;
  }

  .flashsale .container .hd h2 {
    font-size: 22px;
    font-weight: normal;
  }

  .flashsale .container .hd .controls span {
    border: 1px solid lightgray;
    height: 23px;
    line-height: 23px;
    padding-top: 5px;
    padding-bottom: 5px;
    cursor: pointer;
    color: gray;
    box-sizing: border-box;
    font-size: 14px;
    font-weight: bold;
    transition: color .5s;
  }

  .flashsale .container .hd .controls span:hover {
    color: #ff6700;
  }

  .flashsale .container .hd .controls .disable,.flashsale .container .hd .controls .disable:hover {
    color: lightgray;
  }

  .flashsale .container .hd .controls .prev {
    padding-left: 14px;
    padding-right: 9px;
  }

  .flashsale .container .hd .controls .next {
    padding-left: 9px;
    padding-right: 14px;
    border-left: none;
  }

  .flashsale .container .row {
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: flex-start;
    overflow: hidden;
  }

  .flashsale .container .row .flashsale-block {
    border-top: 1px solid red;
    display: flex;
    flex-direction: column;
    text-align: center;
    align-items: center;
    background-color: #f1eded;
    width: 234px;
    height: 340px;
    padding-top: 40px;
    box-sizing: border-box;
    align-self: baseline;
  }

  .flashsale .container .row .flashsale-block .round {
    font-size: 20px;
    color: red;
    padding-top: 15px;
    box-sizing: border-box;
  }

  .flashsale .container .row .flashsale-block img {
    padding-top: 25px;
    padding-bottom: 25px;
    box-sizing: border-box;
  }

  .flashsale .container .row .flashsale-block .desc {
    font-size: 16px;
    color: rgba(0,0,0,.54);
  }

  .flashsale .container .row .flashsale-block .countdown {
    padding-top: 40px;
    box-sizing: border-box;
    width: 234px;
  }

  .flashsale .container .row .flashsale-block .countdown span {
    font-size: 25px;
    color: white;
    padding: 8px;
    background: #605751;
    box-sizing: border-box;
  }

  .flashsale .container .row .flashsale-block .countdown i {
    color: #605751;
    font-size: 30px;
    box-sizing: border-box;
    padding-left: 5px;
    padding-right: 5px;
    font-weight: normal;
    font-style: normal;
  }

  .flashsale .container .row .wrapper {
    width: 974px;
    margin-left: 14px;
    box-sizing: border-box;
    overflow: hidden;
  }

  .flashsale .container .row .wrapper ul {
    list-style: none;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: flex-start;
    transition: all .6s;
  }

  .flashsale .container .row .wrapper ul li {
    width: 234px;
    height: 340px;
    background-color: white;
    border-top: 1px solid green;
    margin-right: 12px;
  }

  .flashsale .container .row .wrapper ul li a {
    display: flex;
    height: 100%;
    color: black;
    text-decoration: none;
    padding-top: 40px;
    box-sizing: border-box;
    text-align: center;
    flex-direction: column;
    flex-wrap: nowrap;
    width: 234px;
  }

  .flashsale .container .row .wrapper ul li img {
    width: 160px;
    height: 120px;
    margin: 0 auto;
    /* box-sizing: border-box; */
    padding-bottom: 40px;
  }

  .flashsale .container .row .wrapper li .title {
    font-size: 14px;
    padding-top: 20px;
    padding-bottom: 5px;
    box-sizing: border-box;
  }

  .flashsale .container .row .wrapper ul li .desc {
    font-size: 12px;
    color: #b0b0b0;
  }

  .flashsale .container .row .wrapper ul li .price {
    box-sizing: border-box;
    padding-top: 10px;
  }

  .flashsale .container .row .wrapper li .price span {
    font-size: 14px;
    color: #ff6700;
  }

  .flashsale .container .row .wrapper ul li .price del {
    padding-left: 5px;
    font-size: 14px;
    color: #b0b0b0;
    box-sizing: border-box;
  }
</style>
