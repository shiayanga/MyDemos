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
        <pre><code class="language-shell line-numbers">npm install --save mapbox-gl</code></pre>
      </li>
      <li><h4>2. import</h4>
        <pre><code class="language-shell  line-numbers">import mapboxgl from 'mapbox-gl'</code></pre>
      </li>
    </ul>
    <h3>Data processing</h3>
    <ul>
      <li><a href="/modelPreprocessing">3D Model Preprocessing</a></li>
      <li><a href="https://blog.csdn.net/semian7633/article/details/120027672">Convert DEM data to Mapbox Terrain Style</a></li>
    </ul>
    <h3>Demos</h3>
    <ul>
      <li><a href="/DisplayAMap">Display</a></li>
      <li><a href="/addTerrain">Add 3D terrain</a></li>
      <li><a href="/addModel">Add 3D Model</a></li>
      <li><a href="/addGeoJson">Add GeoJSON</a></li>
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
import Prism from "prismjs";

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  mounted() {
    Prism.highlightAll()
  },
  methods: {
    goTo(param) {
      this.$router.push(param)
    }
  }
}
</script>

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
