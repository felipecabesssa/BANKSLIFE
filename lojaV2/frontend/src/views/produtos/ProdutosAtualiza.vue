<template>
  <div class="main" v-for="product in produtos" :key="product.id">
      <h2>Atualizar Produto</h2>

      <div class="alert alert-success" v-if="ok">
        <h4>Dados atualizados com sucesso!</h4>
      </div>
      <div class="alert" v-else-if="error">
        <h4>{{ message }}</h4>
      </div>

      <div class="container">
        <div class="form">
          <div class="row">
              <label for="">Descrição</label>
              <input v-model="product.nome" type="text">
          </div>
          <div class="row">
              <label for="">Quantidade</label>
              <input v-model="product.quantidade" type="text">
          </div>
          <div class="row">
              <label for="">Preço</label>
              <input v-model="product.preco" type="text">
          </div>
          <div class="botao mt-3 mb-3">
              <button v-on:click="atualizaProduto(product)" class="btn btn-warning">Atualizar</button>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  data(){
    return {
      id: this.$route.params.id,
      message: 'errrrrorr',
      ok: false,
      error: false
    }
  },
  computed: {
    ...mapState(['produtos'])
  },
  methods:{
    ...mapActions('produtos', ['findProdutosById', 'atualizaProdutos']),

    async atualizaProduto(product){
      const update = {
        id:product.id,
        nome:product.nome,
        quantidade:product.quantidade,
        preco:product.preco
      };
      try{
        await this.atualizaProdutos(update)
        await this.findProdutosById(product.id)
        this.ok = true
      }
      catch(err){
        err.data ? this.message = err.data.message : this.message = 'Não foi possível atualizar'
        this.error = true
      }
    }
  },

  created(){
    this.findProdutosById(this.$route.params.id)
  }
}
</script>

<style>

.row{
    text-align: left;
}


</style>