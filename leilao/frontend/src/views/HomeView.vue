<template>
  <div class="home">
    <!-- <img src="./../assets/logoSemfundo.png" alt=""> -->

  <div class="container">
    <div class="card mb-3">

      <div class="card-header text-dark alert-dark"><p class="alinhaEsquerda">Nome do produto</p></div>

      <div class="card-body">
          <div class="row">
              <div class="col-12 col-sm-8 mb-3">
                  <div class="row text-dark mb-3">
                      <div class="col-md-4 alinhaEsquerda">Valor: <span>200</span></div>
                      <div class="col-md-8 alinhaEsquerda">Data da entrega: <span>22/05/2022</span></div>
                  </div>

                  <!-- <div>Produto</div> -->
                  <div class="mb-3"><input class="form-control" value="url do produto"/></div>

                  <!-- <div>Descrição</div> -->
                  <div>
                      <textarea rows="10" class="form-control">descrição do pedido</textarea>
                  </div>
              </div>
              <div class="col-12 col-sm-4">
                  <div>
                      <img class="img-thumbnail" src=""/>
                  </div>
              </div>
          </div>
      </div>
  </div>
  </div>

  </div>
</template>

<script>

export default {
  name: 'HomeView',
  components: {

  }
}
</script>

<style lang="scss" scoped>

.alinhaEsquerda{
  text-align: left;
}

</style>
