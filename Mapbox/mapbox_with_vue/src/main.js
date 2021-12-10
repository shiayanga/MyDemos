import Vue from 'vue'
import App from './App.vue'
import VueRouter from "vue-router";
import routers from "@/router";
import ViewUI from 'view-design';
import 'view-design/dist/styles/iview.css';

Vue.use(VueRouter)
Vue.use(ViewUI);

const router = new VueRouter({
  mode:'history',
  routes:routers
})
new Vue({
  el:'#app',
  router,
  render: h => h(App),
})
