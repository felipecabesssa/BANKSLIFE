<template>
  <div class="main">
      <div class="login">
        <h2>Login</h2>
        <label for="username">Usuario</label>
        <input v-model="username" type="text">
        <label for="password">Senha</label>
        <input v-model="password" type="password">
        <button v-on:click="enviarDadosLogin" class="btn btn-warning">Logar</button>
      </div>
  </div>
</template>

<script>
import Axios from 'axios';
import { mapActions } from 'vuex'
export default {
    data(){
        return{
            username: '',
            password: ''
        }
    },
    methods:{
        ...mapActions('user', ['setUserLogin']),
        enviarDadosLogin(){
            const dados = {
                username: this.username,
                password: this.password
            }
            Axios.post('http://localhost:8081/login', dados).then(response => {
                localStorage.setItem('token', response.data.token);
                localStorage.setItem('username', response.data.username);
                this.setUserLogin();
            });
            this.$router.push('/')
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
        width: 40%;
        button{
            margin-top: 10px;
        }
    }
}

</style>