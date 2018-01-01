const webpack = require('webpack');
module.exports = {
	// resolve: {
 //    alias: {
 //      'vue$': '' // 'vue/dist/vue.common.js' for webpack 1
 //    }
 //  },
  entry: {
    main: './vue/main.js',
  },
  output: {
    path: __dirname + '/js/',
    filename: '[name].js',
  }
};
