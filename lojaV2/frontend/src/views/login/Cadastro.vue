<template>
  <div class="main">
      <div class="login">
        <h2>Preencha com seus dados</h2>
        <label for="email">Email:</label>
        <input v-model="email" type="email">
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
      password: ""
    }
  },

  computed: {
    ...mapState(["user"]),
  },

  methods: {
    ...mapActions('user', ["userRegisterAction", "emailConfirmed"]),

    async enviarDadosCadastro(){

      const user = {
        email: this.email,
        username: this.username,
        password: this.password
      }
      
      await this.userRegisterAction(user);

      const email = {
        emailTo: user.email,
        subject: "Confirmação de Cadastro",
        text: `<h4>Confimação do Seu Cadastro Adm Fullstack</h4>
                  <td style="border-radius: 4px; background: #0095ff; color:white; text-align: center;">
                      <a href="http://localhost:8080/#/registration?email=${user.email}" style="background: #0095FF; border: 1px solid #0077cc; box-shadow: inset 0 1px 0 0 rgba(102,191,255,.75); font-family: arial, sans-serif; font-size: 17px; line-height: 17px; color: #ffffff; text-align: center; text-decoration: none; padding: 13px 17px; display: block; border-radius: 4px;">
                       Confirmar Cadastro
                   </a>
               </td>`,
      }

      await this.emailConfirmed(email);
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