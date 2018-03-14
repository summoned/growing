import Vue from 'vue'
import VueRouter from 'vue-router'

import login from './custom/login.vue'
import home from './custom/home.vue'
import notFound from './custom/notfound.vue'
import sidebar from './custom/sidebar.vue'
import caller from './custom/caller.vue'

Vue.use(VueRouter);

let routes = [
  {
    path: '/page/login',
    component: login,
    name: '',
  },
  {
    path: '/404',
    component: notFound,
    name: '',
  },
  {
    path: '/',
    component: home,
    name: '',
    children: [
      {
        path: '/caller',
        component: caller,
        name: '',
      }
    ]
  },
  {
    path: '/sidebar',
    component: sidebar,
    name: '',
  },
];

let router = new VueRouter({routes});

export default router
