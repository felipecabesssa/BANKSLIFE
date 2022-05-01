<template>

  <nav>
    <Menu/>
    <hr>
  </nav>

  <router-view/>
  
</template>

<script>
import Menu from './components/Menu.vue'
export default {
  components:{
    Menu
  }
}
</script>

<style lang="scss">
#app {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #f4c54c;
  background-color: #0d1117;
  min-height: 950px;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #f4c54c;
    }

    text-decoration: none;
  }

  a:hover{
    color: #f4c54c;
  }

  hr{
    margin-bottom: -25px;
  }
}
</style>
