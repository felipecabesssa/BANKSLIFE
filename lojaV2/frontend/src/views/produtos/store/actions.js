import * as types from './mutation-types'
import Axios from 'axios'

export const getProdutos = ({ commit }) => {
    Axios.get('http://localhost:8081/produtos').then((resp) => {
        commit(types.GET_PRODUTOS, resp.data)
    })
}
