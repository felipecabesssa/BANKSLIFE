import axios from "axios"

export default {

    state: {
        categorias: [ ]
    },

    mutations: {
        getCategoriasM(state, payload){
            state.categorias = payload
        }
    },

    actions: {
        getCategorias( { commit } ){
            axios.get('http://localhost:8081/categorias').then(resp => {
                commit('getCategoriasM', resp.data)
            })
        }
    }

}