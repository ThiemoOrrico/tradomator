import axios from 'axios'

export const getMain = () => {
    return axios.get('/coingecko-api').then(res => res.data)
}

export const getById = coinId => {
    return axios.get(`/coingecko-api/${coinId}`).then(res => res.data)
}
