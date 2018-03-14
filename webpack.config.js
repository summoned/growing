var path = require('path');
var webpack = require('webpack');
const fs = require('fs')
//var HtmlWebpackPlugin = require('html-webpack-plugin')

const PORT = 3000
const HOST = '0.0.0.0'
const SERVER_ADDRESS = `http://${HOST}:${PORT}/`


module.exports = {
  entry: {
    'app': ['babel-polyfill', './src/main/webapp/js/app.js'],
  },
  output: {
    path: path.resolve(__dirname, './src/main/webapp/app/js'),
    filename: '[name].js',
    //publicPath: "/app/js/"
  },
  module: {
    rules: [
      {
        test: /\.css$/,
        use: [
          'vue-style-loader',
          'css-loader'
        ],
      },      {
        test: /\.vue$/,
        loader: 'vue-loader',
        options: {
          loaders: {
          }
          // other vue-loader options go here
        }
      },
      {
        test: /\.js$/,
        loader: 'babel-loader',
        exclude: /node_modules/
      },
      {
        test: /\.(png|jpg|gif|svg|eot|woff|woff2|ttf)$/,
        loader: 'url-loader',
        // options: {
        //   name: '[name].[ext]?[hash]'
        // }
      }
    ]
  },
  plugins: [
    new webpack.IgnorePlugin(/\.\/locale$/),
    new webpack.HotModuleReplacementPlugin()
  ],
  devtool: false,
  resolve: {
    alias: {
      'vue$': 'vue/dist/vue.esm.js',
      'js': path.resolve(__dirname, 'src/main/webapp/js/')
    },
    extensions: ['*', '.js', '.vue', '.json']
  },
  devServer: {
    port: PORT,
    compress: true,
    hot: true,
    overlay: true,
    host: HOST,
    publicPath: SERVER_ADDRESS,
    before(app){
      app.use((req, res, next) => {
        res.set('Access-Control-Allow-Origin', '*')
        next()
      })
    },
    proxy:{
      '/app/js/app.js': {
        target: SERVER_ADDRESS,
        pathRewrite: function(path, req){
          return path.replace(/\/app\/js\/app.js/, '\/app.js')
        }
      },
      '/vue/*.js':{
        target: SERVER_ADDRESS,
        pathRewrite: function(path, req){
          var newPath = path.replace(/\/vue/, '')
          return newPath
        }
      },
      '/': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        onProxyRes (proxyRes, req, res) {
          if (/account\/ns\/login/.test(proxyRes.headers.location)) {
            proxyRes.headers.location = 'http://' + req.headers.host +
              '/account/ns/login#/page/login'
          }
        },
      }
    }
  },
};

// if (process.env.NODE_ENV === 'production') {
//   module.exports.devtool = '#source-map';
//   // http://vue-loader.vuejs.org/en/workflow/production.html
//   module.exports.plugins = (module.exports.plugins || []).concat([
//     new webpack.DefinePlugin({
//       'process.env': {
//         NODE_ENV: '"production"'
//       }
//     }),
//     // new webpack.optimize.UglifyJsPlugin({
//     //   sourceMap: true,
//     //   compress: {
//     //     warnings: false
//     //   }
//     // }),
//     new webpack.LoaderOptionsPlugin({
//       minimize: true
//     })
//   ])
// }
