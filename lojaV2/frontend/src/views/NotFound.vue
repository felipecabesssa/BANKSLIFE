<template>
  <h2>404</h2>
  <h3>Página Não encontrada</h3>
  <button class="btn btn-warning" @click="voltar">Voltar</button>
</template>

<script>
export default {
    methods:{
        voltar(){
            this.$router.go(-1)
        }
    }

}
</script>

<style>

</style>