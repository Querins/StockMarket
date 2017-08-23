import '../scss/style.scss'; // Ensure you are using css-loader

import Vue from 'vue'
import Vuetify from 'vuetify'

Vue.use(Vuetify);

import mainComponent from '../components/App.vue';

let app = new Vue({

  el: '#app',
  components: {
    'app': mainComponent
  }

});
