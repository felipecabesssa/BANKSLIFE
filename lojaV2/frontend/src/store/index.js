// import { vuex } from 'vuex'
// import Axios from 'axios'
import { createStore } from 'vuex'
import { store as produtos } from './../views/produtos'

// export default createStore({
//   state: {
//     count:0,
//     produtos:[]
//   },
//   getters: {
//   },
//   mutations: {
//     increments(state){
//       state.count++
//     },
//     decrement(state){
//       state.count--
//     },
//     addProdutos(state, payload){
//       state.produtos.push(payload)
//     }
//   },
//   actions: {
//     addProducts({ commit }, payload){
//       commit('addProdutos', payload)
//     }
//   },
//   modules: {
//   }
// })

const categorias = {
  state: {
    categorias:[]
  }
}

// const produtos = {
//   state: {
//     produtos:[]
//   },

//   mutations:{
//     getProdutosM(state, payload){
//       state.produtos = payload
//     }
//   },

//   actions:{
//     getProdutos({ commit }){
//       Axios.get('http://localhost:8081/produtos').then(resp => {
//         commit('getProdutosM', resp.data)
//       })
//     }
//   }
// }

// const store = new vuex.Store({
//   modules: {
//     categorias,
//     produtos
//   }
// })

const store = createStore({
  modules: {
    categorias,
    produtos
  }
})

export default store
