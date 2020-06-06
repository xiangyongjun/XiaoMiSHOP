/** 
 * api接口的统一封装
 */
import request from '@/axios/interceptor'

// 获取轮播图列表
export function GetBannerList() {
    return request({
        url: 'banners',
        method: 'get'
    })
}

// 获取站点栏列表
export function GetSidebarList() {
    return request({
        url: 'sidebars',
        method: 'get'
    })
}

// 通过sid获取下拉列表
export function GetDropdownBySid(sid) {
    return request({
        url: 'dropdownBySid?sid=' + sid,
        method: 'get'
    })
}

// 获取商品列表
export function GetGoodList() {
    return request({
        url: 'goods',
        method: 'get'
    })
}

// 获取用户列表
export function GetUserList() {
    return request({
        url: 'users',
        method: 'get'
    })
}

// 添加用户
export function AddUser(data) {
    return request({
        url: 'user',
        method: 'post',
        data: data
    })
}

// 删除用户
export function DeleteUser(id) {
    return request({
        url: 'user?id=' + id,
        method: 'delete'
    })
}

// 编辑用户
export function EditUser(data) {
    return request({
        url: 'user',
        method: 'put',
        data: data
    })
}

// 添加轮播图
export function AddBanner(data) {
    return request({
        url: 'banner',
        method: 'post',
        data: data
    })
}

// 删除轮播图
export function DeleteBanner(id) {
    return request({
        url: 'banner?id=' + id,
        method: 'delete'
    })
}

// 编辑轮播图
export function EditBanner(data) {
    return request({
        url: 'banner',
        method: 'put',
        data: data
    })
}

// 添加商品
export function AddGood(data) {
    return request({
        url: 'good',
        method: 'post',
        data: data
    })
}

// 删除商品
export function DeleteGood(id) {
    return request({
        url: 'good?id=' + id,
        method: 'delete'
    })
}

// 编辑商品
export function EditGood(data) {
    return request({
        url: 'good',
        method: 'put',
        data: data
    })
}

// 添加顶栏
export function AddSidebar(data) {
    return request({
        url: 'sidebar',
        method: 'post',
        data: data
    })
}

// 删除顶栏
export function DeleteSidebar(id) {
    return request({
        url: 'sidebar?id=' + id,
        method: 'delete'
    })
}

// 编辑顶栏
export function EditSidebar(data) {
    return request({
        url: 'sidebar',
        method: 'put',
        data: data
    })
}

// 获取下拉列表
export function GetDropdownList() {
    return request({
        url: 'dropdowns',
        method: 'get'
    })
}

// 添加下拉
export function AddDropdown(data) {
    return request({
        url: 'dropdown',
        method: 'post',
        data: data
    })
}

// 删除下拉
export function DeleteDropdown(id) {
    return request({
        url: 'dropdown?id=' + id,
        method: 'delete'
    })
}

// 编辑下拉
export function EditDropdown(data) {
    return request({
        url: 'dropdown',
        method: 'put',
        data: data
    })
}