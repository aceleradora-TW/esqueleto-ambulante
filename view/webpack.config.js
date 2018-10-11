const MiniCssExtractPlugin = require("mini-css-extract-plugin");

const rootDir = process.env.TRANSPILE_OUTPUT_DIR;

console.log(">>>>>>>>>>>>>>>>> " + rootDir);

module.exports = {

    entry: {
        main: './main.js'
    },

    output: {
        path: rootDir
    },

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
        new MiniCssExtractPlugin({})
    ]

};