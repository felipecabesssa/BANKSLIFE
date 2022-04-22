import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('../views/AboutView.vue')
  },
  {
    path: '/produtos',
    name: 'produtos',
    component: () => import('../views/Produtos.vue')
  },
  {
    path: '/categorias',
    name: 'categorias',
    component: () => import('../views/Categorias.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
