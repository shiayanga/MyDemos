module.exports = {
  presets: [
    '@vue/cli-plugin-babel/preset'
  ],
  plugins: [
    ["prismjs", {
      "languages": ["javascript", "css", "markup",'shell'],
      "plugins": ["line-numbers"], //配置显示行号插件
      "theme": "okaidia", //主体名称
      "css": true
    }]
  ]
}
