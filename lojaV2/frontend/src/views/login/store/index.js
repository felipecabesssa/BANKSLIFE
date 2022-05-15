export default {

    state:{
        user: { username:'', token:'' }
    },

    mutations:{
        setUser(state, payload){
            state.user = payload
        }
    },

    actions:{
        setUserLogin({ commit }){
            var username = localStorage.getItem('username')
            var token = localStorage.getItem('token')
            const userLogin = { username: username, token: token }
            commit('setUser', userLogin)
        }
    },

    namespaced: true

}