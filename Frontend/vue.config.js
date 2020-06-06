module.exports = {
    publicPath: './',
    devServer: {
        proxy: {
            '': {
                target: 'http://localhost',
                changeOrigin: true,
                ws: true,
                pathRewrite: {

                }
            }
        }
    }
}