<template>
  <div class="main">
      <h2>Atualizar Produto</h2>
      {{ produtos }}
      <h3>{{ id }}</h3>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  data(){
    return {
      id: this.$route.params.id
    }
  },
  computed: {
    ...mapState(['produtos'])
  },
  methods:{
    ...mapActions('produtos', ['findProdutosById'])
  },

  created(){
    this.findProdutosById(this.$route.params.id)
  }
}
</script>

<style>

</style>