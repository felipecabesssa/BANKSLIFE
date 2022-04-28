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
    component: () => import('../views/produtos/Produtos.vue')
  },
  {
    path: '/produtos-adiciona',
    name: 'produtos-adiciona',
    component: () => import('../views/produtos/ProdutosAdd.vue')
  },
  {
    path: '/categorias',
    name: 'categorias',
    component: () => import('../views/categorias/Categorias.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
