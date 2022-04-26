import * as types from './mutation-types'

export default {
    [types.GET_PRODUTOS](state, payload){
        state.produtos = payload
    }
}
