import axios from "axios";

const getHeader = (token) => {

    return {
        headers: {
            Authorization: `Bearer ${token}`
        },
    }
}

export const getWallet = (token) => {
    return axios
        .get('/api/wallet', getHeader(token))
        .then(res => res.data)
}