<template>
  <div>
    <img alt="Vue logo" src="../../assets/logo.png" width="150" />
    
    <div class="principal">
      <div class="topo">
        <h1>Produtos</h1>
        <button class="btn btn-warning"><router-link class="link" to="/produtos-adiciona">Adicionar Produto</router-link></button>
      </div>
      <hr />

      <div class="container">
        <ul>
          <li>
            <div class="dados" id="id"><strong>Id</strong></div>
            <div class="dados" id="descricao"><strong>Descrição</strong></div>
            <div class="dados" id="estoque"><strong>Qtd</strong></div>
            <div class="dados" id="preco"><strong>Preço</strong></div>
            <div class="dados" id="preco"><strong>Imagem</strong></div>
            <div class="dados" id="imagem"><strong>Ação</strong></div>
          </li>
        </ul>
      </div>

      <div class="container" v-for="dado in produtos.produtos" :key="dado.id">
        <ul>
          <li>
            <div class="dados" id="id">{{ dado.id }}</div>
            <div class="dados" id="nome">{{ dado.nome }}</div>
            <div class="dados" id="estoque">{{ dado.quantidade }}</div>
            <div class="dados" id="preco">{{ dinheiro(dado.preco) }}</div>
            <div class="dados" id="image">
              <img :src="'fotos/' + dado.path" alt="">
            </div>
            <!-- <div class="dados" id="acao"></div> --> 
            <div class="dados btnDiv" id="acao">
              <router-link v-bind:to="{ name: 'atualiza', params: { id: dado.id } }">
                <button class="btnAddProd"><!--&#10227;--><i class="fa-solid fa-pen-to-square"></i></button>
              </router-link>
              <button v-on:click="excluirProduto(dado.id)" class="btnDelete"><i class="fa-solid fa-trash-can"></i></button>
            </div>
          </li>
        </ul>
      </div>
      <hr />
      <!-- 
      <div class="mt-4" v-for="dado in dados" :key="dado.id">
        <div v-if="dado.categoria.nome == 'Shapes'">{{ dado.nome }}</div>
      </div>
      -->
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  data() {
    return {
    };
  },
  methods: {
    ...mapActions('produtos', ['getProdutos', 'deletaProdutos']),

    dinheiro(valor) {
      if(valor){
        let valorFinal = new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(valor)
        return valorFinal;
      } else {
        return "R$ -----";
      }
    },

    async excluirProduto(id){
      try{
        await this.deletaProdutos(id)
        // this.getProdutos()
        this.$router.go()
      }
      catch(err){
        alert('Não foi possível excluir ' + err)
      }
    }

  },
  computed:{
    ...mapState(['produtos'])
  },
  created(){
    this.getProdutos()
  }
};
</script>


<style lang="scss" scoped>
.principal {
  .topo{
    margin-top: 10px;
    display: flex;
    justify-content: space-around;
    padding: 2%;
    button{
      padding: 5px;
      max-height: 40px;
    } 
  }
  .link{
    text-decoration: none;
    color: #000;
  }
  ul {
    color: #2c3e50;
    list-style: none;
    li {
      display: flex;
      justify-content: space-between;
      border: solid 1px #2c3e50;
    }
    .dados {
      padding: 0.5%;
      border-left: solid 1px #2c3e50;
      border-right: solid 1px #2c3e50;
    }
    #id {
      min-width: 8%;
      border-left: none;
    }
    #nome {
      min-width: 40%;
      border: none;
    }
    #descricao {
      color: #f4c54c;
      min-width: 40%;
      border: none;
    }
    #estoque {
      min-width: 8%;
    }
    #preco {
      min-width: 16%;
      border-right: none;
      border-left: none;
    }
    #image {
      max-width: 16%;
      img{
        max-width: 45%;
      }
    }
    .btnAddProd{
      height: 27px;
      background-color: #ffc107;
      border: none;
      border-radius: 2px;
    }
    .btnDelete{
      color: #fff;
      margin-left: 5px;
      height: 27px;
      background-color: red;
      border: none;
      border-radius: 2px;
    }
    .btnDiv{
      width: 16%;
      border-right: none;
    }
    #acao{
      border-right: none;
      min-width: 16%;
    }
  }
  
}
</style>