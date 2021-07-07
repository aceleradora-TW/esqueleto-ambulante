/* eslint-disable global-require */
const MiniCssExtractPlugin = require('mini-css-extract-plugin');


const path = require('path');

module.exports = {
  rules: [
    {
      test: /\.js$/,
      exclude: /node_modules/,
      use: [
        { loader: 'babel-loader' },
        { loader: 'eslint-loader' },
      ],
    }, {
      test: /\.(sa|sc|c)ss$/,
      use: [
        {
          loader: MiniCssExtractPlugin.loader,
          options: {
            hmr: global.devMode,
          },
        },
        'css-loader',
        {
          loader: 'postcss-loader',
          options: {
            plugins: () => [require('autoprefixer')],
          },
        },
        'sass-loader',
      ],
    },
    {
      test: /.(ttf|otf|eot|svg|woff(2)?)(\?[a-z0-9]+)?$/,
      use: [{
        loader: 'file-loader',
        options: {
          name: '[name].[ext]',
          outputPath: '/fonts',
          publicPath: path.join(global.appRoot, '/src/main/resources/static/'),
        },
      }],
    },
  ],
};
