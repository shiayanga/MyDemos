<template>
  <div class="hello">
    <img alt="Vue logo" src="../assets/mapbox.webp">
    <img alt="Vue logo" src="../assets/logo.png" style="margin-left: 2%">
    <h1>{{ msg }}</h1>
    <p>
      This is a guide,demo and recipes on how to use Mapbox in Vue.js
    </p>
    <h3>How to Use Mapbox</h3>
    <ul>
      <li><h4>1. Install</h4>
        <p>npm install --save mapbox-gl</p></li>
      <li><h4>2. import</h4>
        <p>import mapboxgl from 'mapbox-gl'</p></li>
    </ul>
    <h3>Demos</h3>
    <ul>
      <li><a href="/DisplayAMap">Display a map</a></li>
      <li><a href="/addTerrain">Add 3D terrain to a map</a></li>
    </ul>
    <h3>Essential Links</h3>
    <ul>
      <li><a href="https://docs.mapbox.com/mapbox-gl-js/api/" target="_blank" rel="noopener">Mapbox API Docs</a></li>
      <li><a href="https://docs.mapbox.com/mapbox-gl-js/example/" target="_blank" rel="noopener">Mapbox official
        Demos</a></li>
    </ul>

  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  methods: {
    goTo(param) {
      this.$router.push(param)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
