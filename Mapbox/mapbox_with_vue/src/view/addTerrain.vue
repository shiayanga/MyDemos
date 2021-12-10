<template>
  <div>
    <Row type="flex" justify="space-around">
      <Col span="12" style="height: 900px">
        <div id="map"></div>
      </Col>
      <Col span="11">
          <pre><code class="language-js line-numbers">/*
* 1. 设置mapbox token
* 获取token的地址是：https://account.mapbox.com/
* */

mapboxgl.accessToken = 'Your token here'

/*
* 2. 初始化底图。可以是一个空白底图，也可以是其他类型的底图（不包含高程数据的）
* */
var map = new mapboxgl.Map({
  container:'map',
  zoom:'15',
  center: [110.36184463256029, 39.74647486122967],
  pitch: 85,
  bearing: 0,
  style: 'mapbox://styles/mapbox-map-design/ckhqrf2tz0dt119ny6azh975y'
})

// eslint-disable-next-line no-unused-vars
map.on('load',function () {
  /*
  * 3. 添加高程数据
  * */
  map.addSource('dem',{
    type:'raster-dem', // 高程数据的类型
    scheme: "tms", // 这个参数是影响Y方向的平铺，tms 代表 OSGeo 规范
    tiles:[
        // 这里是切片地址，要加载不同的切片，只需要修改IP地址、端口号、kingc_gis%3AHJDEM1209（代表的是图层组名字） 即可
      'http://192.168.111.90:22215/geoserver/gwc/service/tms/1.0.0/kingc_gis%3AHJDEM1209@EPSG%3A900913@png/{z}/{x}/{y}.png'
    ],
    'tileSize': 256,
  })
  /*
  * 4. 设置地形属性
  * 参数：
  *   要设置的地形属性，如果值为 null 或 undefined，则不渲染地形
  *   属性的参数请参照：https://docs.mapbox.com/mapbox-gl-js/style-spec/terrain/
  * */
  map.setTerrain({ 'source': 'dem', 'exaggeration': 1.5 });
})

/*
* 这里是给底图添加事件
* */
map.on('click',function (e) {
  console.log(e)
})
          </code></pre>
      </Col>
    </Row>
  </div>
</template>

<script>
import mapConfig from "../../config/mapConfig";
import mapboxgl from "mapbox-gl";
export default {
  name: "addTerrain",
  mounted() {
    this.init()
  },
  methods : {
    init(){
      /*
      * 1. 设置mapbox token
      * 获取token的地址是：https://account.mapbox.com/
      * */

      mapboxgl.accessToken = mapConfig.access_token

      /*
      * 2. 初始化底图。可以是一个空白底图，也可以是其他类型的底图（不包含高程数据的）
      * */
      var map = new mapboxgl.Map({
        container:'map',
        zoom:'15',
        center: [110.36184463256029, 39.74647486122967],
        pitch: 85,
        bearing: 0,
        style: 'mapbox://styles/mapbox-map-design/ckhqrf2tz0dt119ny6azh975y'
      })

      // eslint-disable-next-line no-unused-vars
      map.on('load',function () {
        /*
        * 3. 添加高程数据
        * */
        map.addSource('dem',{
          type:'raster-dem', // 高程数据的类型
          scheme: "tms", // 这个参数是影响Y方向的平铺，tms 代表 OSGeo 规范
          tiles:[
              // 这里是切片地址，要加载不同的切片，只需要修改IP地址、端口号、kingc_gis%3AHJDEM1209（代表的是图层组名字） 即可
            'http://192.168.111.90:22215/geoserver/gwc/service/tms/1.0.0/kingc_gis%3AHJDEM1209@EPSG%3A900913@png/{z}/{x}/{y}.png'
          ],
          'tileSize': 256,
        })
        /*
        * 4. 设置地形属性
        * 参数：
        *   要设置的地形属性，如果值为 null 或 undefined，则不渲染地形
        *   属性的参数请参照：https://docs.mapbox.com/mapbox-gl-js/style-spec/terrain/
        * */
        map.setTerrain({ 'source': 'dem', 'exaggeration': 1.5 });
      })

      /*
      * 这里是给底图添加事件
      * */
      map.on('click',function (e) {
        console.log(e)
      })
    }
  }
}
</script>

<style scoped>
#map { position: absolute; top: 0; bottom: 0; width: 100%;}
</style>