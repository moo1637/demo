const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

  pluginOptions: {
    vuetify: {
      // https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
    }
  },
  outputDir: '../src/main/resources/static',
  devServer: {
    proxy: {
      '/shop': {
        target: 'http://localhost:8080'
      }
    }
  }
})
