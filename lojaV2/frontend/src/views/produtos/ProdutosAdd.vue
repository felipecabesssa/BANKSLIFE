<template>
  <img alt="Vue logo" src="../../assets/logo.png" width="150" />

  <div class="main">
    <h1>Novos Produtos</h1>
    <div class="container">
        <div class="form">
            <div class="row">
                <label for="">Descrição</label>
                <input v-model="form.nome" type="text">
            </div>
            <div class="row">
                <label for="">Quantidade</label>
                <input v-model="form.quantidade" type="text">
            </div>
            <div class="row">
                <label for="">Preço</label>
                <input v-model="form.preco" type="text">
            </div>
            <div class="botao mt-3 mb-3">
                <button v-on:click="addProducts" class="btn btn-warning">Cadastrar</button>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
    data(){
        return{
            form:{
                nome: '',
                quantidade: '',
                preco: ''
            }
        }
    },
    methods:{
        ...mapActions('produtos', ['addProdutos']),
        
        addProducts(add){
            add = {
                nome:this.form.nome,
                quantidade:this.form.quantidade,
                preco:this.form.preco
            }
            this.addProdutos(add)

            this.form.nome = ''
            this.form.quantidade = ''
            this.form.preco = ''
        }

    }

}
</script>

<style lang="scss" scoped>

.form{
    padding: 3%;
}
.row{
    text-align: left;
}
label{
    padding: 5px;
}
.botao{
    margin-top: 15px;
}

</style>