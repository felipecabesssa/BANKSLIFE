import * as types from './mutation-types'

export default {
    [types.GET_PRODUTOS](state, payload){
        state.produtos = payload
    },
    [types.ADD_PRODUTOS](state, payload){
        state.produtos = payload
    },
    [types.FIND_PRODUTOS](state, payload){
        state.produtos = payload
    }
}
