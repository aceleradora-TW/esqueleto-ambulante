const UglifyJsPlugin = require('uglifyjs-webpack-plugin');
module.exports = {
  minimizer: [
    new UglifyJsPlugin({
      test: /\.js(\?.*)?$/i,
      extractComments: 'all',
      sourceMap: true,
      uglifyOptions: {
        warnings: false,
        parse: {},
        compress: { warnings: false },
        mangle: true,
        output: { comments: false },
        toplevel: false,
        nameCache: null,
        ie8: false,
        keep_fnames: false,
      },
    }),
  ],
}