<template>
  <div>
    <Row type="flex" justify="space-around">
      <Col span="12" style="height: 800px">
        <div id="map"></div>
      </Col>
      <Col span="11">
          <pre><code class="language-js line-numbers">mapboxgl.accessToken = 'Your token here'

/*
* 1. 初始化底图。
* */
const map = new mapboxgl.Map({
  container: 'map',
  style: 'mapbox://styles/mapbox/light-v10',
  zoom: 18,
  center: [148.9819, -35.3981],
  pitch: 60,
});

/*
* 2. 创建一个 Threebox 对象
* */
window.tb = new Threebox(
  map,
  map.getCanvas().getContext('webgl'),
  {
    defaultLights: true,
    // 如果 multiLayer 设置为 true，将会创建一个管理 tb.update 的默认自定义图层
    multiLayer: true,
  }
);

/*
* 3. 当 Mapbox 的样式加载时，开始向 Mapbox 添加模型所在的图层
* */
map.on('style.load', function () {
  try {
    map.addLayer(createCustomLayer(map,"model",[148.9819, -35.3981],'/model/plane.glb'))
  }catch (e) {
    console.log(e)
  }
})

/*
* 4. addModel 方法是使用第二步创建的 Threebox 对象去加载指定路径的模型
* */
addModel(map,layerName,origin,obj){
  let options = {
    type:'gltf',
    obj:obj,
    units: 'meters', //默认值中的单位始终以米为单位
    scale:10,
    rotation: { x: 90, y: 0, z: 0 },
  }
  tb.loadObj(options, function (model) {
    // 为模型设置坐标
    model.setCoords(origin);
    tb.add(model, layerName);
  });
}

/*
* 5. 创建自定义图层
* */
createCustomLayer(map,layerName,origin,obj){
  var _ = this
  return {
    id: layerName,
    type: 'custom',
    renderingMode: '3d',
    onAdd: function (map, gl) {
      addModel(map,layerName, origin,obj);
    },
    render: function (gl, matrix) {
      //tb.update(); 如果 multiLayer 设置为 true，这里的 tb.update() 就不再需要了
    }
  }
}
          </code></pre>
      </Col>
    </Row>
  </div>
</template>

<script>
import mapConfig from "../../config/mapConfig";
import mapboxgl from "mapbox-gl";
import { Threebox } from 'threebox-plugin'

export default {
  name: "addModel",
  mounted() {
    this.init()
  },
  methods: {
    init() {
      var _ = this
      mapboxgl.accessToken = mapConfig.access_token;
      // eslint-disable-next-line no-unused-vars
      const map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/light-v10',
        zoom: 18,
        center: [148.9819, -35.3981],
        pitch: 60,
      });
      window.tb = new Threebox(
          map,
          map.getCanvas().getContext('webgl'),
          {
            defaultLights: true,
            multiLayer: true, // this will create a default custom layer that will manage a single tb.update
          }
      );
      map.on('style.load', function () {
        try {
          map.addLayer(_.createCustomLayer(map,"model",[148.9819, -35.3981],'/model/plane.glb'))
        }catch (e) {
          console.log(e)
        }
      })
    },
    addModel(map,layerName,origin,obj){
      // eslint-disable-next-line no-debugger

      let options = {
        type:'gltf',
        obj:obj,
        units: 'meters', //units in the default values are always in meters
        scale:10,
        rotation: { x: 90, y: 0, z: 0 },
      }
      // eslint-disable-next-line no-undef
      tb.loadObj(options, function (model) {
        model.setCoords(origin);
        // eslint-disable-next-line no-undef
        tb.add(model, layerName);
      });
    },
    createCustomLayer(map,layerName,origin,obj){
      var _ = this
      return {
        id: layerName,
        type: 'custom',
        renderingMode: '3d',
        // eslint-disable-next-line no-unused-vars
        onAdd: function (map, gl) {
          _.addModel(map,layerName, origin,obj);
        },
        // eslint-disable-next-line no-unused-vars
        render: function (gl, matrix) {
          //tb.update(); is not needed anymore if multiLayer : true
        }
      }
    }
  }
}
</script>

<style scoped>
#map {
  position: absolute;
  top: 0;
  bottom: 0;
  width: 100%;
}
</style>