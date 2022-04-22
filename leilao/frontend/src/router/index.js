import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/aguardando',
    name: 'aguardando',
    component: () => import('../views/Aguardando.vue')
  },
  {
    path: '/aprovado',
    name: 'aprovado',
    component: () => import('../views/Aprovado.vue')
  },
  {
    path: '/entregue',
    name: 'entregue',
    component: () => import('../views/Entregue.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
