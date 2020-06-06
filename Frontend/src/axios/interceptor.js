import axios from 'axios'
import qs from 'qs'

const instance = axios.create({
    baseURL: '/api', // api的base_url
    timeout: 10000, // 请求超时时间
    transformRequest: data => qs.stringify(data) //
})

instance.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'

// request拦截器
instance.interceptors.request.use(
    e => {
        e.params = e.params || {}
        e.headers = e.headers || {}
        //set 默认值
        return e
    },
    error => ({ status: 0, msg: error.message })
)

// respone拦截器
instance.interceptors.response.use(
    response => {
        const resp = response.data
        if (response.status === 200) {
            return resp
        }
        return resp
    },
    error => {
        window.console.log('err' + error) // for debug
        return Promise.reject(error)
    }
)
export default instance