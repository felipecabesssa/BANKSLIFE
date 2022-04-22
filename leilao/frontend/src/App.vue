<template>
  <div id="nav">
    <MenuLeilao/>
  </div>
  <router-view/>
</template>

<script>
import MenuLeilao from './components/MenuLeilao.vue'
export default {
  components:{
    MenuLeilao
  }
}
</script>

<style lang="scss">
#app {
  background-color: #212529;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #fcc107;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
