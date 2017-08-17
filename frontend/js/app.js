const my = require('../scss/style.scss');
import Vue from 'vue';
import ex from '../components/example.vue';

let app = new Vue({

  el: '#app',
  components: {
    'example': ex
  }

});
