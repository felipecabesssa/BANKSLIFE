<template>
  <div class="main">
      <div class="login">
        <h2>Preencha com seus dados</h2>
        <label for="email">Email:</label>
        <input v-model="username" type="email">
        <label for="username">Usuario</label>
        <input v-model="username" type="text">
        <label for="password">Senha</label>
        <input v-model="password" type="password">
        <button v-on:click="enviarDadosLogin" class="btn btn-warning">Cadastrar</button>
      </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
export default {
  data(){
    return{
      email: "",
      username: "",
      password: "",
    }
  },

  computed: {
    ...mapState(["user"]),
  },

  methods: {
    ...mapActions('user', ["userRegisterAction", "emailConfirmed"]),

    async enviarDadosCadastro(){
      
    }
  }
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
        width: 80%;
        button{
            margin-top: 10px;
        }
    }
}

</style>