import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import bootstrap from './bootstrap'
import axios from 'axios'
import money from 'v-money'

createApp(App)
.use(store)
.use(router)
.use(bootstrap)
.use(money)
.provide(axios)
.mount('#app')
