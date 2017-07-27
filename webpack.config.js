const path = require('path');

const ExtractTextPlugin = require("extract-text-webpack-plugin");
const CopyWebpackPlugin = require('copy-webpack-plugin');
const extractCSS = new ExtractTextPlugin("../css/bundle.css");
const WriteFilePlugin = require('write-file-webpack-plugin');

module.exports = {
  entry: './frontend/js/app.js',
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'src/main/resources/public/js'),
    publicPath: '/'
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /(node_modules)/,
        loader: "babel-loader",
        options: {
          presets: ["env"]
        }
      },
      {
        test: /\.css$/,
        use: extractCSS.extract({
            fallback: "style-loader",
            use: "css-loader"
        })
      },
      {
        test: /\.(png|svg|jpg|gif)$/,
        use: [
          'file-loader'
        ]
      },
      {
        test: /\.(woff|woff2|eot|ttf|otf)$/,
        use: [
          'file-loader'
        ]
      },
       {
         test: /\.(csv|tsv)$/,
         use: [
           'csv-loader'
         ]
       },
       {
         test: /\.xml$/,
         use: [
           'xml-loader'
         ]
       }
    ]
  },
  plugins: [
      extractCSS,
      new CopyWebpackPlugin([{
          from: path.resolve(__dirname, 'frontend/html'),
          to: path.resolve(__dirname, 'src/main/resources/templates')
      }]),
      new WriteFilePlugin()
  ]
};
