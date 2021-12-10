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
import mapboxgl from "mapbox-gl";
import mapConfig from "../../config/mapConfig";

export default {
  name: "addGeoJson",
  data() {
    return {
      geojson:{
        type: "FeatureCollection",
        features: [
          {
            type: "Feature",
            id: "gis_plane.266a4e1108bc46c58cebbb39006065a2",
            geometry: {
              type: "Polygon",
              coordinates: [
                [
                  [
                    109.86545438,
                    38.72911019,
                    949.30348512
                  ],
                  [
                    109.86975807,
                    38.72568961,
                    949.62881486
                  ],
                  [
                    109.86519485,
                    38.71922093,
                    939.82848947
                  ],
                  [
                    109.85902506,
                    38.72415957,
                    932.82375475
                  ],
                  [
                    109.86544819,
                    38.7291244,
                    949.30253152
                  ],
                  [
                    109.86545438,
                    38.72911019,
                    949.30348512
                  ]
                ]
              ]
            },
            geometry_name: "geom",
            properties: {
              fclass: null,
              plane_name: "新增工作面1",
              attr: "",
              create_by: "admin",
              create_time: "2021-12-07Z",
              level: ""
            }
          }
        ],
        totalFeatures: 1,
        numberMatched: 1,
        numberReturned: 1,
        timeStamp: "2021-12-10T07:10:51.432Z",
        crs: {
          type: "name",
          properties: {
            name: "urn:ogc:def:crs:EPSG::4326"
          }
        }
      }
    }
  },
  mounted() {
    this.init()
  },
  methods:{
    init(){
      var _ = this
      mapboxgl.accessToken = mapConfig.access_token
      var map = new mapboxgl.Map({
        container: 'map', // container ID
        style: 'mapbox://styles/mapbox/streets-v11', // style URL
        center: [ 109.86545438,38.72911019,], // starting position [lng, lat]
        zoom: 15 // starting zoom
      });
      // eslint-disable-next-line no-unused-vars
      map.on('load',function (e) {
        _.addData(map)
      })
    },
    addData(map){
      var _ = this
      map.addLayer({
        id:'json',
        source: {
          type: 'geojson',
          data: _.geojson
        },
        type:'fill',
        paint:{
          'fill-color':'#000000',
          'fill-opacity':0.5
        }

      })
    }
  }
}
</script>

<style scoped>
#map { position: absolute; top: 0; bottom: 0; width: 100%;}
</style>