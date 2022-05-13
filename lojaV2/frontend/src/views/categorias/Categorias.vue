<template>
  <div class="categorias">
    <img alt="Vue logo" src="../../assets/logo.png" width="150" />
    <div class="categoria">
      <h1>Categorias</h1>
      <div class="list" v-for="categoria in categorias.categorias" :key="categoria">
        <div class="dados">{{ categoria.id }}</div>
        <div class="dados">{{ categoria.nome }}</div>
      </div>
      <div class="row" v-for="products in produtos.produtos" :key="products.id">
        <div v-if="products.categoria" class="produtos">
          {{ products }}
        </div>
      </div>
      <hr>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  data(){
    return{
      products:''
    }
  },
  methods:{
    ...mapActions('categorias',['getCategorias']),
    ...mapActions('produtos',['getProdutos'])
  },
  created(){
    this.getCategorias(),
    this.getProdutos()
  },
  computed:{
    ...mapState(['categorias', 'produtos'])
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
  .row{
    display: flex;
    flex-direction: column;
    align-items: center;
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