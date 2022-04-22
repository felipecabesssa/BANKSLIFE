<template>

  <nav class="navbar navbar-expand navbar-light mb-3 bg-dark">
    <div class="navbar-nav">
      <router-link to="/">
        <a class="nav-item nav-link active text-warning" href="">Todos</a>
      </router-link>
      <router-link to="/aguardando">
        <a class="nav-item nav-link active text-warning" href="">Aguardando</a>
      </router-link>
      <router-link to="/aprovado">
        <a class="nav-item nav-link active text-warning" href="">Aprovado</a>
      </router-link>
      <router-link to="/entregue">
        <a class="nav-item nav-link active text-warning" href="">Entregue</a>
      </router-link>
    </div>
  </nav>
  <hr>

</template>

<script>

export default {};

</script>

<style lang="scss" scoped>

.navbar{
  justify-content: space-around;
}

.navbar-nav a{
  text-decoration: none;
     
 }

</style>

