import * as types from './mutation-types'
import Axios from 'axios'

export const getProdutos = ({ commit }) => {
    var token = localStorage.getItem('token')
    const headers = { Authorization: `Bearer ${token}` }
    Axios.get('http://localhost:8081/produtos', { headers }).then((resp) => {
        commit(types.GET_PRODUTOS, resp.data)
    })
}

export const addProdutos = ({ commit }, add) => {
    var token = localStorage.getItem('token')
    const headers = { Authorization: `Bearer ${token}` }
    Axios.post('http://localhost:8081/produtos', add, { headers }).then((resp) => {
        commit(types.ADD_PRODUTOS, resp.data)
    })
}

export const findProdutosById = ( { commit }, id ) => {
    var token = localStorage.getItem('token')
    const headers = { Authorization: `Bearer ${token}` }
    Axios.get('http://localhost:8081/produtos/' + id, { headers }).then(resp => {
        const dados = {
            id: resp.data.id,
            nome: resp.data.nome,
            quantidade: resp.data.quantidade,
            preco: resp.data.preco.toFixed(2),
            path: resp.data.path,
            categoria: resp.data.categoria.id
        }
        commit(types.FIND_PRODUTOS, dados);
    })
}

export const atualizaProdutos = ( { commit }, add ) => {
    var token = localStorage.getItem('token')
    const headers = { Authorization: `Bearer ${token}` }
    Axios.put('http://localhost:8081/produtos/' + add.id, add, { headers }).then(resp => {
        commit(types.UPDATE_PRODUTOS, resp.data)
    })
}

export const deletaProdutos = ( { commit }, id ) => {
    var token = localStorage.getItem('token')
    const headers = { Authorization: `Bearer ${token}` }
    Axios.delete('http://localhost:8081/produtos/' + id, { headers }).then(resp => {
        commit(types.DELETE_PRODUTOS, resp.data)
    })
}
