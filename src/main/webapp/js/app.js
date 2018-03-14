import Vue from 'vue'
import App from './App.vue'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Router from 'vue-router'
import 'font-awesome/css/font-awesome.min.css'

import router from './router.js'

Vue.use(ElementUI);
Vue.use(Router);

new Vue({
  el: '#app',
  router,
  render: h => h(App)
});
