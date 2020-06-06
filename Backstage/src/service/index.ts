// 正式环境调用service
import service from '../util/request'
// mock数据直接调用axios
import axios from 'axios'

const qs = require('qs')
// const baseUrl = 'https://5dd3847e6625890014a6e6ae.mockapi.io/api/vue3/'
const baseUrl = '/'

export default  {
  login: async (params: Object) => {
    return await axios.get(`${baseUrl}login`, {params}).then(res => res).catch(err => err)
  },

  getAdminList: async (params: any) => {
    return await axios.get(`${baseUrl}admin`, {params}).then(res => res.data).catch(err => err)
  },

  postAdminList: async (params: any) => {
    return await axios.post(`${baseUrl}admin`, { params }).then(res => res).catch(err => err)
  },

  putAdminList: async (params: any) => {
    return await axios.put(`${baseUrl}admin`, { params }).then(res => res).catch(err => err)
  },

  deleteAdminList: async (params: any) => {
    return await axios.delete(`${baseUrl}admin`, { params }).then(res => res).catch(err => err)
  }
}