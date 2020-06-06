import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

const state = {//要设置的全局访问的state对象
    username: '' || sessionStorage.getItem('username'),
    password: '' || sessionStorage.getItem('password'),
    nickname: '' || sessionStorage.getItem('nickname')
}

const getters = {
    username: (state) => state.username,
    password: (state) => state.password,
    nickname: (state) => state.nickname
}

const mutations = {
    handleUsername: (state, username) => {
        state.username = username
        sessionStorage.setItem('username', username)
    },
    handlePassword: (state, password) => {
        state.password = password
        sessionStorage.setItem('password', password)
    },
    handleNickname: (state, nickname) => {
        state.nickname = nickname
        sessionStorage.setItem('nickname', nickname)
    },
    clearUserInfo: () => {
        sessionStorage.setItem('username', '')
        sessionStorage.setItem('password', '')
        sessionStorage.setItem('nickname', '')
    }
}

const store = new Vuex.Store({
    state,
    getters,
    mutations
})

export default store;