<template>
  <div class="categorias">
    <img alt="Vue logo" src="../../assets/logo.png" width="150" />
    <div class="categoria">
      <h1>Categorias</h1>
      <div class="list" v-for="categoria in categorias.categorias" :key="categoria">
        <div class="categorias">
          <div class="dados">{{ categoria.id }}</div>
          <div class="dados">
            <button class="botao" v-on:click="mostrarProdutos(categoria.id)">
              {{ categoria.nome }}
            </button>
          </div>
        </div>
        <div class="row" v-for="products in produtos.produtos" :key="products.id">
        <div v-if="products.categoria" class="produtos">
          <ul v-if="products.categoria.id == produtoId && categoria.id == produtoId">
            <li>
              {{ products.nome }}
            </li>
          </ul>
        </div>
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
      produtoId:''
    }
  },
  methods:{
    ...mapActions('categorias',['getCategorias']),
    ...mapActions('produtos',['getProdutos']),

    mostrarProdutos(id){
      id != this.produtoId ? this.produtoId = id : this.produtoId = ''
      console.log(this.produtoId)
    }
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
@import '../../scss/colors.scss';
.categoria {
  align-items: center;
  text-align: center;
  padding: 5%;
  .list {
    width: 100%;
    align-items: center;
    justify-content: center;
    padding: 1%;
    display: flex;
    flex-direction: column;
    border: 1px solid #2c3e50;
    .dados {
      padding: 1%;
    }
  }
  .categorias{
    display: flex;
    justify-content: center;
    width: 100%;
    background-color: $dark;
  }
  .row{
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
    .produtos{
      width: 100%;
      ul{
        padding-top: 5px;
        width: 100%;
        display: flex;
        list-style: none;
        border-bottom: solid 1px $dark;
      }
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

.botao{
  border: none;
  color: $warning;
  background-color: $dark;
}
</style>