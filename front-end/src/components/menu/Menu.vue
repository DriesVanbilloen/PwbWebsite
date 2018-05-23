<template>
  <v-navigation-drawer permanent>
    <v-toolbar flat>
      <v-list>
        <v-list-tile>
          <v-list-tile-title class="title">
            Pwb Applicatie
          </v-list-tile-title>
        </v-list-tile>
      </v-list>
    </v-toolbar>
    <v-divider></v-divider>
    <v-list dense class="pt-0">
      <v-list-tile class="tile" v-for="item in items" :key="item.title" @click="">
        <v-list-tile-action>
          <v-icon class="icon">{{ item.icon }}</v-icon>
        </v-list-tile-action>
        <v-list-tile-content>
          <v-list-tile-title class="tile-title">{{ item.title }}</v-list-tile-title>
        </v-list-tile-content>
      </v-list-tile>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
  export default {
    data () {
      return {
        items: [
          { title: 'Home', icon: 'dashboard' },
          { title: 'Bestelling', icon: 'edit' }
        ],
        right: null
      }
    }
  }


</script>
<style lang="css">
div.list:nth-child(3) > div > a {
  display: flex;
  margin-bottom: 20px;
  margin-top: 20px;
}
.tile-title {
  width: 150px;
  margin-left: 75px;
  text-align: left;
}
.title {

}


</style>
