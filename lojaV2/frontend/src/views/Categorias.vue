<template>
  <div class="categorias">
    <img alt="Vue logo" src="../assets/logo.png" width="150" />
    <div class="categoria">
      <h1>Categorias</h1>
      <div class="list" v-for="categoria in categorias" :key="categoria">
        <div class="dados">{{ categoria.id }}</div>
        <div class="dados">{{ categoria.nome }}</div>
      </div>
      <div class="vuex">
        {{ count }}
        <button class="btn btn-warning" v-on:click="increments">+</button>
        <button class="btn btn-warning" v-on:click="decrement">-</button>
      </div>
      <hr>
      <div class="produtos">
        {{ produtos }}
        <input v-model="products" class="form-control form-control-sm" type="text">
        <button class="btn btn-warning" v-on:click="addProducts(products)">+</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import { mapState, mapMutations, mapActions } from 'vuex'
export default {
  data(){
    return{
      categorias:{},
      products:''
    }
  },
  methods:{
    getCategorias(){
      axios.get('http://localhost:8081/categorias').then(resp => {
        this.categorias = resp.data
      })
    },
    ...mapMutations(['increments', 'decrement']),
    ...mapActions(['addProducts'])
  },
  created(){
    this.getCategorias()
  },
  computed:{
    ...mapState(['count', 'produtos'])
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
    border: 1px solid #2c3e50;
    .dados {
      padding: 1%;
    }
  }
}

.vuex{
  display: flex;
  font-size: 30px;
  font-weight: 900;
  align-items: center;
  justify-content: center;
}

.btn{
  margin: 1%;
  width: 50px;
}

.produtos{
  display: flex;
  flex-direction: column;
  align-items: center;
    input{
      border-bottom: solid 1px #2c3e50;
    }
}
</style>