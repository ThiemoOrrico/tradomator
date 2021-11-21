import axios from 'axios'

export const getMain = () => {
    return axios.get('/api/coin').then(res => res.data)
}

export const getById = coinId => {
    return axios.get(`/api/coin`).then(res => res.data)
}
