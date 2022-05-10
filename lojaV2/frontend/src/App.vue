<template>

  <nav>
    <div class="login">
      <div class="buttons">
        <router-link to="/Login">
          <h6>Login</h6>
        </router-link>

        <router-link class="btnCadastro" to="#">
          <h6>Cadastro</h6>
        </router-link>
      </div>
    </div>
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
@import 'scss/colors.scss';
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

  .login{
    width: 100%;
    background-color: $primary;
    
    .buttons{
      margin-top: -20px;
      margin-bottom: 10px;
      display: flex;
      justify-content: flex-end;
      border-bottom: .2px solid #f4c54c;
    }
    h6{
      padding: 5px;
      // border: .2px solid #f4c54c;
    }
  }

  .btnCadastro{
    margin-left: 10px;
  }
}
</style>
