import * as types from './mutation-types'
import Axios from 'axios'

export const getProdutos = ({ commit }) => {
    Axios.get('http://localhost:8081/produtos').then((resp) => {
        commit(types.GET_PRODUTOS, resp.data)
    })
}

export const addProdutos = ({ commit }, add) => {
    Axios.post('http://localhost:8081/produtos', add).then((resp) => {
        commit(types.ADD_PRODUTOS, resp.data)
    })
}

export const findProdutosById = ( { commit }, id ) => {
    Axios.get('http://localhost:8081/produtos/' + id).then(resp => {
        commit(types.FIND_PRODUTOS, resp.data)
    })
}

export const atualizaProdutos = ( { commit }, add ) => {
    Axios.put('http://localhost:8081/produtos/' + add.id, add).then(resp => {
        commit(types.UPDATE_PRODUTOS, resp.data)
    })
}
