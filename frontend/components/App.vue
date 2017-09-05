<template>
<v-app height="415px" standalone>
  <v-navigation-drawer class="pb-0" id="main-navigation" persistent absolute clipped enable-resize-watcher v-model="drawer">

    <v-layout v-for="item in items" :key="item.title" row-xs child-flex-xs class="ma-2 stock">

      <v-card class="name mr-2">
        <v-card-text>{{ item.title }}</v-card-text>
      </v-card>
      <v-card class="price">
        <v-card-text>{{ item.price }}</v-card-text>
      </v-card>

    </v-layout>

  </v-navigation-drawer>


  <v-toolbar class="indigo lighten-2">
    <v-toolbar-title>
      <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
      <v-icon class="ml-3">fa-youtube</v-icon>
    </v-toolbar-title>
    <v-toolbar-title>Stock Market</v-toolbar-title>
    <v-spacer></v-spacer>
  </v-toolbar>

  <main>

      <v-layout>
        <v-flex xs12>
          <v-card height="300px"></v-card>
        </v-flex>
      </v-layout>

  </main>
</v-app>
</template>

<script>
export default {
  data: function() {
    return {
      drawer: true,
      items: [{
          title: 'Google',
          price: 410.23
        },
        {
          title: 'Yahoo',
          price: 230.23
        },
        {
          title: 'Apple',
          price: 520.23
        },
        {
          title: 'Boeng',
          price: 550.23
        },
      ]
    }

  }
}
</script>

<style lang="scss">
#main-navigation {
  height: calc(100vh - 64px);
}

.stock {

    .name {
        flex-grow: 2;
    }

    .price {
        flex-grow: 1;

    }

}
</style>
