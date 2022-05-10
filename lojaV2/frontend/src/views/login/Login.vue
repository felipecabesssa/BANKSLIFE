<template>
  <div class="main">
      <div class="login">
        <h2>Login</h2>
        <label for="username">Usuario</label>
        <input type="text">
        <label for="password">Senha</label>
        <input type="password">
        <button class="btn btn-warning">Logar</button>
      </div>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
.main{
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 2%;
    .login{
        display: flex;
        flex-direction: column;
        width: 40%;
        button{
            margin-top: 10px;
        }
    }
}

</style>