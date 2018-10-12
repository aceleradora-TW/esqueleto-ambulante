const HardSourceWebpackPlugin = require('hard-source-webpack-plugin');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");

const rootDir = process.env.TRANSPILE_OUTPUT_DIR;
const transpileMode = process.env.TRANSPILE_MODE;

console.log("OUTPUT  >>>>>>>>>>>>>>>>> " + rootDir);
console.log("MODE    >>>>>>>>>>>>>>>>> " + transpileMode);

module.exports = {

    entry: {
        main: './main.js'
    },

    output: {
        path: rootDir
    },

    mode: transpileMode,

    module: {
        rules: [{
            test: /\.sass$/,
            use: [
                MiniCssExtractPlugin.loader,
                'css-loader',
                'sass-loader'
            ]
        }]
    },
    plugins: [
        new MiniCssExtractPlugin({}),
        new HardSourceWebpackPlugin()
    ]

};