<template>
    <div class="advert">
      <div class="container">
        <a :href="href"><img :src="src" alt=""></a>
      </div>
    </div>
</template>

<script>
export default {
  name: 'Advert',
  props: {
    src: String,
    href: String
  },
  data() {
    return {
      
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .advert {
      width: 100%;
  }

  .advert .container {
    padding-bottom: 20px;
    width: 1220px;
    height: 100%;
    margin: 0 auto;
  }

  .advert .container a img {
    width: 100%;
    height: 120px;
  }
</style>
