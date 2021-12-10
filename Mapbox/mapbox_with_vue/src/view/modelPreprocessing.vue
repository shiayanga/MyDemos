<template>
  <div>
    <Row type="flex" justify="center">
      <Col span="12">
        <Card>
          <p slot="title">
            <Icon type="ios-film-outline"></Icon>
            1. 使用npm安装obj2gltf
          </p>
          <ul>
            <li>
              <pre><code class="language-shell line-numbers">npm install -g obj2gltf</code></pre>
            </li>
          </ul>
        </Card>


        <Card>
          <p slot="title">
            <Icon type="ios-film-outline"></Icon>
            2. 执行命令
          </p>
          <ul>
            <li>
              把需要转的obj和带的贴图放在obj2gltf根目录下,在obj2gltf目录下打开命令行，进入到obj2gltf根目录，执行下列语句即可成功转换,-i表示输入文件，-o表示输出文件
              <pre><code class="language-bash  line-numbers">node bin\obj2gltf.js -i ./specs/data/box/box.obj -o box.gltf</code></pre>
            </li>
          </ul>
        </Card>
      </Col>
    </Row>

  </div>
</template>

<script>
export default {
  name: "modelPreprocessing"
}
</script>

<style scoped>

</style>