<template>
  <div class="container">
      <Topbar></Topbar>
      <Sidebar></Sidebar>
      <Banner></Banner>
      <Sub></Sub>
      <div class="main">
        <FlashSale></FlashSale>
        <Advert href="#" src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/b8bdd93c2aad57ede093b09d40000a48.jpg?w=2452&h=240"></Advert>
        <Brick></Brick>
        <CopyRight></CopyRight>
      </div>
  </div>
</template>

<script>
import Topbar from "../../components/Topbar"
import Sidebar from "../../components/Sidebar"
import Banner from "../../components/Banner"
import Sub from "../../components/Sub"
import Brick from "../../components/Brick"
import CopyRight from "../../components/CopyRight"
import Advert from "../../components/Advert"
import FlashSale from "../../components/FlashSale"

export default {
  components: {
    Topbar,
    Sidebar,
    Banner,
    Sub,
    CopyRight,
    Brick,
    Advert,
    FlashSale
  },
  data() {
    return {
      
    }
  },
  created() {
  }
}
</script>

<style>
.main {
  width: 100%;
  background-color: #f5f5f5;
}

.container {
  min-width: 1220px;
}
</style>