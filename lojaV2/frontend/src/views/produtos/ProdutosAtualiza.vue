<template>
  <div class="main" v-for="product in produtos" :key="product.id">
    <h2>Atualizar Produto</h2>

    <div class="alert alert-success" v-if="ok">
      <h4>Dados atualizados com sucesso!</h4>
    </div>
    <div class="alert" v-else-if="error">
      <h4>{{ message }}</h4>
    </div>

    <div v-if="product.path" class="image">
      <img :src="'fotos/' + product.path" alt="">
    </div>

    <div class="container">
      <div class="form">

        <div class="row">
          <label for="">Selecione a Categoria</label>
          <select id="categorias" v-model="product.categoria">
          <option value="1">
              Shapes
          </option>
          <option value="2">
              Trucks
          </option>
          <option value="3">
              Rodas
          </option>
          <option value="4">
              Acessórios
          </option>
          </select>
        </div>

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
            <input v-model.lazy="product.preco" v-money="money" type="text">
        </div>
        <div class="botao mt-3 mb-3">
            <button v-on:click="atualizaProduto(product, product.preco)" class="btn btn-warning">Atualizar</button>
        </div>
      </div>
    </div>
    <div class="upload">
      <router-link :to="{ name: 'upload', params: { id:product.id } }">Upload</router-link>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import {VMoney} from 'v-money'
export default {
  directives: {money: VMoney},
  data(){
    return {
      id: this.$route.params.id,
      message: 'errrrrorr',
      ok: false,
      error: false,
      money: {
          decimal: ',',
          thousands: '.',
          prefix: 'R$ ',
          suffix: '',
          precision: 2,
          masked: false /* doesn't work with directive */
      }
    }
  },
  computed: {
    ...mapState(['produtos'])
  },
  methods:{
    ...mapActions('produtos', ['findProdutosById', 'atualizaProdutos']),

    async atualizaProduto(product, price){
      price = price.replace(/\./g, '')
      price = price.slice(3).replace(',', '.')
      const update = {
        id: product.id,
        nome: product.nome,
        quantidade: product.quantidade,
        preco: price,
        categoria: { id: product.categoria }
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

<style lang="scss" scoped>
.main{
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  .image{
    max-width: 40%;
    img{
      max-width: 50%;
    }
  }
}


.row{
    text-align: left;
}

.form{
  padding: 5%;
}


</style>