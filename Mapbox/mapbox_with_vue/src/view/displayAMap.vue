<template>
  <div>
    <div id="map"></div>
  </div>
</template>

<script>
import mapConfig from "../../config/mapConfig";
import mapboxgl from 'mapbox-gl'
export default {
  name: "DisplayAMap",
  mounted() {
    this.init()
  },
  methods:{
    init(){
      mapboxgl.accessToken = mapConfig.access_token
      new mapboxgl.Map({
        container: 'map', // container ID
        style: 'mapbox://styles/mapbox/streets-v11', // style URL
        center: [-74.5, 40], // starting position [lng, lat]
        zoom: 9 // starting zoom
      });
    }
  }
}
</script>

<style scoped>
#map { position: absolute; top: 0; bottom: 0; width: 90%;height: 90%;margin: 2.5% 5% 5% 5%}
</style>