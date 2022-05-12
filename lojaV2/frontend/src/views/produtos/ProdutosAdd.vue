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

            <div class="row mt-3">
                <label for="">Selecione a Categoria</label>
                <select id="categorias" v-model="form.categoria">
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
                <label for="">Preço</label>
                <input v-model="preco" v-money="money" type="text">
            </div>
            <div class="botao mt-3 mb-3">
                <button v-on:click="addProducts" class="btn btn-warning">Cadastrar</button>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex';
import {VMoney} from 'v-money'
export default {
    directives: {money: VMoney},
    data(){
        return{
            form:{
                nome: '',
                quantidade: '',
                categoria:''
            },
            preco: 0,
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
    methods:{
        ...mapActions('produtos', ['addProdutos']),
        
        addProducts(add){
            this.preco = this.preco.replace(/\./g, '')
            this.preco = this.preco.slice(3).replace(',', '.')

            add = {
                nome:this.form.nome,
                quantidade:this.form.quantidade,
                preco:this.preco,
                categoria: { id: parseInt(this.form.categoria) }
            }
            // console.log(add) - teste de inclusao no console
            this.addProdutos(add)
            this.form.nome = ''
            this.form.quantidade = ''
            this.preco = ''
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