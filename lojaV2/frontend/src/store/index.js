import { createStore } from 'vuex'

export default createStore({
  state: {
    count:0,
    produtos:[]
  },
  getters: {
  },
  mutations: {
    increments(state){
      state.count++
    },
    decrement(state){
      state.count--
    },
    addProdutos(state, payload){
      state.produtos.push(payload)
    }
  },
  actions: {
    addProducts({ commit }, payload){
      commit('addProdutos', payload)
    }
  },
  modules: {
  }
})
