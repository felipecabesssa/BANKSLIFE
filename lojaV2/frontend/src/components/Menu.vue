<template>
  <div class="conteudo">
    <ul>
      <router-link to="/">
        <li>Home</li>
      </router-link>
      <router-link to="/about">
        <li>Sobre</li>
      </router-link>
      <router-link v-if="token" to="/categorias">
        <li>Categorias</li>
      </router-link>
      <router-link v-if="token" to="/produtos">
        <li>Produtos</li>
      </router-link>
    </ul>
  </div>
</template>

<script>
export default {
  computed:{
    username(){
      return localStorage.username
    },
    token(){
      return localStorage.token
    }
  }
};
</script>

<style lang="scss" scoped>

.conteudo{
  ul{
    display: flex;
    list-style: none;
    justify-content: space-around;
    margin: 0 auto;
    li{
      width: 100%;
    }
  }
}

</style>