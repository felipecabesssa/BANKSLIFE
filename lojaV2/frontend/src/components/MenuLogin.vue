<template>
  <div class="main">
      <div class="login">
      <div class="buttons">
        <router-link to="/Login" v-if="!token">
          <h6>LogIn</h6>
        </router-link>

        <button v-if="token" class="btnLogout" @click="resetLogin">LogOut</button>

        <router-link class="btnCadastro" to="#">
          <h6>Cadastro</h6>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    data(){
        return{
        session: false
        }      
    },
    computed:{
        username(){
        return localStorage.username
        },
        token(){
        // return localStorage.token
        return this.$store.state.user.user.token
        },
    },
    mounted(){
        if(localStorage.token){
        this.session = true
        }
    },

    methods:{
        resetLogin(){
            localStorage.removeItem('token')
            this.$router.go()
        }
    }
}
</script>

<style lang="scss" scoped>
@import '../scss/colors.scss';

.btnLogout{
    color: $secondary;
    font-weight: 500;
    border: none;
    border-right: .2px solid #f4c54c;
    background-color: $primary;
}

.btnLogout:hover{
    color: $warning;
}

</style>