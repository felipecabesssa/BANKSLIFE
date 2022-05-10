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
            var token = localStorage.getItem('token')
            const headers = { Authorization: `Bearer ${token}` }
            axios.get('http://localhost:8081/categorias', { headers }).then(resp => {
                commit('getCategoriasM', resp.data)
            })
        }
    }

}