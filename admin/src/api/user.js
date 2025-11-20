import axios from '@/libs/api.request'

// --------------- 基础部分 ------------------------

// 登录
export const login = ({ userName, password }) => {
  const data = {
    phoneNumber: userName,
    password: btoa(password)
  }
  return axios.request({
    url: '/api/main/login/userPassword',
    method: 'post',
    data: data
  })
}

// 获取用户信息
export const getUserInfo = () => {
  return axios.request({
    url: '/api/main/account/userInfo',
    method: 'get'
  })
}

// --------------- 用户信息 ------------------------

/**
 * 查看所有用户信息
 *
 * @return data
 */
export const userGetAll = formData => {
  return axios.request({
    url: '/api/main/manage/user/getAll',
    method: 'post',
    data: formData
  })
}

/**
 * 查看用户信息细节
 *
 * @return data
 */
export const userDetail = formData => {
  return axios.request({
    url: '/api/main/manage/user/getOne?id=' + formData,
    method: 'get'
  })
}

/**
 * 修改一个用户信息
 *
 * @return data
 */
export const userUpdate = formData => {
  return axios.request({
    url: '/api/main/manage/user/updateOne',
    method: 'post',
    data: formData
  })
}

// --------------- 角色信息 ------------------------

/**
 * 查看所有角色信息
 *
 * @return data
 */
export const roleGetAll = formData => {
  return axios.request({
    url: '/api/main/manage/role/getAll',
    method: 'post',
    data: formData
  })
}

/**
 * 查看角色信息细节
 *
 * @return data
 */
export const roleDetail = formData => {
  return axios.request({
    url: '/api/main/manage/role/getOne?id=' + formData,
    method: 'get'
  })
}

/**
 * 修改一个角色信息
 *
 * @return data
 */
export const roleUpdate = formData => {
  return axios.request({
    url: '/api/main/manage/role/updateOne',
    method: 'post',
    data: formData
  })
}

/**
 * 添加一个角色信息
 *
 * @return data
 */
export const roleAdd = formData => {
  return axios.request({
    url: '/api/main/manage/role/addOne',
    method: 'post',
    data: formData
  })
}

// --------------- 权限信息 ------------------------

/**
 * 查看所有权限信息
 *
 * @return data
 */
export const authGetAll = formData => {
  return axios.request({
    url: '/api/main/manage/auth/getAll',
    method: 'post',
    data: formData
  })
}

/**
 * 查看权限信息细节
 *
 * @return data
 */
export const authDetail = formData => {
  return axios.request({
    url: '/api/main/manage/auth/getOne?id=' + formData,
    method: 'get'
  })
}

/**
 * 修改一个权限信息
 *
 * @return data
 */
export const authUpdate = formData => {
  return axios.request({
    url: '/api/main/manage/auth/updateOne',
    method: 'post',
    data: formData
  })
}

/**
 * 添加一个权限信息
 *
 * @return data
 */
export const authAdd = formData => {
  return axios.request({
    url: '/api/main/manage/auth/addOne',
    method: 'post',
    data: formData
  })
}

// -------------- 默认部分 ------------------
export const logout = (token) => {
  return axios.request({
    url: 'logout',
    method: 'post'
  })
}

export const getUnreadCount = () => {
  return axios.request({
    url: 'message/count',
    method: 'get'
  })
}

export const getMessage = () => {
  return axios.request({
    url: 'message/init',
    method: 'get'
  })
}

export const getContentByMsgId = msg_id => {
  return axios.request({
    url: 'message/content',
    method: 'get',
    params: {
      msg_id
    }
  })
}

export const hasRead = msg_id => {
  return axios.request({
    url: 'message/has_read',
    method: 'post',
    data: {
      msg_id
    }
  })
}

export const removeReaded = msg_id => {
  return axios.request({
    url: 'message/remove_readed',
    method: 'post',
    data: {
      msg_id
    }
  })
}

export const restoreTrash = msg_id => {
  return axios.request({
    url: 'message/restore',
    method: 'post',
    data: {
      msg_id
    }
  })
}
