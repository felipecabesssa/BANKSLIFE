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
    path: '/atualiza',
    name: 'atualiza',
    component: () => import('../views/produtos/ProdutosAtualiza.vue')
  },
  {
    path: '/categorias',
    name: 'categorias',
    component: () => import('../views/categorias/Categorias.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/login/Login.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
