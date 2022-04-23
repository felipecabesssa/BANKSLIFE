<template>
  <div class="categorias">
    <img alt="Vue logo" src="../assets/logo.png" width="150" />
    <div class="categoria">
      <h1>Categorias</h1>
      <div class="list" v-for="categoria in categorias" :key="categoria">
        <div class="dados">{{ categoria.id }}</div>
        <div class="dados">{{ categoria.nome }}</div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data(){
    return{
      categorias:{}
    }
  },
  methods:{
    getCategorias(){
      axios.get('http://localhost:8081/categorias').then(resp => {
        this.categorias = resp.data
      })
    }
  },
  created(){
    this.getCategorias()
  }
};
</script>

<style lang="scss" scoped>
.categoria {
  align-items: center;
  text-align: center;
  .list {
    width: 100%;
    align-items: center;
    justify-content: center;
    padding: 1%;
    display: flex;
    border: 1px solid grey;
    .dados {
      padding: 1%;
    }
  }
}
</style>