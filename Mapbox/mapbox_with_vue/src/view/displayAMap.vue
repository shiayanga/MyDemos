<template>
  <div>
    <Row type="flex" justify="space-around">
      <Col span="15" style="height: 800px">
          <div id="map"></div>
      </Col>
      <Col span="8">
          <pre><code class="language-js line-numbers">mapboxgl.accessToken = 'Your token here'
new mapboxgl.Map({
  container: 'map', // container ID
  style: 'mapbox://styles/mapbox/streets-v11', // style URL
  center: [-74.5, 40], // starting position [lng, lat]
  zoom: 9 // starting zoom
});
          </code></pre>
      </Col>
    </Row>
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
#map { position: absolute; top: 0; bottom: 0; width: 100%;}
</style>